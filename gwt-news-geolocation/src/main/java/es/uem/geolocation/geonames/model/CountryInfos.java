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
package es.uem.geolocation.geonames.model;

import java.util.ArrayList;

/**
 * CountryInfo Collections 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class CountryInfos {
	private ArrayList<CountryInfo> items;

	public ArrayList<CountryInfo> getContent() {
		return items;
	}

	public void add(CountryInfo item) {
		items.add(item);
	}

}
