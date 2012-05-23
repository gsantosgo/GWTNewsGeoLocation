package es.uem.geolocation.client;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {	  
	// RSS Service 
	  @DefaultMessage("Accediendo a fuente RSS {0} ...")
	  String fetchRSS(String uri); 	  
	  
	  @DefaultMessage("Cargando fuente RSS {0}. Espere ...")
	  String loadingRSS(String uri); 
	  
	  @DefaultMessage("Cargando informacion fuente RSS {0} ...")
	  String infoRSS(String title); 
	  
	  @DefaultMessage("Cargando {0, number} articulos de noticias. Espere...")
	  String loadingRSSArticles(int number);
	  	  
	  @DefaultMessage("Procesando fuente de información RSS. Espere ...")
	  String processingRSS();
	  
	  // Gate Service 
	  @DefaultMessage("Reconocimiento de entidades nombradas (nombres lugares). Espere ...")
	  String processingNER();
	  
	  // Geonames Service 
	  @DefaultMessage("Geoposicionando geográficamente las noticias de noticias. Espere ...")
	  String processingGeocoding();

	  
	  
	  
}
