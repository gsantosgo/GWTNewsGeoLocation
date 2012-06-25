package es.uem.gazetteer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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

public class MainStop {
	
	/**
	 * Programa principal StopWords Capitalize  
	 *   
	 * @param agrs
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {		

		String stopWordFileName = "src/main/resources/Spanish_es.lst"; 
		Preconditions.checkNotNull(stopWordFileName, "Input filename should NOT be NULL");
		File stopWordInputFile = new File(stopWordFileName);
		Preconditions.checkArgument(stopWordInputFile.exists(), "File does not exist: %s", stopWordFileName);
		
		
		// Ordenación por nombre 		
		String stopWordResultInfoFileName = "src/main/resources/result/stop_cap.lst";
		File outputFile = new File(stopWordResultInfoFileName);		
		if (outputFile.exists()) outputFile.delete();		

		
		List<String> stopWords = Files.readLines(stopWordInputFile, Charsets.UTF_8);
		
		System.out.println("Numero stopWord:" + stopWords.size());
		
		for (String stopWord : stopWords) {			
			if (!Strings.isNullOrEmpty(stopWord)) {				
				char[] stringArray = stopWord.toCharArray();
				stringArray[0] = Character.toUpperCase(stringArray[0]);
				stopWord = new String(stringArray);				
				Files.append(stopWord.trim() + "\n", outputFile, Charsets.UTF_8);
			}
		}		
		
		System.out.println(">>>>Fin proceso."); 
	}
}
