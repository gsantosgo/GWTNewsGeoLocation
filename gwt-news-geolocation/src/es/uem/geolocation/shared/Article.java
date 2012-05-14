package es.uem.geolocation.shared;

import java.io.Serializable;
import java.util.Date;

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

	/**
	 * Constructor 
	 */
	public Article() {
	}

	public Article(String headline, String description, String uri) {
		this.headline = headline;
		this.description = description;
		this.uri = uri;
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

	/**
	 * Provide hash code of this article instance.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getArticleID(), this.getUri(),
				this.getHeadline(), this.getDescription(),
				this.getPublishedDate());
	}

	/**
	 * Representation of this article instance.
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(this.getArticleID())
				.addValue(this.getUri()).addValue(this.getHeadline())
				.addValue(this.getDescription())
				.addValue(this.getPublishedDate()).toString();
	}

}
