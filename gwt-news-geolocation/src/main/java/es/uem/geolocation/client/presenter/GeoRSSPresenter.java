/* Copyright (c) 2012 Guillermo Santos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.uem.geolocation.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.maps.client.HasJso;
import com.google.gwt.maps.client.HasMap;
import com.google.gwt.maps.client.base.HasInfoWindow;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.base.HasLatLngBounds;
import com.google.gwt.maps.client.event.EventCallback;
import com.google.gwt.maps.client.overlay.HasMarker;
import com.google.gwt.maps.client.overlay.HasMarkerImage;
import com.google.gwt.maps.client.overlay.MarkerImage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import es.uem.geolocation.client.AppConstants;
import es.uem.geolocation.client.AppMessages;
import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSServiceAsync;
import es.uem.geolocation.client.view.Resources;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.RSS;

/**
 * GeoRSS Presenter
 *
 * 
 * @author Guillermos Santos (gsantosgo@yahoo.es)
 */
public class GeoRSSPresenter implements Presenter {

	public interface Display {
		HasLatLngBounds createBounds(HasLatLng southWest, HasLatLng northEast);
		HasInfoWindow createInfoWindow(String content);
		HasLatLng createLatLng(double lat, double lng);
		HasMarker createMarkerAt(HasLatLng position);
		HasMarker createCustomMarkerAt(HasLatLng position, HasMarkerImage markerImage); 
		void fitBounds(HasLatLngBounds bounds);
		HasMap getMap();										
		void reset();
		
		void addListener(HasJso instance, String eventName,
				EventCallback callback);
		void clearInstanceListeners(HasJso instance);
		
		Widget asWidget();		
 
		// Source RSS (Information)  
		void setSourceRSSTitle(String title);
		void setSourceRSSLink(String url);
		void setSourceRSSCopyright(String text);
		
		// Count News 
		void setCountNewsRSS(String value);
		void setCountNewsRSSGeoLocation(String value);
		//void setCountNewsRSSNoGeoLocation(String value); 
		
		// Status (Information) 
		void setStatus(String text);
		
		// News list 
		VerticalPanel getNewsList();
	}
	
	private final RSSServiceAsync rssService;
	private final GateServiceAsync gateService;
	private final GeonamesServiceAsync geonamesService;
	private final HandlerManager eventBus;
	private final ArrayList<HasMarker> markers;
	private List<Article> articles;
	private final Display display;
	private final String uri;
	private final Resources resources = GWT.create(Resources.class);
	private AppConstants constants =  GWT.create(AppConstants.class);
	private AppMessages messages = GWT.create(AppMessages.class);	
	private String urlMarkerImage = constants.markerImage();
		
	/**
	 * 
	 * Constructor
	 * 
	 * @param RSSService
	 *            RSS Service
	 * @param gateService
	 *            GATE-ANNIE Service
	 * @param geonamesService
	 *            Geonames Service
	 * @param eventBus
	 *            Eventbus
	 * @param view
	 *            View
	 */
	public GeoRSSPresenter(RSSServiceAsync rssService,
			GateServiceAsync gateService, GeonamesServiceAsync geonamesService,
			HandlerManager eventBus, Display view, String uri) {
		super();
		this.rssService = rssService;
		this.gateService = gateService;
		this.geonamesService = geonamesService;
		this.eventBus = eventBus;
		this.display = view;
		this.markers = Lists.newArrayList();
		this.articles = Lists.newArrayList();  
		this.uri = uri;
	}

	/**
	 * Fetching news
	 * 
	 * @param uri
	 */
	private void fetchRSSNews(final String uri) {
		display.setStatus(messages.fetchRSS(uri));
		display.setStatus(messages.loadingRSS(uri));
		
		// RSS Request =====
		try {								
			rssService.loadRSSNews(uri, new AsyncCallback<RSS>() {
				public void onSuccess(RSS rssSource) {
					if (rssSource != null) {
						// RSS Information =====
						//display.setStatus(messages.infoRSS(rssSource.getTitle()));
						display.setSourceRSSTitle(rssSource.getTitle());
						display.setSourceRSSLink(uri);
						display.setSourceRSSCopyright(rssSource.getCopyright());

						// Articles
						articles = rssSource.getItems();									
						if (articles != null && articles.size() > 0) {
							int articlesCount = articles.size();
							display.setStatus(messages.loadingRSSArticles(articlesCount)); 
							display.setCountNewsRSS(""+articlesCount); 

							handleNER(articles); 
						}
					}
					else {
						display.setStatus(messages.processingRSSNoInformation(uri));						
					}
				}

				//@Override
				public void onFailure(Throwable caught) {
					display.setStatus(""); 
					Window.alert(messages.processingRSSFailure(uri));
				}
			});
		} catch (Exception e) {
			display.setStatus("");
			Window.alert(messages.processingRSSException(uri));
		}		
		display.setStatus(messages.processingRSS()); 		
	}	
	
	/**
	 * Named Entities Recognition 
	 * 
	 * @param articles the List of articles 
	 */
	private void handleNER(List<Article> articles) {  
		try {
			gateService.getNamedEntities(articles, new AsyncCallback<List<Article>>() {
				//@Override
				public void onSuccess(List<Article> articlesResult) {
					display.setStatus(messages.processingNERSuccess()); 					
					handleGeonames(articlesResult);				
				}

				//@Override
				public void onFailure(Throwable caught) {
					display.setStatus(""); 
					Window.alert(messages.processingNERFailure());
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			Window.alert(messages.processingNERException());
		}		 		
		display.setStatus(messages.processingNER());
	}
	

	/**
	 * News geolocation. Geonames Handling  
	 * 
	 * @param articles the List of Articles 
	 */
	private void handleGeonames(List<Article> articles) {						
		geonamesService.toponymSearchCriteria(articles, new AsyncCallback<List<NewMap>>() {			
			public void onSuccess(List<NewMap> result) {
				
				for (NewMap newMap : result) {										
					// OJO!! 
					//System.out.println("newMap " + newMap.toString());
					// No location 
					if (newMap.getLatitude() == null && 
						newMap.getLongitude() == null)  {						
						attachArticles(newMap.getArticles());
					// Location 
					} else {						
						final HasLatLng location = display.createLatLng(newMap.getLatitude(), newMap.getLongitude());							
						final HasMarker marker = display.createCustomMarkerAt(location, new MarkerImage.Builder(urlMarkerImage).build());
						markers.add(marker);
						marker.setTitle(newMap.getPlacename());						
						attachArticles(marker, newMap.getArticles());												
					}
					display.setCountNewsRSSGeoLocation("" + markers.size());
					display.setStatus("");
				}			
			}
			
			public void onFailure(Throwable caught) {				
				display.setStatus(""); 
				Window.alert(messages.processingNERFailure());							
			}
		});									
		display.setStatus(messages.processingGeocoding());				
	}
		
	/**
	 * 
	 * Attach articles on Map 
	 * 
	 * @param articles the List of articles 
	 *           
	 */
	private void attachArticles(final List<Article> articles) {
		final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(constants.formatDateTime());
		if (articles != null && articles.size() > 0) {
			for (Article article : articles) {
				Anchor headlineAnchor = new Anchor(article.getHeadline());				
				HTML descriptionHTML = new HTML(article.getDescription());		
				
				display.getNewsList().add(new Image(resources.news()));
				display.getNewsList().add(new HTML(dateTimeFormat.format(article.getPublishedDate()))); 
				display.getNewsList().add(headlineAnchor);
				display.getNewsList().add(descriptionHTML);
				String categories = Joiner.on(", ").skipNulls().join(article.getCategories());
				if (!Strings.isNullOrEmpty(categories)) { 
					display.getNewsList().add(new HTML("Categorías: " + categories));
				}
				display.getNewsList().add(new HTML("<hr/>"));
			}
		}	
	}
	
	/**
	 * 
	 * Attach articles on Map 
	 * 
	 * @param marker the Marker
	 * @param articles the List of articles 
	 *           
	 */
	private void attachArticles(final HasMarker marker, final List<Article> articles) {
		final StringBuffer content = new StringBuffer();		
		if (articles != null && articles.size() > 0) {
			for (Article article : articles) {
				content.append(infoWindowContent(article.getHeadline(),article.getDescription()));				
			}
			
			final HasInfoWindow infoWindow = display.createInfoWindow(content.toString());	

			final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(constants.formatDateTime());
			// Display news 
			for (Article article : articles) {		
				 
				Anchor headlineAnchor = new Anchor(article.getHeadline());			
				HTML descriptionHTML = new HTML(article.getDescription());									 
				headlineAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						infoWindow.open(display.getMap(), marker);
					}
				});
				display.getNewsList().add(new Image(resources.newsGeo()));				
				display.getNewsList().add(new HTML(dateTimeFormat.format(article.getPublishedDate())));
				display.getNewsList().add(headlineAnchor);
				display.getNewsList().add(descriptionHTML); 
				String categories = Joiner.on(", ").skipNulls().join(article.getCategories());
				if (!Strings.isNullOrEmpty(categories)) { 
					display.getNewsList().add(new HTML("Categorías: " + categories));
				}				
				display.getNewsList().add(new HTML("<hr/>"));
			}	
			
			// Click for marker.
			display.addListener(marker, "click", new EventCallback() {
				@Override
				public void callback() {
					infoWindow.open(display.getMap(), marker);
				}
			});			
		}				
	}
	
	private String infoWindowContent(String title, String content) { 
		final StringBuffer sb = new StringBuffer();
		sb.append("<div>");
		sb.append("<div class=\"contentTxt\">");
		sb.append("<h2>"); 
		sb.append(title); 
		sb.append("</h2>");
		sb.append("<p>");
		sb.append(content);
		sb.append("</p>");
		sb.append("</div>");
		sb.append("<div class=\"clear\"></div>");
		sb.append("</div>");
		
		return sb.toString(); 
	}
	
	
	/**
	 * Takes the widget in which we wish the presenter-associated 
	 * view associated to be displayed. 
	 */
	public void go(final HasWidgets container) {
		container.clear();
		display.reset(); 
		container.add(display.asWidget());
		if (!Strings.isNullOrEmpty(uri)) fetchRSSNews(uri);	
	}	
	  
}
