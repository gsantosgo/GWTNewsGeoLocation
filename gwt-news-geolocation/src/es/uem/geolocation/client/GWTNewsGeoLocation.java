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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

import es.uem.geolocation.client.services.GateService;
import es.uem.geolocation.client.services.GateServiceAsync;
import es.uem.geolocation.client.services.GeonamesService;
import es.uem.geolocation.client.services.GeonamesServiceAsync;
import es.uem.geolocation.client.services.RSSService;
import es.uem.geolocation.client.services.RSSServiceAsync;

/**
 *  
 * Class Entry Point <code>onModuleLoad()</code>
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class GWTNewsGeoLocation implements EntryPoint {
	/**
	 * onModuleLoad
	 */
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				e.printStackTrace();
			}
		});
		
		// Servicio RSS 
		RSSServiceAsync geoRSSService = GWT.create(RSSService.class);
		// Servicio GATE 
		GateServiceAsync gateService = GWT.create(GateService.class);
		// Servicio Geonames 		
		GeonamesServiceAsync geonamesService = GWT.create(GeonamesService.class);
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(geoRSSService, gateService, geonamesService, eventBus);
	    appViewer.go(RootPanel.get("application"));			
	}
}