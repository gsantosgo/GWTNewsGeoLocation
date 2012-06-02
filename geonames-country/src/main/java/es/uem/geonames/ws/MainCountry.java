package es.uem.geonames.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.geonames.FeatureClass;
import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;


public class MainCountry {

	/**
	 * Dame todos los paises  
	 *
	 * http://api.geonames.org/countryInfo?lang=es&username=gsantosgo&style=full
	 * http://api.geonames.org/search?featureCode=PCLI&featureCode=PCL&lang=es&username=gsantosgo&style=full  
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
        System.setProperty("http.proxyPassword","");
		 */
		
		Stopwatch stopwatch = new Stopwatch(); 
        
		 
		// Step 1. CountryInfo ======
		stopwatch.start();
		ToponymSearchCriteria toponymSearchCriteria = new ToponymSearchCriteria();
		toponymSearchCriteria.setLanguage("es");
		toponymSearchCriteria.setStyle(Style.FULL);		 

		ToponymSearchResult toponymSearchResult = new ToponymSearchResult();  					  
		try {
			toponymSearchResult = MyWebService.countryInfo(toponymSearchCriteria); 				
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Número de Paises: " + toponymSearchResult.getTotalResultsCount());		
		List<Toponym> toponymList = toponymSearchResult.getToponyms(); 
		//for (Toponym toponym : toponymList) {
			//System.out.println(toponym);
	//	}	
		stopwatch.stop(); 
		System.out.println(String.format(
				"Tiempo transcurrido en %d miliseconds: ",
				stopwatch.elapsedTime(TimeUnit.MILLISECONDS))); 		

		stopwatch.reset(); 
		stopwatch.start(); 
		
		// Step 2. Country Search
		ToponymSearchCriteria toponymCountrySearchCriteria = new ToponymSearchCriteria();
		toponymCountrySearchCriteria.setLanguage("es");
		toponymCountrySearchCriteria.setStyle(Style.FULL);
		toponymCountrySearchCriteria.setFeatureClass(FeatureClass.A);		 
		toponymCountrySearchCriteria.setFeatureCodes(new String[]{"PCL","PCLD","PCLF","PCLI","PCLIX","PCLS"});
 								
		ToponymSearchResult toponymCountrySearchResult = new ToponymSearchResult();  					  
		try {
			toponymCountrySearchResult = MyWebService.search(toponymCountrySearchCriteria); 				
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Número de Paises: " + toponymCountrySearchResult.getTotalResultsCount());		
		List<Toponym> toponymCountryList = toponymCountrySearchResult.getToponyms();
		Map<Integer, Toponym> mapToponyms =  Maps.newHashMap();		
		for (Toponym toponym : toponymCountryList) {
			mapToponyms.put(toponym.getGeoNameId(), toponym);
		}				 
		
		
		int count = 0; 
		for (Toponym toponym : toponymList) {
			Toponym mapToponym = mapToponyms.get(toponym.getGeoNameId());			
			if (mapToponym == null) {				
				count++; 
			}
		}			 
		System.out.println(" ==>" + count);
				
		stopwatch.stop(); 
		System.out.println(String.format(
				"Tiempo transcurrido en %d miliseconds: ",
				stopwatch.elapsedTime(TimeUnit.MILLISECONDS))); 		
        
	}
}
