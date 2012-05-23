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

import es.uem.geolocation.client.services.RSSService;
import es.uem.geolocation.server.cache.FeedService;
import es.uem.geolocation.server.cache.FeedServiceImpl;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.RSS;

/**
 * 
 * RSS Service Implementation 
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
	 * Load RSS news (For testing) 
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
									
			// Fenomenos naturales  
			items.add(new Article("METEOROLOGÍA -ADVERSOS","  Precipitaciones que serán de nieve por encima de los 400m. en CATALUÑA y por encima de los 600m. en MALLORCA. Protección Civil ha emitido los correspondientes avisos a la poblacion.","#",new java.util.Date(1236052386666L)));
			items.add(new Article("METEOROLOGÍA - ADVERSOS"," Vientos fuertes en GALICIA, CANTABRIA, PAÍS VASCO y CANARIAS. Protección Civil ha emitido los correspondientes avisos a la población.  ","#",new java.util.Date(1236383620666L)));					 		
			items.add(new Article("RIESGOS NATURALES - VIENTOS","El Instituto Nacional de Meteorología informa de que se pueden registrar vientos superiores a los 130 km/h en el País Vasco, nivel de riesgo (3) alerta roja. Riesgo de vientos fuertes, que pueden alcanzar los 90 Km/h en Asturias, Cantábria, Cuenca y Albacete, nivel de riesgo (2) alerta naranja.","#",new java.util.Date(1213271587666L)));
			items.add(new Article("RIESGOS NATURALES - CORNISA CANTÁBRICA- VIENTO (2)","El Instituto Nacional de Meteorología ha dado por finalizado el Nivel de Riesgo (3) alerta roja por vientos, en la Cornisa Cantábrica. La Dirección General de Protección Civil y Emergencias señala que no se han producido incidentes destacables que afecten a la población ni a servicios esenciales. Los vientos, durante la madrugada y esta mañana, alcanzaron velocidades de hasta 140 km/h provocando caída de árboles, pequeños cortes de fluido eléctrico y retrasos en algunos vuelos.","#",new java.util.Date(1202061185666L)));
			
			// Nacional 
			items.add(new Article("MENORCA - EEB  VACAS LOCAS","  El laboratorio Nacional de Referencia de Encefalopatías Espongiformes Transmisibles de Zaragoza ha confirmado un caso positivo en MENORCA.","#",new java.util.Date(1213267984666L)));						
			items.add(new Article("PAIS VASCO - VIOLENCIA CALLEJERA","Los incidentes en BILBAO y SAN SEBASTIÁN han sido protagonizados por grupos del entorno de BATASUNA que protestaban por el incidente de PAMPLONA.   ","#",new java.util.Date(1296852824666L)));						
			items.add(new Article("ELECCIONES GENERALES Y ANDALUZAS.","La jornada electoral se desarrolla con normalidad. En la constitución de las mesas, apertura se colegios e inicio de votaciones no se registraron incidentes.  ","#",new java.util.Date(1210312406666L)));									
			items.add(new Article("BURGOS - ACCIDENTE","  Un camión que transportaba 16.000 Kg de goma-dos ha volcado en la carretera de accceso a la capital desde la A-1, poniendose en marcha el Plan para riesgo de accidentes en transporte de mercancias peligrosas. Hubo un pequeño conato de incendio que no alcanzó los explosivos. En estos momentos se está procediendo al traslado de los explosivos por lo que se ha interrumpido el tráfico rodado. En el accidente dos personas han resultado heridas leves.","#",new java.util.Date(1256198029666L)));
			items.add(new Article("DETENCIONES - TERRORISMO ISLÁMICO","  La Policía Nacional ha detenido en las últimas horas a cinco  personas, en MADRID, BILBAO y BARCELONA, por su presunta relación con el integrismo islámico. Se descarta su vinculación con los atentados del 11-M.","#",new java.util.Date(1283295216666L)));
			items.add(new Article("BÉTERA - PROTESTA","  Un grupo de quince personas se introdujeron en el recinto de la base militar de la OTAN en Bétera, para reclamar su cierre, tras lo que fueron detenidos por la Guardia Civil, fuera estaban concentradas unas cien personas. ","#",new java.util.Date(1239245602666L)));
			items.add(new Article("GUIPÚZCOA - VIOLENCIA CALLEJERA."," La sede del PSE, en ZUMÁRRAGA,  fue atacada, hacia las 00,30h., con un artefacto incendiario que ha causado daños a un vehículo aparcado en las inmediaciones.  ","#",new java.util.Date(1313794425666L)));
			items.add(new Article("TERUEL - EXPLOSIÓN MINA","  Unos cincuenta mineros han quedado atrapados en una mina al producirse una explosión, seguida de incendio, en la localidad de ARIÑO (TERUEL).","#",new java.util.Date(1271441431484L)));
			items.add(new Article("PAÍS VASCO/NAVARRA - VIOLENCIA CALLEJERA","Del. Gob. País Vasco/Del. Gob. Navarra. Esta madrugada 2 contenedores han sido incendiados en Vitoria afectando a 5 vehículos. En Pamplona 2 cócteles molotov, que no han ardido, se han lanzado contra un cajero automático.","#",new java.util.Date(1247206235468L)));
			items.add(new Article("BARCELONA - ACCIDENTE METRO III"," El conductor ha sido rescatado, a las 18,35h.,  en estado muy grave y ha sido trasladado al Hospital del Valle Hebrón. Otras 39 personas han resultado heridas leves ","#",new java.util.Date(1222517449484L)));
			items.add(new Article("CÁDIZ - INMIGRACIÓN ILEGAL."," La Guardia Civil ha detenido, en el puerto de ALGECIRAS, a 9 inmigrantes indocumentados de origen magrebí, ocultos en el remolque de un camión  procedente de TÁNGER ","#",new java.util.Date(1302221421734L)));
			items.add(new Article("GUIPÚZCOA - DETENCIONES ETA","  El vicepresidente 1º y ministro del Interior ha declarado que los tres detenidos,  vinculados a ETA,  por la policía esta noche se han realizado en EIBAR y en AZPEITIA se han registrado el domicilio de tres personas que han huido. ","#",new java.util.Date(1314853805248L)));			
			items.add(new Article("ALMERÍA - INMIGRACIÓN ILEGAL","La Guardia Civil ha detenido, a primeras horas de hoy, a 21 inmigrantes tras desembarcar desde dos embarcaciones tipo zodiac en ADRA  y en la zona del CABO de GATA. ","#",new java.util.Date(1239127837248L)));
			items.add(new Article("CADIZ - INMIGRACION ILEGAL","  La Guardia Civil ha interceptado una emabarcacion tipo zodiac con 62 inmigrantes de origen magrebí en las inmediaciones de Punta Acebuche frente a las costas de TARIFA","#",new java.util.Date(1320275411500L)));
			items.add(new Article("ZAMORA-INCENDIO FORESTAL","  El incendio se declaró en las proximidades del municipio de MANZANAL DE LOS INFANTES y fue preciso evacuar a unas 50 personas que ya han regresado a sus hogares. No se han visto afectadas infraestructuras ni viviendas. El incendió se ha dado por controlado sobre las 22:15","#",new java.util.Date(1215497443500L)));
			items.add(new Article("BALEARES - INCENDIOS FORESTALES","  El incendio de CALVIA se encuentra controlado. Ha quemado unas 10 has.","#",new java.util.Date(1279678239500L)));
			items.add(new Article("PAÍS VASCO - VIOLENCIA CALLEJERA.","  La sede del PSE - EE en Zumaya (Guipúzcoa), los juzgados de Portugalete (Vizcaya) y un local de Telefónica en Plencia (Vizcaya) han sido atacados esta madrugada con artefactos caseros y cócteles molotov, provocando escasos daños materiales y ninguno personal.","#",new java.util.Date(1294351835484L)));
			items.add(new Article("GRFANADA - INMIGRACIÓN ILEGAL","El Servicio de Vigilancia Aduanera ha interceptado una patera con 55  inmigrantes de origen magrebí en la costa de SALOBREÑA.   ","#",new java.util.Date(1204297828500L)));
			items.add(new Article("CÁDIZ - INMIGRACIÓN ILEGAL","  La Guardia Civil ha interceptado una patera con 73 inmigrantes indocumentados en el área de TARIFA. ","#",new java.util.Date(1280873412500L)));
			items.add(new Article("CANARIAS - ADVERSOS","  Se ha activado el Plan Territorial de Emergencias en Canarias (PLATECA) por alerta naranja (nivel 2) por fuertes precipitaciones y vientos  de hasta 100 km/h en la provincia de Sta. Cruz de Tenerife.","#",new java.util.Date(1262826613484L)));
			items.add(new Article("CÁDIZ - INMIGRACIÓN ILEGAL."," La Guardia Civil ha interceptado en la comarca del Campo de Gibraltar a once inmigrantes indocumentados en varias operaciones realizadas en las últimas 24 horas. ","#",new java.util.Date(1246673403500L)));
			items.add(new Article("SALAMANCA-INCENDIO","  Se ha iniciado un incendio forestal que afecta a roble en el término municipal de Cristóbal. No hay riesgo, en principio para personas o infraestructuras. No hay más datos.","#",new java.util.Date(1302970229500L)));
			items.add(new Article("GUIPUZCOA-AVISO BOMBA","  A las 20:16 se recibió una llamada en nombre de ETA al diario Gara avisando de la colocación de un artefacto explosivo en el estadio Camp Nou en Barcelona. No facilitan más información.","#",new java.util.Date(1204182602326L)));
			items.add(new Article("ACCIDENTE M-30.","Ha fallecido una de las niñas que resultó herida grave en el accidente de la M-30. ","#",new java.util.Date(1273464646091L)));
			items.add(new Article("BARCELONA - INCENDIO FORESTAL.","  El incendio forestal que afecta al termino municipal de Olivella ha quedado controlado tras haber quemado una superficie de 600 Has. Doce viviendas han tenido que ser desalojadas como medida de precaución y la compañía eléctrica ha restablecido ya el servicio a los 64.000 abonados a los que había dejado sin suministro en un corte que también se llevó a cabo para facilitar las labores de los bomberos y otros grupos de extinción en los que han participado cinco hidroaviones.","#",new java.util.Date(1308539401640L)));
			items.add(new Article("CÁDIZ - INMIGRACIÓN ILEGAL.","  La Guardia Civil detuvo esta madrugada en la costa de Algeciras a 23 inmigantes de origen subsahariano, tras haber cruzado el Estrecho de Gibraltar en una patera que consiguió volver hacia el continente africano. ","#",new java.util.Date(1319811059484L)));
			items.add(new Article("ETA.","El propietario de la furgoneta utilizada por ETA para realizar el atentado del aeropuerto de Barajas declaró ayer que a las 9,45 h en Francia había sido puesto en libertad por miembros de la banda terrorista que hace tres días le habían secuestrado y le habían robado su vehículo.     ","#",new java.util.Date(1255831805468L)));			
			items.add(new Article("MELILLA - INMIGRACIÓN","  La Policía Local ha detenido a 2 marroquíes que habían llegado a nado desde el puerto marroquí de BENI ENZAR.","#",new java.util.Date(1285517448500L)));
			items.add(new Article("BALEAREA - INCENDIO FORESTAL","  A las 13,40 h. se ha producidxo un incendio en las cercanías de CALVIA (MALLORCA), no se conoce extensión aunque no se estima que en este momento pase de 50 has., no obstante ha provocado la evacuación de varios chalets y el corte de una carretera autonómica. El área es densamente poblada.","#",new java.util.Date(1296882657500L)));
			items.add(new Article("VIZCAYA - VIOLENCIA CALLEJERA","  Esta noche, las sedes del pueblo de Amorebieta y Abadiño han sido atacadas por desconocidos que vertieron pintura sobre las fachadas.","#",new java.util.Date(1316308244780L)));
			items.add(new Article("INCENDIO BUENDIA (CUENCA)","Se inició en un campamento de niños próximo al embalse de Buendía que tuvo que ser evacuado sin ningún daño personal, 143 personas,  y que han sido llevadas al pueblo de BUENDÍA, el fuego se ha desplazado a la parte de GUADALAJARA. Los medios ordinarios que participan en la extinción son 2 BRIF, 2 aviones anfibios, 1 de coordinación y observación y 2 UMMT, y como medios aéreos extraordinarios 1 avión Hércules de carga en tierra proviniente de Manises (Valencia).","#",new java.util.Date(1205514625500L)));
			
			
			// Internacional
			items.add(new Article("SÁHARA","  El líder del Frente Polisario ha pedido hoy al Secretario General de ONU, Kofi Annan, para que intervenga presionando al rey de Marruecos, Mohamed VI, para que no visite el Sáhara Occidental en los próximos días, por considerarlo una \"provocación\".","#",new java.util.Date(1213347213666L)));
			items.add(new Article("GUINEA  ECUATORIAL - ESPAÑA"," El Presidente OBIANG, durante una manifestación oficialista en protesta por el presunto intento de golpe, declaró que podría romper las relaciones diplomáticas con ESPAÑA  si no se produce la extradición de SEVERO MOTO.  ","#",new java.util.Date(1210301606666L)));
			items.add(new Article("IRAQ - SADAM HUSEIN","  El Tribunal Europeo de Derechos Humanos ha rechazado una demanda presentada, el pasado 29 de junio, por el ex-dictador iraquí contra 21 paises europeos que según Sadam Husein, asumieron el poder en una coalición con EE.UU en Iraq, incluso tras el traspado de poder al Gobierno iraquí en 2004.","#",new java.util.Date(1319323994666L)));
			items.add(new Article("LÍBANO","  El Secretario Gral de Hizbula, Hasan Nasralá, ha declarado en una entrevista publicada en Le Monde ,que su formación está abierta al dialogo con los partidos libaneses, incluido el desarme de su brazo armado.","#",new java.util.Date(1204829588666L)));			
			items.add(new Article("FRANCIA-ARTEFACTOS EXPLOSIVOS","Dos artefactos han sido localizados en la región de Bayona: uno cerca del aeropuerto de Biarritz y otro cerca de la oficina de turismo de Cambo les Bains tras recibir una llamada de aviso anónima en las sedes de los bomberos. Los artefactos estaban compuestos por un pequeño cartucho de camping gas y un despertador y han sido desarticulados por los Tedax franceses.","#",new java.util.Date(1202896387666L)));									
			items.add(new Article("EEUU - LIBERTAD DURADERA","  Talibanes armados se han apoderado de unas oficinas de ACNUR en la ciudad de Spin Boldak, en el sureste de AFGANISTAN, próximo a la frontera con PAKISTAN.","#",new java.util.Date(1219612236484L)));
			items.add(new Article("EE.UU. - LIBERTAD DURADERA","Pequeñas cantidades de esporas de carbunco se han encontrado en la principal oficina postal de WEST PALM BEACH (FLORIDA).","#",new java.util.Date(1286680208484L)));
			items.add(new Article("ORIENTE MEDIO - ATENTADO","  Al menos 12 personas han muerto y decenas han sido heridas en dos atentados suicidas en sendos autobuses. Otra explosión parece haberse producido en un centro comercial. Existe gran confusión en la información. Las tres explosiones han sucedido en la ciudad de BEERSHEVA, en el sur de ISRAEL.","#",new java.util.Date(1282871414500L)));			
			items.add(new Article("RECTIFICACIÓN NOTICIA","Se ha advertido un error en el Informe de Seguimiento 24 horas del día de hoy respecto a la ciudad de destino del avión con ayuda humanitaria hacía IRAN.  Donde dice KERBALA debe decir KERMAN (IRÁN), ciudad situada a unos doscientos Km de la ciudad de BAM.","#",new java.util.Date(1236773424468L)));
			items.add(new Article("TURQUIA -SECUESTRO AEREO","  Un avión de las aerolineas turcas con 203 personas a bordo que realizaba el trayecto ESTAMBUL-ANKARA ha sido secuestrado y desviado hacia GRECIA","#",new java.util.Date(1319512228734L)));
			items.add(new Article("COLOMBIA-ATENTADO","  Un militar falleció y otras cuatro personas resultaron heridas en un atentado con bicicleta-bomba en la ciudad de ARAUCA.","#",new java.util.Date(1265613019515L)));
			items.add(new Article("CONFLICTOS"," El Comité Ministerial de Israel para Asuntos de Colonización ha aprobado un plan para triplicar la población israelí en la meseta del Golán donde establecerán otros nueve asentamientos. Este enclave es reivindicado por Siria en sus propuestas de negociación de paz. ","#",new java.util.Date(1280131809468L)));
			items.add(new Article("KATRINA.","La Gobernadora del estado de Louisiana ordenó ayer la evacuación de decenas de miles de personas refugiadas en el estadio Superdome y otras instalaciones, ante el incremento del nivel del agua en la ciudad. El Gobernador de Mississippi ha confirmado que han muerto más de 100 en un sólo condado, el de Harrison.   ","#",new java.util.Date(1264115411500L)));
			items.add(new Article("TURQUÍA - ACCIDENTE","Agencias:Avión con 49 pasajeros y 7 tripulantes se ha estrellado esta madrugada en Isparta antes de tomar tierra procedente de Estambul. Se desconocen las causas y los servicios de emergencia descartan que haya supervivientes.","#",new java.util.Date(1218640252531L)));
			items.add(new Article("IRAQ","Agencias: Ministerio Interior iraquí informa hoy ha muerto Ayyub al-Masri, lider de al Qaeda en Iraq. ","#",new java.util.Date(1216037075060L)));
			items.add(new Article("BRETAÑA - NAUFRAGIO CARGUERO","  Un carguero italiano con unas 6.000 tm de productos químicos a bordo ha naufragado a unos 19 km al norte de la isla de AURIGNY (UK). Al parecer, parte de la carga podría ser altamente tóxica y corrosiba.","#",new java.util.Date(1234429840484L)));
			items.add(new Article("ORIENTE MEDIO - CONFLICTO","  La incursión del ejército israelí en la población de BEIT LAGHYE, que comenzó el pasado martes, ha concluido hoy con un balance de 15 palestinos muertos y 60 heridos, sin que se hayan producido víctimas en las fuerzas israelíes.","#",new java.util.Date(1241647817139L)));
			items.add(new Article("IRAK - CONFLICTO","  El Secretario General de NNUU ha declarado que no existen motivos para un ataque inmediato contra IRAK y ha pedido que se esperen los resultadfos de las inspecciones.","#",new java.util.Date(1267175421468L)));
			items.add(new Article("BARCOS - COLISIÓN","  El pesquero  VIGO 2 (TOGO) con 16 tripulantes a bordo, entre ellos el patrón de nacionalidad española,  ha colisionado con el carguero ATENI (GRECIA)  cerca de Cabo BLANCO, entre MAURITANIA  y CANARIAS. Toda la tripulación del pesquero ha sido rescatada y se encuentra en buenas condiciones físicas. ","#",new java.util.Date(1215771047515L)));
			items.add(new Article("O.PROXIMO-ATENTADO","  Un atentado suicida se ha registrado en la cafetería de la Universidad Hebrera de JERUSALEM causando, al menos, siete muertos y treinta heridos.","#",new java.util.Date(1299798611500L)));			
			items.add(new Article("BAGDAD - ACCIDENTE","Centenares de personas podrían haber muerto al hundirse parte de un puente sobre el rio Tigris.","#",new java.util.Date(1263006606500L)));
			items.add(new Article("ORIENTE MEDIO - CONFLICTO","  Tres ciudadanos israelíes resultaron muertos por un tirador palestino, que también murió, en el asentamiento de ITAMAR, cerca de NAPLUSA. Horas antes otro ciudadano israelí murió al ser tiroteado su coche en las cercanías de RAMALA. ","#",new java.util.Date(1298560209656L)));
			items.add(new Article("IRÁN - AYUDA HUMANITARIA ESPAÑOLA.","  El segundo vuelo con ayuda humanitaria española ha despegado de la base aérea de TORREJÓN a las 08.00 h. La duración del vuelo hasta KERBALA es de 10 h.","#",new java.util.Date(1314076250468L)));
			items.add(new Article("AFGANISTAN - INCIDENTES","  Cinco milicianos pro-gubernamentales murieron el pasado lunes en una emboscada tendida por talibanes en la provincia de ZABUL, en el sureste del país, en la ruta entre KABUL y KANDAHAR. Los cinco fueron ejecutados después de haber sido llevados fuera de la ruta.El mismo día, los talibanes atacaron un edificio gubernamental en la capital del distrito de MIZAN , también en la provincia de ZABUL. El ataque fue repelido y se capturó con vida a cuatro de los atacantes.","#",new java.util.Date(1299154210950L)));
			items.add(new Article("IRAQ - CONFLICTO","  Mtro. Portavoz IRAQ: \"hoy utilizaremos algo no convencional\" contra las tropas de la coalición.Además indica que los avances realizados por la coalición se han debido, en todos los frentes, a columnas que pretendían ganar posiciones y que han sido rechazadas en todos los frentes alrededor de BAGDAD. En cuato al aeropuerto ha admitido que fuerzas estadounidenses han llegado a él, pero indica que están aislados y que \"moriran todos sino se entregan rapidamente\". En BASORA tambien dice que han rechazado reiteradamente al enemigo. En todos los casos hace referencia a múiltiples bajas en hombres, transportes y carros en las fuerezas de la coalición.","#",new java.util.Date(1234645851950L)));			
			
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
}
