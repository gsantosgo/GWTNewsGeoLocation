package es.uem.geolocation.client;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {
	
	// Application ===== 
	public String applicationName(); 
	public String version();
	public String author();
	public String detail();
	
	@DefaultStringValue("dd/MM/yyyy HH:mm:ss")
	public String formatDateTime(); 	
		
	// Custom marker image ===== 
	@DefaultStringValue("images/redpushpin.png")
	public String markerImage(); 
}
