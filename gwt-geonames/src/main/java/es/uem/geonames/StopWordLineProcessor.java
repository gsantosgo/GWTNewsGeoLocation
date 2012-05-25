package es.uem.geonames;

import java.io.IOException;
import java.util.List;

import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;

public class StopWordLineProcessor implements LineProcessor<String> {
	public final String SEPARATOR = "\t";
	private int lineCount = 0;

	// private File file = null;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public StopWordLineProcessor() {
	}

	/**
	 * 
	 * Procesamiento de lineas
	 * 
	 */
	public boolean processLine(String line) throws IOException {
		if (!Strings.isNullOrEmpty(line)) {
			List<Toponym> toponyms = Geonames(line);
			List<Toponym> toponymsResult = Lists.newArrayList(); 
			for (Toponym toponym : toponyms) {
				if (line.toLowerCase().equals(
						toponym.getName().toLowerCase())) {
					toponymsResult.add(toponym);
				}
			}

			Joiner joiner = Joiner.on(",").skipNulls();
			System.out.println(String.format("StopWord: %s = %d (%s)", line,
					toponymsResult.size(), joiner.join(toponymsResult)));

			lineCount++;
		}
		return true;
	}

	public String getResult() {
		return new StringBuffer().append(lineCount).toString();
	}

	/**
	 * 
	 * Geonames
	 * 
	 * @param line
	 * @return
	 */
	private List<Toponym> Geonames(String commonWord) {
		long inicio1 = System.currentTimeMillis();

		// =================================
		WebService.setUserName("gsantosgo");

		List<Toponym> lista = Lists.newArrayList();

		// Uso Toponym Search Criteria
		// =================================
		ToponymSearchCriteria toponymSearchCriteria = new ToponymSearchCriteria();
		toponymSearchCriteria.setNameEquals(commonWord);
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
		
		// ===============================================
		// Note. 22.Mayo.2012 
		//	getTotalResultsCount() = Total Number 
		//  getToponyms() = List (Limit only 100 items) 
		// -----------------------------------------------
		int count = toponymSearchResult.getTotalResultsCount();
		lista = toponymSearchResult.getToponyms();


		/*
		 * List<Toponym> lista = toponymSearchResult.getToponyms(); for(int
		 * i=0;i<lista.size();i++){ Toponym toponym = lista.get(i);
		 * System.out.println(" ==> " + toponym.toString()); }
		 */

		/*
		 * System.out.println(" ==> Resultado: " +
		 * toponymSearchResult.getTotalResultsCount()); long fin1 =
		 * System.currentTimeMillis(); System.out.println(" Tiempo en msgs: " +
		 * (fin1-inicio1) + " msgs "); System.out.println();
		 */

		return lista;
	}

}

