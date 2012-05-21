package es.uem.geolocation.server;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {		
	// Proxy Configuration 
	@DefaultBooleanValue(true)	
	public boolean isProxy();
	@DefaultStringValue("10.14.79.204")
	public String proxyHostName();
	@DefaultIntValue(8080)
	public int proxyPort(); 
	
	// RSS Service
	@DefaultIntValue(5 * 1000)
	public int connectTimeOut();
	
	// Web Services Geonames 
	@DefaultIntValue(5 * 1000)
	public int geonamesWebServiceConnectTimeOut();
	@DefaultStringValue("gsantosgo")
	public String geonamesWebServiceUsername();  
}
