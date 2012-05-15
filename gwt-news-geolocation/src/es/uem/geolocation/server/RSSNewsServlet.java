package es.uem.geolocation.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedOutput;


public class RSSNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 8032611514671727168L;
	private static final String MIME_TYPE = "application/xml; charset=UTF-8";	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			List<SyndEntry> entries = new ArrayList<SyndEntry>(); 
			entries.add(createEntry("ONU-SAHARA OCCIDENTAL", "link", "Consejo de Seguridad ONU ha decidido por unanimidad renovar por un año el mandato de la Misión de la ONU para el Referéndum en el Sahara Occidental (Minurso) y ha exigido al gobierno marroquí y al Frente Polisario que \"demuestren mayor voluntad política en buscar una solución\". FUENTE: AGENCIAS.", new Date())); 
			entries.add(createEntry("O.MEDIO", "link", "El gobierno israelí ha otorgado el estatus legal a 3 grupos de viviendas construidas en Cisjordania alegando que \"fueron establecidas en la década de 1990 siguiendo las decisiones de Gobiernos previos\". El presidente palestino ha declarado que esta situación les lleva \"de nuevo a un callejón sin salida\". FUENTE: AGENCIAS.", new Date()));
			entries.add(createEntry("MAURITANIA-PESQUERO ESPAÑOL", "link", "Sobre las 14.40h han sido rescatados los 8 tripulantes (2 de ellos españoles) del pesquero \"Nuevo Francisco Javier\" que se hundía (por causas desconocidas) a unas 30 millas de Nouadibí. Todos se encuentran en buen estado y se dirigen en un pesquero polaco hacia Nouadibí. FUENTE: SASEMAR.", new Date()));
			entries.add(createEntry("MALI", "link", "La ciudadana suiza secuestrada el pasado 15 de abril en Tombuctú por el grupo islamista \"Ansar Dine\" ha sido puesta en libertad y entregada a las fuerzas de seguridad de Burkina Faso. FUENTE: AGENCIAS.", new Date()));
			entries.add(createEntry("ECONOMíA-SUBASTA", "link", "El Tesoro ha colocado 1.930 millones de euros a letras a 3 y 6 meses (sobre un objetivo máximo de 2.000 millones de euros) a tipos superiores que en subasta anterior. En concreto, ha colocado 720 millones en letras a 3 meses a un interés del 0.634% (0.428% en subasta anterior) y 1.210 millones en letras a 6 meses a un interés del 1.580% (0.836% en subasta anterior). La demanda de letras a 3 meses y 6 meses ha superado 7,6 veces y 3.3 veces la oferta respectivamente. FUENTE: AGENCIAS y WEB TESORO PÚBLICO.", new Date()));
			entries.add(createEntry("ECONOMÍA", "link", "Bolsas europeas cierran con caídas generalizadas entre el -1,9% de Londres y el -3,83% de Milán. El IBEX cerró en los 6.846 puntos (mínimo anual) con una bajada del -2,76%. El índice Dow Jones cotiza con -1,11%. La prima de riesgo española se encuentra al cierre de los mercados en los 435 puntos básicos, con una rentabilidad del 6% (prima Italia 410 puntos). FUENTE: AGENCIAS", new Date()));
			entries.add(createEntry("UE - YPF", "link", "Finalizada reunión Consejo Asuntos Exteriores UE, La Alta Representante ha declarado mantener posición que vaya en interés tanto de la UE como de Argentina y de la economía global, para no llegar a un punto de destrucción de inversiones directas en el extranjero. Ha defendido además, la necesidad de respetar las obligaciones internacionales. El ministro español de Asuntos Exteriores, en comparecencia ante los medios, ha informado del acuerdo alcanzado por parte del Consejo de seguir estudiando \"todas las posibilidades posibles\" en respuesta a la expropiación de la petrolera YPF. FUENTE: WEB CONSEJO UE, agencias.", new Date()));
			entries.add(createEntry("HOLANDA - GOBIERNO", "link", "El Primer ministro holandés Mark Rutte ha presentado ante la Reina Beatriz su dimisión y la de todo su Gobierno.", new Date()));
			entries.add(createEntry("EUROSTAT - ESPAÑA", "link", "La oficina estadística comunitaria Eurostat en su anuncio de los datos de déficit de los países de la UE de 2011, confirma en el caso de España, el dato de déficit del 8,5% del PIB. Este dato es el tercero más alto de la Unión Europea, sólo superado por Irlanda (13,1%) y Grecia (9,1%). FUENTE: AGENCIAS", new Date()));
			entries.add(createEntry("FRANCIA - ELECCIONES PRESIDENCIALES", "link", "Con el 99% de los sufragios escrutados, el candidato socialista François Hollande ha obtenido un 28,56% de los votos, seguido del presidente Nicolas Sarkozy con el 27%; ambos candidatos pasan a la segunda vuelta de las presidenciales que se celebrarón el próximo 6 de mayo. La participación alcanzó el 80%. FUENTE: AGENCIAS ", new Date()));
			entries.add(createEntry("Titulo", "link", "Guillermo lives in Madrid. Madrid is a great city. Barcelona y Madrid necesitan evolucionar. Enfrentamientos en Afganistán. Enfrentamientos in Afganistán. Enfrentamientos at Londres. La ciudad de Talavera de la Reina está situada en la provincia de Toledo. ", new Date()));
			
			
			SyndFeedImpl feed = new SyndFeedImpl();
			feed.setFeedType("rss_2.0");
			feed.setTitle("RSS Personalizado"); 
			feed.setUri("");
			feed.setLink(""); 
			feed.setDescription("Noticias personalizadas"); 
			feed.setCopyright("@gsantosgo");		
			feed.setEntries(entries);
						
		    resp.setContentType(MIME_TYPE);
            SyndFeedOutput output = new SyndFeedOutput();            
            output.output(feed,resp.getWriter()); 

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

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
