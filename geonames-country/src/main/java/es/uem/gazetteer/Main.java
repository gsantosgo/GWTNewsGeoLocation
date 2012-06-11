package es.uem.gazetteer;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Main {
	
	/**
	 * Programa principal  
	 * @param agrs
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {		
		// Countries ====================================================================
		// CountryInfo 
		String countryInfoFileName = "src/main/resources/countryinfo.xml"; 
		Preconditions.checkNotNull(countryInfoFileName, "Input filename should NOT be NULL");
		File countryInfoInputFile = new File(countryInfoFileName);
		Preconditions.checkArgument(countryInfoInputFile.exists(), "File does not exist: %s", countryInfoFileName);
		
		SAXBuilder parserCountryInfo = new SAXBuilder();
		Document docCountryInfo = null; 
		try {
			docCountryInfo = parserCountryInfo.build(countryInfoInputFile);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Preconditions.checkNotNull(docCountryInfo, "Error en documento XML" + countryInfoFileName);		
		Element rootCountryInfo = docCountryInfo.getRootElement();
			
		List<ToponymCountry> countries = Lists.newArrayList(); 
		for (Object obj : rootCountryInfo.getChildren("country")) {						
			Element toponymElement = (Element) obj;
			ToponymCountry toponym = MyWebService.getToponymCountryInfoFromElement(toponymElement);
			countries.add(toponym);			
		}
		System.out.println("Number Country: " + countries.size());
			
		
		// Ordenación por nombre 
		
		String countryResultInfoFileName = "src/main/resources/result/country.lst";
		File outputFile = new File(countryResultInfoFileName);		
		if (outputFile.exists()) outputFile.delete();		
				
		// Countries =====
		Collections.sort(countries, new Comparator<ToponymCountry>() {
		    public int compare(ToponymCountry one,ToponymCountry other) {
		        return one.getCountryName().compareTo(other.getCountryName());
		    }
		}); 
 
		for (ToponymCountry toponymCountry : countries) {			
			String countryName = toponymCountry.getCountryName();
			String countryNameNormalized = ""; 
			if (!Strings.isNullOrEmpty(countryName)) {	
				// Tratamiento de Acentos 
				countryNameNormalized = Normalizer.normalize(countryName, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
				Files.append(countryName.trim() + "\n", outputFile, Charsets.UTF_8);
				if (!countryName.equals(countryNameNormalized)) {
					Files.append(countryNameNormalized.trim() + "\n", outputFile, Charsets.UTF_8);					
				}				
			}
		}		
		
		// Countries UpperCase=====		
		countryResultInfoFileName = "src/main/resources/result/country_cap.lst";
		outputFile = new File(countryResultInfoFileName);		
		if (outputFile.exists()) outputFile.delete();
		
		for (ToponymCountry toponymCountry : countries) {			
			String countryName = toponymCountry.getCountryName().toUpperCase();
			String countryNameNormalized = ""; 
			if (!Strings.isNullOrEmpty(countryName)) {				
				countryNameNormalized = Normalizer.normalize(countryName, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toUpperCase();
				Files.append(countryName.trim() + "\n", outputFile, Charsets.UTF_8);
				if (!countryName.equals(countryNameNormalized)) {
					Files.append(countryNameNormalized.trim() + "\n", outputFile, Charsets.UTF_8);					
				}				
			}
		}		
		
		
				
		// CountryCode 2 =====
		countryResultInfoFileName = "src/main/resources/result/country_code.lst";
		outputFile = new File(countryResultInfoFileName);	
		if (outputFile.exists()) outputFile.delete();
		
		Collections.sort(countries, new Comparator<ToponymCountry>() {
		    public int compare(ToponymCountry one,ToponymCountry other) {
		        return one.getCountryCode().compareTo(other.getCountryCode());
		    }
		});
		
		for (ToponymCountry toponymCountry : countries) {			
			String countryCode = toponymCountry.getCountryCode().toUpperCase();			 
			if (!Strings.isNullOrEmpty(countryCode)) {				
				Files.append(countryCode.trim() + "\n", outputFile, Charsets.UTF_8);
			}
		}		
		
		

		
		// Iso-Alpha3 3 ======
		countryResultInfoFileName = "src/main/resources/result/country_isoalpha3.lst";
		outputFile = new File(countryResultInfoFileName);	
		if (outputFile.exists()) outputFile.delete();		
		Collections.sort(countries, new Comparator<ToponymCountry>() {
		    public int compare(ToponymCountry one,ToponymCountry other) {
		        return one.getIsoAlpha3().compareTo(other.getIsoAlpha3());
		    }
		}); 
		for (ToponymCountry toponymCountry : countries) {			
			String isoAlpha3 = toponymCountry.getIsoAlpha3().toUpperCase();			 
			if (!Strings.isNullOrEmpty(isoAlpha3)) {				
				Files.append(isoAlpha3.trim() + "\n", outputFile, Charsets.UTF_8);
			}
		}		
		
		
		
		countryResultInfoFileName = "src/main/resources/result/country_fipscode.lst";
		outputFile = new File(countryResultInfoFileName);	
		if (outputFile.exists()) outputFile.delete();
		
		// Fips-Code 2  =====
		Collections.sort(countries, new Comparator<ToponymCountry>() {
		    public int compare(ToponymCountry one,ToponymCountry other) {
		        return one.getFipsCode().compareTo(other.getFipsCode());
		    }
		}); 				
		
		for (ToponymCountry toponymCountry : countries) {			
			String fipsCode = toponymCountry.getFipsCode().toUpperCase();			 
			if (!Strings.isNullOrEmpty(fipsCode)) {				
				Files.append(fipsCode.trim() + "\n", outputFile, Charsets.UTF_8);
			}
		}	
		
		System.out.println(">>>>Fin proceso."); 
	}
}
