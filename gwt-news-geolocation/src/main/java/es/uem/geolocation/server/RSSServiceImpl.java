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
import java.util.concurrent.TimeUnit;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.services.RSSService;
import es.uem.geolocation.server.cache.FeedService;
import es.uem.geolocation.server.cache.FeedServiceImpl;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.RSS;

/**
 * 
 * Implementation RSS Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */

@SuppressWarnings("serial")
public class RSSServiceImpl extends RemoteServiceServlet implements RSSService {
	private FeedService<RSS> feedService;

	/**
	 * Constructor
	 */
	public RSSServiceImpl() {
		feedService = new FeedServiceImpl(5, TimeUnit.MINUTES, 10);
	}

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
	public RSS loadRSSNews(String uri) {
		RSS rssSource = null;

		try {
			rssSource = feedService.getFeed(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * RequestBuilder request = new RequestBuilder(RequestBuilder.GET, uri);
		 * request.sendRequest(null, new RequestCallback() {
		 * 
		 * //@Override public void
		 * onResponseReceived(com.google.gwt.http.client.Request request,
		 * Response response) { System.out.println("StatusTex " +
		 * response.getStatusText()); String text = response.getText();
		 * System.out.println(text); }
		 * 
		 * //@Override public void onError(com.google.gwt.http.client.Request
		 * request, Throwable exception) { if (exception instanceof
		 * RequestTimeoutException) { // handle a request timeout } else { //
		 * handle other request errors }
		 * 
		 * } });
		 */

		return rssSource;
	}
}
