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

package es.uem.geolocation.server;

import java.util.ArrayList;
import java.util.List;

import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.Constant;
import es.uem.geolocation.client.services.GeonamesService;
import es.uem.geolocation.shared.Toponym;

/**
 * 
 * Geonames Service Implementation
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */

@SuppressWarnings("serial")
public class GeonamesServiceImpl extends RemoteServiceServlet implements
		GeonamesService {

	public List<Toponym> toponymSearchCriteria(String name) {
		List<Toponym> toponymList = new ArrayList<Toponym>();
		try {
			ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();			
			searchCriteria.setLanguage(Constant.DEFAULT_LANGUAGE);
			searchCriteria.setNameEquals(name);
			searchCriteria.setStartRow(0);
			searchCriteria.setStyle(Style.LONG); // Importante

			WebService.setUserName(Constant.GEONAMES_WEBSERVICE_USERNAME);

			ToponymSearchResult searchResult = WebService
					.search(searchCriteria);
			for (org.geonames.Toponym toponym : searchResult.getToponyms()) {
				/*
				 * System.out.println(toponym.getName() + " " +
				 * toponym.getCountryName() + " (" + toponym.getLatitude() + ","
				 * + toponym.getLongitude() + ")");
				 */

				Toponym newToponym = new Toponym();
				newToponym.setGeoNameId(toponym.getGeoNameId());
				newToponym.setName(toponym.getName());
				newToponym.setAlternateNames(toponym.getAlternateNames());
				newToponym.setLatitude(toponym.getLatitude());
				newToponym.setLongitude(toponym.getLongitude());
				newToponym.setElevation(toponym.getElevation());
				newToponym.setPopulation(toponym.getPopulation());

				toponymList.add(newToponym);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toponymList;
	}
}
