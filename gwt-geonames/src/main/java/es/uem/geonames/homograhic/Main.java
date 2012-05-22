package es.uem.geonames.homograhic;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import es.uem.geonames.StopWordLineProcessor;

public class Main {

	/**
	 * 
	 * Homografia de nombres de lugares 
	 * 
	 * Programa principal (Homographic place names) 
	 * 
	 * @param args the Arguments 
	 */
	public static void main(String[] args) {

		System.setProperty("http.proxyHost", "10.14.79.204");
		System.setProperty("http.proxyPort", "8080");
		

		ImmutableList<String> placeNames = ImmutableList.of("San Francisco", "San Antonio", "Madrid", "Toledo", "Valencia"); 
		long inicio1 = System.currentTimeMillis();

			// =================================
			WebService.setUserName("gsantosgo");

			
		for (String placeName : placeNames) {			
			// Toponym Search Criteria
			// =================================
			ToponymSearchCriteria toponymSearchCriteria = new ToponymSearchCriteria();
			toponymSearchCriteria.setNameEquals(placeName);
			toponymSearchCriteria.setStyle(Style.SHORT);
			toponymSearchCriteria.setStartRow(0);

			ToponymSearchResult toponymSearchResult = new ToponymSearchResult();
			try {
				toponymSearchResult = WebService.search(toponymSearchCriteria);
				// toponymSearchResult = WebService.search(q, countryCode, name,
				// featureCodes, startRow);
			} catch (Exception e) {
				e.printStackTrace();
			}

			List<Toponym> lista = toponymSearchResult.getToponyms();
			/*
			 * List<Toponym> lista = toponymSearchResult.getToponyms(); for(int
			 * i=0;i<lista.size();i++){ Toponym toponym = lista.get(i);
			 * System.out.println(" ==> " + toponym.toString()); }
			 */
			
			System.out.println(String.format(" %s = %d ", placeName, toponymSearchResult.getTotalResultsCount())); 
			long fin1 = System.currentTimeMillis(); 
			System.out.println(" Tiempo en msgs: " + (fin1-inicio1) + " msgs "); 			
			System.out.println();		
		}
				
	}

}
