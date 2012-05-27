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

import com.google.gwt.i18n.client.Messages;

/**
 *
 * Client's Messages 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
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
