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

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * Static and literal strings
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class Constant {

	private Constant() {
		throw new UnsupportedOperationException();
	}
	
	public final static String MAP_WIDTH = "100%";   
	public final static String MAP_HEIGHT = "100%";	
	public final static String WEB_INF = "/WEB-INF";  	
	public final static String USER_GATE = "user-gate.xml";
	//public final static String PLUGIN_ANNIE = "/WEB-INF/plugins/ANNIE";  

	public static final String FILE_LOCATIONS = "ANNIE_locations.gapp";	
		
	public static final Map<String, Menu> MENU_LIST  = new HashMap<String, Menu>(){
		private static final long serialVersionUID = 1L;
		
		{			
			// ABC.ES
			/*
			put("abcPortadaMenuItem", "http://www.abc.es/rss/ticker.aspx?sc=abcPortada");
			put("abcUltimaHoraMenuItem", "http://www.abc.es/rss/ticker.aspx?sc=abc_ultima");
			*/
			
			// LARAZON.ES 
			put("larazonGeneralesMenuItem", new Menu("http://www.larazon.es/noticias/rss","")); 	
			put("larazonEspanaMenuItem", new Menu("http://www.larazon.es/noticias/rss/espana", "ES"));
			put("larazonInternacionalMenuItem", new Menu("http://www.larazon.es/noticias/rss/internacional",""));			
			
			// ELMUNDO.ES
			put("elmundoPortadaMenuItem", new Menu("http://elmundo.feedsportal.com/elmundo/rss/portada.xml",""));			
			put("elmundoEspanaMenuItem", new Menu("http://elmundo.feedsportal.com/elmundo/rss/espana.xml","ES"));
			put("elmundoInternacionalMenuItem", new Menu("http://elmundo.feedsportal.com/elmundo/rss/internacional.xml",""));
			
			// ELPAIS.COM 
			put("elpaisPortadaMenuItem", new Menu("http://ep00.epimg.net/rss/elpais/portada.xml",""));
			put("elpaisUltimaNoticiasMenuItem", new Menu("http://ep00.epimg.net/rss/tags/ultimas_noticias.xml",""));
			put("elpaisInternacionalMenuItem", new Menu("http://ep00.epimg.net/rss/internacional/portada.xml",""));
			
			// Servlet Implemented
			// put("rssMenuItem", GWT.getModuleBaseURL() + "rssnews");
			// LOCAL News (No remote)  
			put("rssLocalNacionalMenuItem", new Menu("localNacional","ES"));
			put("rssLocalInternacionalMenuItem", new Menu("localInternacional",""));
		}
	}; 

	// Geonames Service  
	public final static String DEFAULT_LANGUAGE = "es";
	public final static String GEONAMES_WEBSERVICE_USERNAME = "gsantosgo"; 	
}
