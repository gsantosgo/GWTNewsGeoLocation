package es.uem.geonames;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;

import es.uem.geonames.model.ContinentInfo;
import es.uem.geonames.model.ContinentInfos;

public class MainContinent {
	/**
	 * 
	 * Main program
	 * 
	 * @param args
	 *            Arguments
	 */
	public static void main(String args[]) {

		String inputFileNamePath = "src/main/resources/continents.xml";
		Preconditions.checkNotNull(inputFileNamePath,
				"Input filename should NOT be NULL");
		File inputFile = new File(inputFileNamePath);

		Preconditions.checkArgument(inputFile.exists(),
				"File does not exist: %s", inputFile);

		Stopwatch stopwatch = new Stopwatch();
		stopwatch.start();

		XStream xstream = new XStream();
		xstream.alias("geonames", ContinentInfos.class);
		xstream.alias("totalResultsCount", Integer.class);
		xstream.alias("geoname", ContinentInfo.class);
		xstream.addImplicitCollection(ContinentInfos.class, "items");

		ContinentInfos continentInfos = (ContinentInfos) xstream
				.fromXML(inputFile);
		// CountryInfos countryInfos = (CountryInfos)
		// xstream.fromXML(inputFile);

		/*
		 * for (CountryInfo countryInfo : countryInfos.getContent()) {
		 * System.out.println(countryInfo); }
		 */
		stopwatch.stop();

		System.out.println("Continent :" + continentInfos.getContent().size());
		System.out.println(String.format(
				"Complete process. Elapsed time %d sec, %d msec.",
				stopwatch.elapsedTime(TimeUnit.SECONDS),
				stopwatch.elapsedTime(TimeUnit.MILLISECONDS)));
		System.out.println("");

		Map<String, ContinentInfo> mapContinent = new HashMap<String, ContinentInfo>();
		List<ContinentInfo> listContinentInfos = continentInfos.getContent();
		if (listContinentInfos != null && listContinentInfos.size() > 0) {
			for (ContinentInfo continentInfo : listContinentInfos) {
				mapContinent.put(continentInfo.getName(), continentInfo);
			}
		}

		Map<String, ContinentInfo> filterContinents = Maps.filterKeys(mapContinent, new ShouldNamePredicate("sdfsd"));
		
		System.out.println(filterContinents );
	}
}
