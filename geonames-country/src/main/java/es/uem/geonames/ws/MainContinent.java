package es.uem.geonames.ws;

import java.util.List;

import org.geonames.FeatureClass;
import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;

public class MainContinent {

	/**
	 * Dame todos los continentes 
	 * 
	 *  http://api.geonames.org/search?featureCode=CONT&lang=es&username=gsantosgo&style=full  
	 * 
	 * @param args
	 */
	public static void main(String args[]) {	
		MyWebService.setUserName("gsantosgo");
		
		System.out.println("======================================");
		System.out.println(" Geonames Server: " + MyWebService.getGeoNamesServer());					
		System.out.println(" Geonames Server: " + MyWebService.getUserName()); 
							
		/*
		// Configuracion PROXY. Para conectarse correctamente este necesario configurar el PROXY.
        System.setProperty("http.proxySet","true");
        System.setProperty("http.proxyHost","10.14.79.204");
        System.setProperty("http.proxyPort","8080");
        System.setProperty("http.proxyUser","");
        System.setProperty("http.proxyPassword","");*/ 

        
		long inicio1 = System.currentTimeMillis();		
		//System.out.println();
		
		// Continent Search  				
		ToponymSearchCriteria toponymSearchCriteria = new ToponymSearchCriteria();					
		toponymSearchCriteria.setStyle(Style.FULL);
		toponymSearchCriteria.setFeatureClass(FeatureClass.L);
		toponymSearchCriteria.setFeatureCodes(new String[]{"CONT"});
		toponymSearchCriteria.setLanguage("es"); 
								
		ToponymSearchResult toponymSearchResult = new ToponymSearchResult();  					  
		try {
			toponymSearchResult = MyWebService.searchContinent(toponymSearchCriteria); 				
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Número de Continentes: " + toponymSearchResult.getTotalResultsCount());		
		List<Toponym> toponymList = toponymSearchResult.getToponyms(); 
		for (Toponym toponym : toponymList) {
			System.out.println(toponym);
		}			
		
		long fin1 = System.currentTimeMillis();
		System.out.println(" Tiempo en msgs: " + (fin1-inicio1) + " msgs ");
		System.out.println();        

	}
}
