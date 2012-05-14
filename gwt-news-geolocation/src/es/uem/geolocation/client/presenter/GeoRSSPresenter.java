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
import com.google.gwt.maps.client.base.HasInfoWindow;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.event.EventCallback;
import com.google.gwt.maps.client.overlay.HasMarker;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSServiceAsync;
import es.uem.geolocation.client.view.MapView;
import es.uem.geolocation.client.view.Resources;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.Toponym;

/**
 * Add click event to a marker.
 * 
 * Zooms in to level '4' on click on the marker.
 * 
 * @author Guillermos Santos (gsantosgo@yahoo.es)
 */
public class GeoRSSPresenter implements Presenter, MapView.Presenter<NewMap> {

	private final RSSServiceAsync rssService;
	private final GateServiceAsync gateService;
	private final GeonamesServiceAsync geonamesService;
	private final HandlerManager eventBus;
	private final MapView<NewMap> view;
	private final ArrayList<HasMarker> markers;

	/**
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
			HandlerManager eventBus, MapView<NewMap> view) {
		super();
		this.rssService = rssService;
		this.gateService = gateService;
		this.geonamesService = geonamesService;
		this.eventBus = eventBus;
		this.view = view;
		this.markers = new ArrayList<HasMarker>();
	}

	/**
	 * Fetching news
	 * 
	 * @param uri
	 */
	private void fetchRSSNews(String uri) {
		try {
			view.setFuenteRSSLink(uri);
			view.setState("Cargando fuente RSS ..." + uri);
			final List<NewMap> newMapList = new ArrayList<NewMap>();
			final List<Article> articleList = new ArrayList<Article>();
			rssService.loadRSSNews(uri, new AsyncCallback<List<Article>>() {
				public void onSuccess(List<Article> articles) {
					int resultados = articles.size();
					view.setState("Cargando " + resultados + " noticias");

					if (articles != null && resultados > 0) {
						// final List<Anchor> anchors = new ArrayList<Anchor>();
						final HTML cabecera = new HTML(
								"<b>Noticias encontradas: " + resultados
										+ "</b>");
						view.getNewsList().add(cabecera);

						Resources resources = GWT.create(Resources.class);
						// final Image imagenNews = new Image(Resources.)
						for (int i = 0; i < resultados; ++i) {
							final Article article = articles.get(i);

							// Servicio Gate Service
							try {
								gateService.getNamedEntities(
										article.getHeadline()
												+ article.getDescription(),
										new AsyncCallback<List<String>>() {

											public void onSuccess(
													List<String> toponymList) {
												// System.out.println("Salida GateService"
												// + result.toString());
												int toponyms = toponymList
														.size();
												if (toponyms > 0) {
													for (String toponymName : toponymList) {
														System.out
																.println(toponymName);

														geonamesService
																.toponymSearchCriteria(
																		toponymName,
																		new AsyncCallback<List<Toponym>>() {

																			public void onSuccess(
																					List<Toponym> toponyms) {
																				System.out
																						.println("Toponimos "
																								+ toponyms
																										.size());

																				// Toponym
																				if (toponyms
																						.size() > 0) {

																					System.out
																							.println("Toponym "
																									+ toponyms
																											.toString());
																					NewMap newMap = new NewMap();
																					newMap.setPlacename(toponyms
																							.get(0)
																							.getName());
																					newMap.setLatitude(toponyms
																							.get(0)
																							.getLatitude());
																					newMap.setLongitude(toponyms
																							.get(0)
																							.getLongitude());
																					System.out
																							.println(" ===> "
																									+ newMap.toString());
																					final HasLatLng location = view
																							.createLatLng(
																									newMap.getLatitude(),
																									newMap.getLongitude());
																					System.out
																							.println(location
																									.toString());

																					final HasMarker marker = view
																							.createMarkerAt(location);
																					markers.add(marker);
																					marker.setTitle(newMap
																							.getPlacename());
																					articleList
																							.add(article);

																					attachArticles(
																							marker,
																							articleList);
																				}
																			}

																			
																			public void onFailure(
																					Throwable caught) {
																				Window.alert("Error obteniendo geolocalización de noticias");
																			}
																		});
													}
												}
											}

											
											public void onFailure(
													Throwable caught) {
												Window.alert("Error obteniendo localizaciones de noticias");
											}
										});
							} catch (Exception e) {
								e.printStackTrace();
							}

							Anchor anchor = new Anchor(article.getHeadline());
							HTML description = new HTML(article
									.getDescription());
							view.getNewsList().add(new Image(resources.news()));
							view.getNewsList().add(anchor);
							view.getNewsList().add(description);
						}
					}
				}

				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub

				}
			});
		} catch (Exception e) {
			// Falta
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
		final HasInfoWindow infoWindow = view.createInfoWindow(content
				.toString());

		for (Anchor anchor : anchors) {
			anchor.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					infoWindow.open(view.getMap(), marker);
				}
			});
			view.getNewsList().add(anchor);
			view.getNewsList().add(new Label("aaaa adasda"));
		}

		// Click for marker.
		view.addListener(marker, "click", new EventCallback() {
			@Override
			public void callback() {
				infoWindow.open(view.getMap(), marker);
			}
		});
	}

	public void go(final HasWidgets container) {
		container.clear();
		view.setFuenteRSS("holaaaaaaa");
		String uri = "http://elmundo.feedsportal.com/elmundo/rss/portada.xml";
		view.setFuenteRSSLink(uri);
		container.add(view.asWidget());
		// RootPanel.get("state").clear();

		// RootPanel.get("state").add(new Label(uri));
		fetchRSSNews(uri);
		// RootPanel.get("state").clear();
	}

}
