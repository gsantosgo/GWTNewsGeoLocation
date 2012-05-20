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
import com.google.common.primitives.Doubles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.maps.client.HasJso;
import com.google.gwt.maps.client.HasMap;
import com.google.gwt.maps.client.base.HasInfoWindow;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.base.HasLatLngBounds;
import com.google.gwt.maps.client.event.EventCallback;
import com.google.gwt.maps.client.overlay.HasMarker;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSServiceAsync;
import es.uem.geolocation.client.view.Resources;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.RSS;
import es.uem.geolocation.shared.Toponym;

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
		// State line (Information) 
		void setState(String state);
		
		// News list 
		VerticalPanel getNewsList();
	}
	
	private final RSSServiceAsync rssService;
	private final GateServiceAsync gateService;
	private final GeonamesServiceAsync geonamesService;
	private final HandlerManager eventBus;
	private final ArrayList<HasMarker> markers;
	private List<Article> articles;
	private List<Article> articlesNER;
	private final Display display;
	private final String uri;
	private final Resources resources = GWT.create(Resources.class);
		
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
		this.markers = new ArrayList<HasMarker>();
		this.articles = new ArrayList<Article>();
		this.articlesNER = new ArrayList<Article>(); 
		this.uri = uri;  
	}

	/**
	 * Fetching news
	 * 
	 * @param uri
	 */
	private void fetchRSSNews(final String uri) {
		display.setState("Accediendo a fuente RSS ..." + uri);
		display.setState("Cargando fuente RSS ..." + uri + ". Espere ... ");
		
		// RSS Request =====
		try {			
			rssService.loadRSSNews(uri, new AsyncCallback<RSS>() {
				public void onSuccess(RSS rssSource) {
					if (rssSource != null) {
						// RSS Information =====
						display.setState("Cargando información fuente RSS \""
								+ rssSource.getTitle() + "\"...");
						display.setSourceRSSTitle(rssSource.getTitle());
						display.setSourceRSSLink(uri);
						display.setSourceRSSCopyright(rssSource.getCopyright());

						// Articles
						articles = rssSource.getItems();						
						if (articles != null && articles.size() > 0) {
							int articlesCount = articles.size();
							display.setState("Cargando " + articlesCount
									+ " articulos de noticias...");

							handleNER(articles); 
						}
					}
					else {
						display.setState("Imposible cargar información fuente RSS \"" + uri + "\".");						
					}
				}

				//@Override
				public void onFailure(Throwable caught) {
					display.setState(""); 
					Window.alert("Fallo. Imposible cargar información fuente RSS \""
							+ uri + "\".");
				}
			});
		} catch (Exception e) {
			display.setState("");
			Window.alert("Fallo. Error acceso fuente RSS \"" + uri + "\".");
		}		
		display.setState("Procesando RSS ..."); 		
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
					System.out.println("Localizaciones " + articlesResult.toString()); 								
					display.setState("Reconocimiento de Entidades Nombradas (Nombres Lugares) realizado con exito.");					
					handleGeonames(articlesResult); 										
				}

				//@Override
				public void onFailure(Throwable caught) {
					display.setState(""); 
					Window.alert("Fallo. Imposible reconocer entidades nombradas.");
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		display.setState("Reconocimiento de Entidades Nombradas (Nombres Lugares)...");
	}
	

	/**
	 * Geonames 
	 * 
	 * @param articles the List of articles 
	 */
	private void handleGeonames(List<Article> articles) {						
		geonamesService.toponymSearchCriteria(articles, new AsyncCallback<List<NewMap>>() {			
			public void onSuccess(List<NewMap> result) {
				
				for (NewMap newMap : result) {										
					// OJO!! 
					System.out.println("newMap " + newMap.toString());
					// No location 
					if (newMap.getLatitude() == null && 
						newMap.getLongitude() == null)  {						
						attachArticles(newMap.getArticles());
					// Location 
					} else {						
						final HasLatLng location = display.createLatLng(newMap.getLatitude(), newMap.getLongitude());
						final HasMarker marker = display.createMarkerAt(location);
						markers.add(marker);
						marker.setTitle(newMap.getPlacename());
						attachArticles(marker, newMap.getArticles());												
					}
				}			
			}
			
			public void onFailure(Throwable caught) {
				
				
			}
		});						
		display.setState("Obteniendo puntos geográficos de noticias...");				
	}
	

	
	/**
	 * 
	 * Attach articles on Map 
	 * 
	 * @param articles the List of articles 
	 *           
	 */
	private void attachArticles(final List<Article> articles) {		
		if (articles != null && articles.size() > 0) {
			for (Article article : articles) {
				Anchor headlineAnchor = new Anchor(article.getHeadline());				
				HTML descriptionHTML = new HTML(article.getDescription());		
				
				display.getNewsList().add(new Image(resources.news()));
				display.getNewsList().add(headlineAnchor);
				display.getNewsList().add(descriptionHTML);							
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

			// Display news 
			for (Article article : articles) {								
				Anchor headlineAnchor = new Anchor(article.getHeadline());			
				HTML descriptionHTML = new HTML(article.getDescription());									 
				headlineAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						infoWindow.open(display.getMap(), marker);
					}
				});
				display.getNewsList().add(new Image(resources.news()));				
				display.getNewsList().add(headlineAnchor);
				display.getNewsList().add(descriptionHTML); 
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
