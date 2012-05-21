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
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;

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
	
	/**
	 * Load RSS news
	 */
	public RSS loadRSSNews() {
		RSS rssSource = null; 

		try {
			rssSource = new RSS(); 			
			rssSource.setTitle("RSS Personalizado");
			rssSource.setDescription("RSS creado localmente para testing");
			rssSource.setLink("local"); 
			rssSource.setCopyright("@gsantosgo");
			rssSource.setPublishedDate(new java.util.Date()); 
			
			List<Article> items = new ArrayList<Article>();		
			items.add(new Article("ONU-SAHARA OCCIDENTAL", "Consejo de Seguridad ONU ha decidido por unanimidad renovar por un año el mandato de la Misión de la ONU para el Referéndum en el Sahara Occidental (Minurso) y ha exigido al gobierno marroquí y al Frente Polisario que \"demuestren mayor voluntad política en buscar una solución\". FUENTE: AGENCIAS.", "link", new Date())); 
			items.add(new Article("O.MEDIO", "El gobierno israelí ha otorgado el estatus legal a 3 grupos de viviendas construidas en Cisjordania alegando que \"fueron establecidas en la década de 1990 siguiendo las decisiones de Gobiernos previos\". El presidente palestino ha declarado que esta situación les lleva \"de nuevo a un callejón sin salida\". FUENTE: AGENCIAS.", "link", new Date()));
			items.add(new Article("MAURITANIA-PESQUERO ESPAÑOL", "Sobre las 14.40h han sido rescatados los 8 tripulantes (2 de ellos españoles) del pesquero \"Nuevo Francisco Javier\" que se hundía (por causas desconocidas) a unas 30 millas de Nouadibí. Todos se encuentran en buen estado y se dirigen en un pesquero polaco hacia Nouadibí. FUENTE: SASEMAR.", "link", new Date()));
			items.add(new Article("MALI", "La ciudadana suiza secuestrada el pasado 15 de abril en Tombuctú por el grupo islamista \"Ansar Dine\" ha sido puesta en libertad y entregada a las fuerzas de seguridad de Burkina Faso. FUENTE: AGENCIAS.", "link", new Date()));
			items.add(new Article("ECONOMíA-SUBASTA", "El Tesoro ha colocado 1.930 millones de euros a letras a 3 y 6 meses (sobre un objetivo máximo de 2.000 millones de euros) a tipos superiores que en subasta anterior. En concreto, ha colocado 720 millones en letras a 3 meses a un interés del 0.634% (0.428% en subasta anterior) y 1.210 millones en letras a 6 meses a un interés del 1.580% (0.836% en subasta anterior). La demanda de letras a 3 meses y 6 meses ha superado 7,6 veces y 3.3 veces la oferta respectivamente. FUENTE: AGENCIAS y WEB TESORO PÚBLICO.", "link", new Date()));
			items.add(new Article("ECONOMÍA", "Bolsas europeas cierran con caídas generalizadas entre el -1,9% de Londres y el -3,83% de Milán. El IBEX cerró en los 6.846 puntos (mínimo anual) con una bajada del -2,76%. El índice Dow Jones cotiza con -1,11%. La prima de riesgo española se encuentra al cierre de los mercados en los 435 puntos básicos, con una rentabilidad del 6% (prima Italia 410 puntos). FUENTE: AGENCIAS", "link", new Date()));
			items.add(new Article("UE - YPF", "Finalizada reunión Consejo Asuntos Exteriores UE, La Alta Representante ha declarado mantener posición que vaya en interés tanto de la UE como de Argentina y de la economía global, para no llegar a un punto de destrucción de inversiones directas en el extranjero. Ha defendido además, la necesidad de respetar las obligaciones internacionales. El ministro español de Asuntos Exteriores, en comparecencia ante los medios, ha informado del acuerdo alcanzado por parte del Consejo de seguir estudiando \"todas las posibilidades posibles\" en respuesta a la expropiación de la petrolera YPF. FUENTE: WEB CONSEJO UE, agencias.", "link", new Date()));
			items.add(new Article("HOLANDA - GOBIERNO", "El Primer ministro holandés Mark Rutte ha presentado ante la Reina Beatriz su dimisión y la de todo su Gobierno.", "link", new Date()));
			items.add(new Article("EUROSTAT - ESPAÑA", "La oficina estadística comunitaria Eurostat en su anuncio de los datos de déficit de los países de la UE de 2011, confirma en el caso de España, el dato de déficit del 8,5% del PIB. Este dato es el tercero más alto de la Unión Europea, sólo superado por Irlanda (13,1%) y Grecia (9,1%). FUENTE: AGENCIAS", "link", new Date()));
			items.add(new Article("FRANCIA - ELECCIONES PRESIDENCIALES", "Con el 99% de los sufragios escrutados, el candidato socialista François Hollande ha obtenido un 28,56% de los votos, seguido del presidente Nicolas Sarkozy con el 27%; ambos candidatos pasan a la segunda vuelta de las presidenciales que se celebrarón el próximo 6 de mayo. La participación alcanzó el 80%. FUENTE: AGENCIAS ", "link", new Date()));
			items.add(new Article("Titulo", "Guillermo lives in Madrid. Madrid is a great city. Barcelona y Madrid necesitan evolucionar. Enfrentamientos en Afganistán. Enfrentamientos in Afganistán. Enfrentamientos at Londres. La ciudad de Talavera de la Reina está situada en la provincia de Toledo. ", "link", new Date()));
						
			rssSource.setItems(items);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rssSource;
	}	
	
	/**
	 * Load RSS news from URI 
	 */
	public RSS loadRSSNews(String uri) {
		RSS rssSource = null;

		try {
			if (uri.equals("local")) {
				rssSource = loadRSSNews(); 
			} else {
				rssSource = feedService.getFeed(uri);	
			}
			
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
	
	private SyndEntry createEntry (String title, String link, String description,
		    Date createDate) {
		  SyndEntry entry = new SyndEntryImpl();
		  entry.setTitle(title);
		  entry.setLink(link);
		  entry.setPublishedDate(createDate);
		  SyndContent entryDescription = new SyndContentImpl();
		  entryDescription.setType("text/plain");
		  entryDescription.setValue(description);
		  entry.setDescription(entryDescription);

		  return entry;
		}	
}
