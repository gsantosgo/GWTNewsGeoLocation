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
package es.uem.geolocation.server.cache;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

import es.uem.geolocation.server.util.RetryHandler;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.RSS;


/**
 * 
 * Feed Service 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class FeedServiceImpl implements FeedService<RSS> {	
	protected LoadingCache<String, RSS> cache;
	
	/** 
	 * 
	 * Constructor 
	 *   
	 * @param duration the duration
	 * @param timeUnit the time unit 
	 * @param size the cache size
	 */	
	public FeedServiceImpl(long duration, TimeUnit timeUnit, long size) {
		buildCache(duration, timeUnit, size);
	}
			
	/**
	 * 
	 * Build cache 
	 *   
	 * @param duration the duration
	 * @param timeUnit the time unit 
	 * @param size the cache size
	 */
	private void buildCache(long duration, TimeUnit timeUnit, long size) {
		cache = CacheBuilder.newBuilder()				
				// .refreshAfterWrite(duration, unit)
				.build(new CacheLoader<String, RSS>() {					
					@Override
					public RSS load(String uriKey) throws Exception {
						RSS rss = null;
						ArrayList<Article> articlesList = new ArrayList<Article>();
												
						DefaultHttpClient httpClient = new DefaultHttpClient();
						
						/*
						// Proxy Configuration =====  
						HttpHost httpProxy = new HttpHost("10.14.79.204",8080);
						// Set this HttpHost to DefaultHttpClient as parameter
						httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, httpProxy);
						*/						
						
						RetryHandler retryHandler = new RetryHandler();
						httpClient.setHttpRequestRetryHandler(retryHandler);
						
						HttpGet method = new HttpGet(uriKey);
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
										
										article.setArticleID(Strings.nullToEmpty(""+syndEntry.hashCode()));
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
						return rss; 
					}
				});
	}

	
	public RSS getFeed(String uri) throws Exception {
		return cache.get(uri); 
	}
	
	public RSS search(String query) throws Exception {
		return cache.get(query);
	}

	public Cache<String, RSS> getCache() {
		return cache;
	}	
	
	 
	
}
