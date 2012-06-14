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

package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.HasJso;
import com.google.gwt.maps.client.HasMap;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.HasInfoWindow;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.base.HasLatLngBounds;
import com.google.gwt.maps.client.base.InfoWindow;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.event.Event;
import com.google.gwt.maps.client.event.EventCallback;
import com.google.gwt.maps.client.overlay.HasMarker;
import com.google.gwt.maps.client.overlay.HasMarkerImage;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import es.uem.geolocation.client.Constant;
import es.uem.geolocation.client.presenter.GeoRSSPresenter;

/**
 * 
 *  Map View  
 * 
 * @author Guillermos Santos (gsantosgo@yahoo.es)
 */

// public class MapViewImpl<T> extends Composite implements MapView<T> {
public class MapView extends Composite implements GeoRSSPresenter.Display {

	@UiTemplate("MapView.ui.xml")	
	interface MapViewUiBinder extends UiBinder<Widget, MapView> {}	
	private static MapViewUiBinder uiBinder = GWT.create(MapViewUiBinder.class);
			
	final private static int ZOOM = 2;
	final private static LatLng CENTER = new LatLng(0.0, 0.0);	
	final private static String MAP_TYPE = new MapTypeId().getRoadmap();

	private MapWidget mapWidget; 
			
	@UiField
	MenuBar menuBar;
	
	// LARAZON.ES
	@UiField
	MenuItem larazonGeneralesMenuItem;	
	@UiField
	MenuItem larazonEspanaMenuItem;
	@UiField
	MenuItem larazonInternacionalMenuItem;	
	

	// ELMUNDO.ES
	@UiField
	MenuItem elmundoPortadaMenuItem; 			
	@UiField
	MenuItem elmundoEspanaMenuItem;
	@UiField
	MenuItem elmundoInternacionalMenuItem; 
	
	// ELPAIS.COM
	@UiField
	MenuItem elpaisPortadaMenuItem; 
	@UiField
	MenuItem elpaisUltimaNoticiasMenuItem;
	@UiField
	MenuItem elpaisInternacionalMenuItem; 
	
	// Local News 
	@UiField
	MenuItem rssLocalNacionalMenuItem;  
	@UiField
	MenuItem rssLocalInternacionalMenuItem;

	@UiField
	MenuItem helpMenuItem; 

	@UiField
	MenuItem aboutMenuItem; 

	@UiField
	Label sourceRSSTitle;
	@UiField
	Anchor sourceRSSLink;
	@UiField
	Label sourceRSSCopyright; 

	@UiField
	Label countNewsRSS;
	@UiField
	Label countNewsRSSGeoLocation;
	/*@UiField
	Label countNewsRSSNoGeoLocation;*/ 

	@UiField 
	Label status; 
	
	@UiField
	SimplePanel contentNews;	
		
	@UiField
	SimplePanel mapWrapper;
	
	@UiField 
	VerticalPanel newsList;	
	
	/**
	 * Constructor 
	 */
	public MapView() {
		initWidget(uiBinder.createAndBindUi(this));		
		initMap();  			
		
		// ABC.es 
		larazonGeneralesMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("larazonGeneralesMenuItem"); 							
			}
		});
						
		larazonEspanaMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {			
				History.newItem("larazonEspanaMenuItem");							
			}
		}); 
		
		larazonInternacionalMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {			
				History.newItem("larazonInternacionalMenuItem");							
			}
		}); 
		
		// ELMUNDO.ES
		elmundoPortadaMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {			
				History.newItem("elmundoPortadaMenuItem");			
			}
		});
		
		elmundoEspanaMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {			
				History.newItem("elmundoEspanaMenuItem");							
			}
		});
		
		elmundoInternacionalMenuItem.setCommand(new Command() {					
			public void execute() {			
				History.newItem("elmundoInternacionalMenuItem");							
			}
		});
		
		// Enlace PAIS 
		elpaisPortadaMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("elpaisPortadaMenuItem");
			}
		});
		
		elpaisUltimaNoticiasMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("elpaisUltimaNoticiasMenuItem");				
			}
		});						
		
		elpaisInternacionalMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("elpaisInternacionalMenuItem");				
			}					
		});	

		rssLocalNacionalMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("rssLocalNacionalMenuItem");
			}					
		});		
		
		rssLocalInternacionalMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				History.newItem("rssLocalInternacionalMenuItem");
			}					
		});	
		
		
		helpMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				HelpDialogBox helpDialog = new HelpDialogBox(); 
				helpDialog.setText("Ayuda");
				helpDialog.center(); 
			}					
		});		
		
		aboutMenuItem.setCommand(new Command() {			
			//@Override
			public void execute() {
				AboutDialogBox aboutDialog = new AboutDialogBox();
				aboutDialog.setText("Acerca de ..."); 
				aboutDialog.center();
			}					
		});		
	}

	public HasMap getMap() {
		return mapWidget.getMap();
	}

	public void fitBounds(HasLatLngBounds bounds) {
		mapWidget.fitBounds(bounds);
		
	}

	public HasLatLng createLatLng(double lat, double lng) {
		return new LatLng(lat, lng);
	}

	public HasLatLngBounds createBounds(HasLatLng southWest, HasLatLng northEast) {
		return new LatLngBounds(southWest, northEast);
	}

	/**
	 * Create marker on the map. 
	 */
	public HasMarker createMarkerAt(HasLatLng position) {
		final Marker marker = new Marker();		  
		marker.setMap(getMap());
		marker.setPosition(position);
		return marker;
	}
	
	/**
	 * Create custom marker on the map. 
	 */
	public HasMarker createCustomMarkerAt(HasLatLng position, HasMarkerImage markerImage) {
		final Marker marker = new Marker();		  
		marker.setIcon(markerImage); 
		marker.setMap(getMap());
		marker.setPosition(position);
		return marker;
	}	

	/* 
	 * (non-Javadoc)
	 * @see es.uem.geolocation.client.presenter.GeoRSSPresenter.Display#createInfoWindow(java.lang.String)
	 */
	public HasInfoWindow createInfoWindow(String content) {
		final InfoWindow infoWindow = new InfoWindow();
		infoWindow.setContent(content);
		
		return infoWindow;
	}

	/**
	 * Add event listener 
	 */
	public void addListener(HasJso instance, String eventName,
			EventCallback callback) {
		Event.addListener(instance, eventName, callback);		
	}

	public void clearInstanceListeners(HasJso instance) {
		Event.clearInstanceListeners(instance);		
	}	
			
	public VerticalPanel getNewsList() {
		return this.newsList; 
	}
		
	public Widget asWidget() {
		return this;
	}

	public void setStatus(String text) {
		this.status.setText(text); 		
	}

	/**
	 * Set Source RSS Name (Description)  
	 */
	public void setSourceRSSTitle(String title) {
		this.sourceRSSTitle.setText(title); 		
	}

	/**
	 * Set Source RSS Link (Link)
	 */
	public void setSourceRSSLink(String url) {		
		this.sourceRSSLink.setText(url);
		this.sourceRSSLink.setHref(url);		
	}

	/**
	 * Set Source RSS Copyright
	 */
	public void setSourceRSSCopyright(String text) {
		this.sourceRSSCopyright.setText(text); 
	}

	public void setCountNewsRSS(String value) {
		this.countNewsRSS.setText(value); 		
	}
	
	public void setCountNewsRSSGeoLocation(String value) {
		this.countNewsRSSGeoLocation.setText(value); 		
	}	

/*	public void setCountNewsRSSNoGeoLocation(String value) {
		this.countNewsRSSNoGeoLocation.setText(value); 		
	}*/ 	
	
	/**
	 * Map init 
	 */
	private void initMap() {
		final MapOptions options = new MapOptions();				 
		options.setZoom(ZOOM);
		options.setCenter(CENTER);
		options.setMapTypeId(MAP_TYPE);
		options.setDraggable(true);
		options.setNavigationControl(true);
		options.setMapTypeControl(true);
		mapWidget = new MapWidget(options);
		mapWidget.setSize(Constant.MAP_WIDTH, Constant.MAP_HEIGHT);
		mapWrapper.clear(); 
		mapWrapper.setWidget(mapWidget);				
	}
	
	/**
	 * Initialize widgets 
	 */
	public void initWidgets() {
		this.setSourceRSSTitle("");
		this.setSourceRSSLink("");
		this.setSourceRSSCopyright("");
		this.setCountNewsRSS("");
		this.setCountNewsRSSGeoLocation("");
		//this.setCountNewsRSSNoGeoLocation(""); 
		this.setStatus("");
		this.newsList.clear();  
	}

	/**
	 * Reset GWT User Interface  (UI)  
	 */
	public void reset() {
		initWidgets(); 
		initMap();		
	}
		
}
