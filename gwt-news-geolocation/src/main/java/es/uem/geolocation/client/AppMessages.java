package es.uem.geolocation.client;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {	  
	  // RSS Service ===== 
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
	  @DefaultMessage("No hay informaci\u00f3n disponible en fuente RSS {0}.")
	  String processingRSSNoInformation(String uri);	  
	  @DefaultMessage("Fallo. Imposible cargar informaci\u00f3n fuente RSS {0}.")
	  String processingRSSFailure(String uri);	  
	  @DefaultMessage("Excepci\u00f3n. Imposible cargar informaci\u00f3n fuente RSS {0}.")
	  String processingRSSException(String uri);
	  
	  // GATE Service =====	   
	  @DefaultMessage("Reconocimiento de entidades nombradas (nombres lugares). Espere ...")
	  String processingNER();
	  @DefaultMessage("Reconocimiento de entidades nombradas (nombres lugares) realizado con exito.")
	  String processingNERSuccess();
	  @DefaultMessage("Fallo. Reconocimiento de entidades nombradas (nombres lugares).")
	  String processingNERFailure();
	  @DefaultMessage("Excepci\u00f3n. Reconocimiento de entidades nombradas (nombres lugares).")
	  String processingNERException();
	  
	  // Geonames Service =====	   
	  @DefaultMessage("Geoposicionando geográficamente las noticias de noticias. Espere ...")
	  String processingGeocoding();
	  @DefaultMessage("Fallo. Geoposicionando geogr\u00e1ficamente las noticias reconocidas.")
	  String processingGeocodingFailure();
	  @DefaultMessage("Excepci\u00f3n. Geoposicionando geogr\u00e1ficamente las noticias.")
	  String processingGeocodingException();	  
}
