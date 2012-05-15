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
package es.uem.geolocation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.common.base.Strings;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import es.uem.geolocation.client.presenter.GeoRSSPresenter;
import es.uem.geolocation.client.presenter.Presenter;
import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSServiceAsync;
import es.uem.geolocation.client.view.MapView;
import es.uem.geolocation.shared.NewMap;

/**
 * Controlador para escuchar eventos y tomar acciones relevantes.
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final RSSServiceAsync rssService;
	private final GateServiceAsync gateService; 
	private final GeonamesServiceAsync geonamesService;
	private MapView view = null;   
	private HasWidgets container;

	/**
	 * Constructor Controlador
	 * 
	 * @param geoRSSService
	 *            Servicio GeoRSS
	 * @param eventBus
	 */
	public AppController(RSSServiceAsync rssService,
			GateServiceAsync gateService,
			GeonamesServiceAsync geonamesService,
			HandlerManager eventBus) {
		super();
		this.rssService = rssService;
		this.gateService = gateService;
		this.geonamesService = geonamesService; 
		this.eventBus = eventBus;
		bind();
	}

	/**
	 * 
	 */
	private void bind() {
		History.addValueChangeHandler(this);
	}

	public void onValueChange(ValueChangeEvent<String> event) {		
		String token = event.getValue();
		String uri = null; 		
		
		if (view == null) {
			view = new MapView(); 
		}
		if (token != null) {
			Presenter presenter = null; 
			if (token.equals("display")) {
				System.out.println("onSuccess entra.display");
			}
			else {
				System.out.println("onSuccess entra.other");
				uri = Constant.MENU_LIST.get(token); 				
			} 
			presenter = new GeoRSSPresenter(
						rssService, 
						gateService, 
						geonamesService,
						eventBus,
						view,
						Strings.nullToEmpty(uri));  				
		
			if (presenter != null) {
				presenter.go(container); 
			}
		}
	}

	public void go(HasWidgets container) {
		this.container = container;
		if ("".equals(History.getToken())) {
			History.newItem("display");
		} else {
			History.fireCurrentHistoryState();
		}
	}
}
