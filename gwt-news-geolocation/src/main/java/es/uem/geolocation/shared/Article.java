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

package es.uem.geolocation.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Objects;

/**
 * 
 * Article of the new
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
@SuppressWarnings("serial")
public class Article implements Serializable {
	private String articleID;
	private String uri;
	private String headline;
	private String description;
	private Date publishedDate;
	private List<String> categories = new ArrayList<String>();
	private List<String> categoriesLocations = new ArrayList<String>();
	private List<String> headlineDescriptionLocations = new ArrayList<String>();
	
	/**
	 * Constructor 
	 */
	public Article() {
	}
	
	/**
	 * 
	 * Constructor 
	 *  
	 * @param headline the headline of new
	 * @param description the Description of new
	 * @param uri the URI 
	 * @param publishedDate the Date of published 
	 */
	public Article(String headline, String description, String uri, Date publishedDate) {
		this.headline = headline;
		this.description = description;
		this.uri = uri;
		this.publishedDate = publishedDate; 
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
		
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getCategoriesLocations() {
		return categoriesLocations;
	}

	public void setCategoriesLocations(List<String> categoriesLocations) {
		this.categoriesLocations = categoriesLocations;
	}

	public List<String> getHeadlineDescriptionLocations() {
		return headlineDescriptionLocations;
	}

	public void setHeadlineDescriptinLocations(List<String> headlineDescriptionLocations) {
		this.headlineDescriptionLocations = headlineDescriptionLocations;
	}

	/**
	 * Provide hash code of this article instance.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getArticleID(), this.getUri(),
				this.getHeadline(), this.getDescription(),
				this.getPublishedDate(), this.getCategories());
	}

	/**
	 * Representation of this article instance.
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("articleID", this.getArticleID())
				.add("uri", this.getUri()).addValue(this.getHeadline())
				.add("description",this.getDescription())
				.add("publishedDate", this.getPublishedDate())
				.add("categories", this.getCategories().toString())
				.add("categoriesLocations",this.getCategoriesLocations().toString())
				.add("headlineLocations",this.getHeadlineDescriptionLocations().toString())
				.toString();
	}	
}
