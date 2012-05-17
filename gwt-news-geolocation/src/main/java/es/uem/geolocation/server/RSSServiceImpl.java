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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.common.base.Strings;
import com.google.gwt.dev.shell.remoteui.RemoteMessageProto.Message.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

import es.uem.geolocation.client.services.RSSService;
import es.uem.geolocation.server.util.RetryHandler;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.RSS;

/**
 * 
 * 	Implementation RSS Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */

@SuppressWarnings("serial")
public class RSSServiceImpl extends RemoteServiceServlet implements
		RSSService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uem.geoparser.client.GeoRSSServices#loadGeoRSSNews()
	 */
	public List<NewMap> loadGeoRSSNews() {
		List<Article> articulos = new ArrayList<Article>();
		articulos.add(new Article("hola", "hola", "hola"));

		List<Article> articulos2 = new ArrayList<Article>();
		articulos2.add(new Article("hola2", "hola2", "hola2"));

		List<NewMap> lista = new ArrayList<NewMap>();
		lista.add(new NewMap("Madrid", 39.300, -3.23232, articulos));
		lista.add(new NewMap("Madrid", 40.32, -3.23232, articulos));
		lista.add(new NewMap("Madrid", 41.321, -3.1231, articulos2));
		lista.add(new NewMap("Madrid", 42.3123, -3.23423, articulos2));

		return lista;
	}

	/**
	 * Load RSS news  
	 */
	public RSS loadRSSNews(String uri) throws Exception {		
		RSS rss = null;  		
		ArrayList<Article> articlesList = new ArrayList<Article>();
		
		
		RequestBuilder request = new RequestBuilder(RequestBuilder.GET, uri); 		
		request.sendRequest(null, new RequestCallback() {
			
			//@Override
			public void onResponseReceived(com.google.gwt.http.client.Request request,
					Response response) {
				System.out.println("StatusTex " + response.getStatusText());
				String text = response.getText();
				System.out.println(text);  				
			}
			
			//@Override
			public void onError(com.google.gwt.http.client.Request request,
					Throwable exception) {
			      if (exception instanceof RequestTimeoutException) {
			            // handle a request timeout
			          } else {
			            // handle other request errors
			          }				
				
			}
		});
		
/*		
		
		DefaultHttpClient httpClient = new DefaultHttpClient(); 
		RetryHandler retryHandler = new RetryHandler();
		httpClient.setHttpRequestRetryHandler(retryHandler);

		
		HttpGet method = new HttpGet(uri);
		HttpResponse httpResponse = httpClient.execute(method);
		HttpEntity httpEntity = httpResponse.getEntity();

		if (httpEntity != null) {
			long length = httpEntity.getContentLength();
			if (length > 0) {
				InputStream inputStream = httpEntity.getContent();
				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				try {					
					SyndFeedInput syndFeedInput = new SyndFeedInput();
					SyndFeed syndFeed = syndFeedInput.build(inputStreamReader);
					
					
					System.out.println("Entraaaaa121");					
					rss = new RSS(); 
					// Información RSS
					rss.setTitle(Strings.nullToEmpty(syndFeed.getTitle()));
					rss.setLink(Strings.nullToEmpty(syndFeed.getLink()));
					rss.setDescription(Strings.nullToEmpty(syndFeed.getDescription()));
					rss.setCopyright(Strings.nullToEmpty(syndFeed.getCopyright()));
					rss.setPublishedDate(syndFeed.getPublishedDate()); 					
					
					@SuppressWarnings("unchecked")
					List<SyndEntry> listSyndEntries = syndFeed.getEntries();
					for (SyndEntry syndEntry : listSyndEntries) {
						// Article of the new
						final Article article = new Article();
						
						article.setArticleID(Strings.nullToEmpty(""));
						article.setUri(Strings.nullToEmpty(syndEntry.getUri()));
						article.setHeadline(Strings.nullToEmpty(syndEntry
								.getTitle()));

						String description = Strings.nullToEmpty(syndEntry.getDescription().getValue());
						if (syndEntry.getDescription().getType().equals("text/html")) {
							article.setDescription(description);							
						} 
						article.setDescription(Strings.nullToEmpty(syndEntry
								.getDescription().getValue()));												
						article.setPublishedDate(syndEntry.getPublishedDate());
						
						// Categories
						if (syndEntry.getCategories().size() > 0 ) {							
							List<SyndCategoryImpl> categoriesSyndEntry = syndEntry.getCategories();
							List<String> categories =  new ArrayList<String>();						
							for (SyndCategoryImpl category : categoriesSyndEntry) {
								if (!Strings.isNullOrEmpty(category.getName()))
									categories.add(category.getName());
							}
							article.setCategories(categories);
						}

						
						articlesList.add(article);
					}
				} finally {
					inputStream.close();
				}
			}
		}
		if (rss != null) rss.setItems(articlesList); 
	*/	
		return rss;
	}
}
