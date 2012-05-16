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
import com.google.common.base.Joiner; 
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.common.base.Strings;

import es.uem.geolocation.client.Constant;
import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSServiceAsync;
import es.uem.geolocation.client.view.MapView;
import es.uem.geolocation.client.view.Resources;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.RSS;
import es.uem.geolocation.shared.Toponym;

/**
 * Add click event to a marker.
 * 
 * Zooms in to level '4' on click on the marker.
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
			System.out.println(uri);
			rssService.loadRSSNews(uri, new AsyncCallback<RSS>() {

				@Override
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

							handleRSS();
						}
					}
					else {
						display.setState("Imposible cargar información fuente RSS \"" + uri + "\".");						
					}
				}

				@Override
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
	}	
		
	private void handleRSS() {					
		for (Article article : articles) {				
			String categories = ""; 
			if (article.getCategories() != null && article.getCategories().size() > 0) {
				categories = Joiner.on(", ").skipNulls().join(article.getCategories()); 
			}
			
			String headline = article.getHeadline();  
			String description = article.getDescription(); 			
			String newArticle = Joiner.on(" ").skipNulls().join(categories, headline, description);
			
			System.out.println("Categories " + newArticle);
			//System.out.println("Noticia " + news);

			if (!Strings.isNullOrEmpty(categories)) {
				handleNER(categories, article);				
				//Error
				//System.out.println(" Locations ==> " + article.getLocations().toString());				
			}			
			
								
		}				
	}
		
	private void handleNER(String text, final Article article) {  
		try {
			gateService.getNamedEntities(text, new AsyncCallback<List<String>>() {
				@Override
				public void onSuccess(List<String> locations) {
					article.setLocations(locations); 
				}

				@Override
				public void onFailure(Throwable caught) {
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}		 
	}
	
	/**
	 * Anexando articulos
	 * 
	 * @param marker
	 *            Marcador
	 * @param articles
	 *            Lista de articulos
	 */
	private void attachArticles(final HasMarker marker,
			final List<Article> articles) {

		final List<Anchor> anchors = new ArrayList<Anchor>();
		final StringBuffer content = new StringBuffer();
		int numArticles = articles.size();
		for (int i = 0; i < numArticles; i++) {
			final Article article = articles.get(i);
			content.append(article.getHeadline() + "."
					+ article.getDescription());
			Anchor anchor = new Anchor(article.getHeadline());
			// anchor.setText(article.getHeadline() + "." +
			// article.getDescription());
			anchors.add(anchor);
			Label label = new Label(article.getDescription());
		}
		final HasInfoWindow infoWindow = display.createInfoWindow(content
				.toString());

		for (Anchor anchor : anchors) {
			anchor.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					infoWindow.open(display.getMap(), marker);
				}
			});
			display.getNewsList().add(anchor);
			display.getNewsList().add(new Label("aaaa adasda"));
		}

		// Click for marker.
		display.addListener(marker, "click", new EventCallback() {
			@Override
			public void callback() {
				infoWindow.open(display.getMap(), marker);
			}
		});
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
