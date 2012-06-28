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
package es.uem.geolocation.geonames;

import java.util.List;

import org.geonames.Style;

import com.google.common.collect.Lists;

import es.uem.geolocation.shared.Toponym;

/**
 * 
 * Toponym (Place names) Disambiguator
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class ToponymSearchResultCustom {

	List<Toponym> toponyms = Lists.newArrayList();
	int totalResultsCount;	
	Style style;

	/**
	 * @return Returns the toponyms.
	 */
	public List<Toponym> getToponyms() {
		return toponyms;
	}

	/**
	 * @param toponyms
	 *            The toponyms to set.
	 */
	public void setToponyms(List<Toponym> toponyms) {
		this.toponyms = toponyms;
	}

	/**
	 * @return Returns the totalResultsCount.
	 */
	public int getTotalResultsCount() {
		return totalResultsCount;
	}

	/**
	 * @param totalResultsCount
	 *            The totalResultsCount to set.
	 */
	public void setTotalResultsCount(int totalResultsCount) {
		this.totalResultsCount = totalResultsCount;
	}

	/**
	 * @return the style
	 */
	public Style getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(Style style) {
		this.style = style;
	}

}
