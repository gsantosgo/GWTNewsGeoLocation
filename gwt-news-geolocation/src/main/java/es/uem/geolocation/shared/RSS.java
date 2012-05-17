package es.uem.geolocation.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.common.base.Objects; 

/**
 * 
 * RSS Source  
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
@SuppressWarnings("serial")
public class RSS implements Serializable {
	private String title; 
	private String link;
	private String description; 
	private String copyright;
	private Date publishedDate;
	private List<Article> items; 

	/**
	 * Constructor 
	 */
	public RSS() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public List<Article> getItems() {
		return items;
	}

	public void setItems(List<Article> items) {
		this.items = items;
	}

	/**
	 * Provide hash code of this RSS instance.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getTitle(), 
				this.getLink(),
				this.getDescription(), 
				this.getCopyright(),
				this.getPublishedDate());
	}

	/**
	 * Representation of this RSS Instance 
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(this.getTitle())
				.addValue(this.getLink())
				.addValue(this.getDescription())
				.addValue(this.getCopyright())
				.addValue(this.getPublishedDate())
				.addValue(this.getItems().toString()).toString();
	}

}
