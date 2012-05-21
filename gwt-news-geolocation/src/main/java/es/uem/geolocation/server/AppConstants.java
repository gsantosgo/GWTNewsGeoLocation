package es.uem.geolocation.server;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {		
	// Proxy Configuration 
	public String isProxy();	
	public String proxyHostName();
	public int proxyPort(); 
	
	// Web Services Geonames
	public String geonamesWebServiceUsername();  
}
