package es.uem.geonames;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.io.Files;


public class Main {
	
	/**
	 * 
	 * Homgrafía de nombres de lugares con palabras comunes 
	 * 
	 * Programa principal (Place homographs with common words) 
	 * 
	 * @param args the Arguments 
	 */
	public static void main(String[] args) {

		System.setProperty("http.proxyHost", "10.14.79.204");
		System.setProperty("http.proxyPort", "8080");
		
		String inputFileNamePath = "src/main/resources/Spanish_es.xml";		
		Preconditions.checkNotNull(inputFileNamePath,
				"Input filename should NOT be NULL");
		File inputFile = new File(inputFileNamePath);
		
		Preconditions.checkArgument(inputFile.exists(),
				"File does not exist: %s", inputFile);
		
		System.out.println("Starting process  ....");
		System.out.println("> Waiting....");
		Stopwatch stopWatch = new Stopwatch();
		stopWatch.start();
		String resultado = "";
		try {			
			resultado = Files.readLines(inputFile, Charsets.UTF_8, new StopWordLineProcessor());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Processed registers %s ", resultado));
		System.out.println(String.format(
				"Complete process. Elapsed time %d min, %d sec.",
				stopWatch.elapsedTime(TimeUnit.MINUTES),
				stopWatch.elapsedTime(TimeUnit.SECONDS)));
		System.out.println("");

	}
}

