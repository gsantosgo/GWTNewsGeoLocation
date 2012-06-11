package es.uem.gazetteer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.geonames.*;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


/**
 * 
 * Override Geonames WebService 
 * 
 * @author GSantos
 *
 */
public class MyWebService {
	private static Logger logger = Logger.getLogger("es.uem.geolocation.geonames");
	private static String USER_AGENT = "gnwsc/1.1.6";
	private static boolean isAndroid = false;
	private static String geoNamesServer = "http://api.geonames.org";
	private static String geoNamesServerFailover = "http://api.geonames.org";
	private static long timeOfLastFailureMainServer;
	private static long averageConnectTime;
	private static long averageSampleSize = 20;
	private static Style defaultStyle = Style.MEDIUM;
	private static int readTimeOut = 120000;
	private static int connectTimeOut = 10000;
	private static String DATEFMT = "yyyy-MM-dd HH:mm:ss";

	static {
		USER_AGENT += " (";
		String os = System.getProperty("os.name");
		if (os != null) {
			USER_AGENT += os + ",";
		}
		String osVersion = System.getProperty("os.version");
		if (osVersion != null) {
			USER_AGENT += osVersion;
		}
		USER_AGENT += ")";

		// android version
		try {
			Class aClass = Class.forName("android.os.Build");
			if (aClass != null) {
				isAndroid = true;
				Field[] fields = aClass.getFields();
				if (fields != null) {
					for (Field field : fields) {
						if ("MODEL".equalsIgnoreCase(field.getName())) {
							USER_AGENT += "(" + field.get(aClass) + ", ";
						}
					}
				}
				aClass = Class.forName("android.os.Build$VERSION");
				if (aClass != null) {
					fields = aClass.getFields();
					if (fields != null) {
						for (Field field : fields) {
							if ("RELEASE".equalsIgnoreCase(field.getName())) {
								USER_AGENT += field.get(aClass);
							}
						}
					}
				}
				USER_AGENT += ")";
			}
		} catch (Throwable t) {
		}
	}

	/**
	 * user name to pass to commercial web services for authentication and
	 * authorization
	 */
	private static String userName;

	/**
	 * token to pass to as optional authentication parameter to the commercial
	 * web services.
	 */
	private static String token;

	/**
	 * adds the username stored in a static variable to the url. It also adds a
	 * token if one has been set with the static setter previously.
	 * 
	 * @param url
	 * @return url with the username appended
	 */
	private static String addUserName(String url) {
		if (userName != null) {
			url = url + "&username=" + userName;
		}
		if (token != null) {
			url = url + "&token=" + token;
		}
		return url;
	}

	/**
	 * adds the default style to the url. The default style can be set with the
	 * static setter. It is 'MEDIUM' if not set.
	 * 
	 * @param url
	 * @return url with the style parameter appended
	 */
	private static String addDefaultStyle(String url) {
		if (defaultStyle != Style.MEDIUM) {
			url = url + "&style=" + defaultStyle.name();
		}
		return url;
	}

	/**
	 * returns the currently active server. Normally this is the main server, if
	 * the main server recently failed then the failover server is returned. If
	 * the main server is not available we don't want to try with every request
	 * whether it is available again. We switch to the failover server and try
	 * from time to time whether the main server is again accessible.
	 * 
	 * @return
	 */
	private static String getCurrentlyActiveServer() {
		if (timeOfLastFailureMainServer == 0) {
			// no problems with main server
			return geoNamesServer;
		}
		// we had problems with main server
		if (System.currentTimeMillis() - timeOfLastFailureMainServer > 1000l * 60l * 10l) {
			// but is was some time ago and we switch back to the main server to
			// retry. The problem may have been solved in the mean time.
			timeOfLastFailureMainServer = 0;
			return geoNamesServer;
		}
		if (System.currentTimeMillis() < timeOfLastFailureMainServer) {
			throw new Error("time of last failure cannot be in future.");
		}
		// the problems have been very recent and we continue with failover
		// server
		if (geoNamesServerFailover != null) {
			return geoNamesServerFailover;
		}
		return geoNamesServer;
	}

	/**
	 * @return the isAndroid
	 */
	public static boolean isAndroid() {
		return isAndroid;
	}

	/**
	 * opens the connection to the url and sets the user agent. In case of an
	 * IOException it checks whether a failover server is set and connects to
	 * the failover server if it has been defined and if it is different from
	 * the normal server.
	 * 
	 * @param url
	 *            the url to connect to
	 * @return returns the inputstream for the connection
	 * @throws IOException
	 */
	private static InputStream connect(String url) throws IOException {
		int status = 0;
		String currentlyActiveServer = getCurrentlyActiveServer();
		try {
			long begin = System.currentTimeMillis();
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(
					currentlyActiveServer + url).openConnection();
			httpConnection.setConnectTimeout(connectTimeOut);
			httpConnection.setReadTimeout(readTimeOut);
			httpConnection.setRequestProperty("User-Agent", USER_AGENT);
			InputStream in = httpConnection.getInputStream();
			status = httpConnection.getResponseCode();

			if (status == 200) {
				long elapsedTime = System.currentTimeMillis() - begin;
				averageConnectTime = (averageConnectTime
						* (averageSampleSize - 1) + elapsedTime)
						/ averageSampleSize;
				// if the average elapsed time is too long we switch server
				if (geoNamesServerFailover != null
						&& averageConnectTime > 5000
						&& !currentlyActiveServer
								.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
				}
				return in;
			}
		} catch (IOException e) {
			return tryFailoverServer(url, currentlyActiveServer, 0, e);
		}
		// we only get here if we had a statuscode <> 200
		IOException ioException = new IOException("status code " + status
				+ " for " + url);
		return tryFailoverServer(url, currentlyActiveServer, status,
				ioException);
	}

	private static synchronized InputStream tryFailoverServer(String url,
			String currentlyActiveServer, int status, IOException e)
			throws MalformedURLException, IOException {
		// we cannot reach the server
		logger.log(Level.WARNING, "problems connecting to geonames server "
				+ currentlyActiveServer, e);
		// is a failover server defined?
		if (geoNamesServerFailover == null
		// is it different from the one we are using?
				|| currentlyActiveServer.equals(geoNamesServerFailover)) {
			if (currentlyActiveServer.equals(geoNamesServerFailover)) {
				// failover server is not accessible, we throw exception
				// and switch back to main server.
				timeOfLastFailureMainServer = 0;
			}
			throw e;
		}
		timeOfLastFailureMainServer = System.currentTimeMillis();
		logger.info("trying to connect to failover server "
				+ geoNamesServerFailover);
		// try failover server
		URLConnection conn = new URL(geoNamesServerFailover + url)
				.openConnection();
		String userAgent = USER_AGENT + " failover from " + geoNamesServer;
		if (status != 0) {
			userAgent += " " + status;
		}
		conn.setRequestProperty("User-Agent", userAgent);
		InputStream in = conn.getInputStream();
		return in;
	}

	private static Element connectAndParse(String url)
			throws GeoNamesException, IOException, JDOMException {
		SAXBuilder parser = new SAXBuilder();
		Document doc = parser.build(connect(url));
		try {
			Element root = rootAndCheckException(doc);
			return root;
		} catch (GeoNamesException geoNamesException) {
			if (geoNamesException.getExceptionCode() == 13
					|| (geoNamesException.getMessage() != null && geoNamesException
							.getMessage()
							.indexOf(
									"canceling statement due to statement timeout") > -1)) {
				String currentlyActiveServer = getCurrentlyActiveServer();
				if (geoNamesServerFailover != null
						&& !currentlyActiveServer
								.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
					doc = parser.build(connect(url));
					Element root = rootAndCheckException(doc);
					return root;
				}
			}
			throw geoNamesException;
		}
	}

	private static Element rootAndCheckException(Document doc)
			throws GeoNamesException {
		Element root = doc.getRootElement();
		checkException(root);
		return root;
	}

	private static void checkException(Element root) throws GeoNamesException {
		Element message = root.getChild("status");
		if (message != null) {
			int code = 0;
			try {
				code = Integer.parseInt(message.getAttributeValue("value"));
			} catch (NumberFormatException numberFormatException) {
			}
			throw new GeoNamesException(code,
					message.getAttributeValue("message"));
		}
	}

	/**
	 * 
	 * 
	 * @param toponymElement
	 * @return
	 */
	public static ToponymCountry getToponymCountryInfoFromElement(Element toponymElement) {
		ToponymCountry toponym = new ToponymCountry();
		
		toponym.setCountryName(toponymElement.getChildText("countryName"));
		toponym.setCountryCode(toponymElement.getChildText("countryCode"));
		toponym.setIsoAlpha2(toponymElement.getChildText("countryCode")); 
		toponym.setIsoNumeric(toponymElement.getChildText("isoNumeric"));
		toponym.setIsoAlpha3(toponymElement.getChildText("isoAlpha3"));
		toponym.setFipsCode(toponymElement.getChildText("fipsCode"));
				
		toponym.setContinentCode(toponymElement.getChildText("continent"));
		toponym.setContinentName(toponymElement.getChildText("continentName"));
		toponym.setCapital(toponymElement.getChildText("capital"));
		
		String areaInSqKm = toponymElement.getChildText("areaInSqKm"); 
		if (areaInSqKm != null && !"".equals(areaInSqKm)) {
			toponym.setAreaInSqKm(Double.parseDouble(areaInSqKm)); 
		}

		String population = toponymElement.getChildText("population");
		if (population != null && !"".equals(population)) {
			toponym.setPopulation(Long.parseLong(population));
		}

		toponym.setCurrencyCode(toponymElement.getChildText("currencyCode"));
		toponym.setLanguages(toponymElement.getChildText("languages"));
		
		String geonameId = toponymElement.getChildText("geonameId");
		if (geonameId != null) {
			toponym.setGeoNameId(Integer.parseInt(geonameId));
		}		
										
		toponym.setWest(Double.parseDouble(toponymElement.getChildText("west")));
		toponym.setNorth(Double.parseDouble(toponymElement.getChildText("north")));
		toponym.setEast(Double.parseDouble(toponymElement.getChildText("east")));
		toponym.setSouth(Double.parseDouble(toponymElement.getChildText("south"))); 
				
		return toponym;
	}
	
	/**
	 * 
	 * Get toponym continent and country. 
	 * 
	 * @param toponymElement
	 * @return
	 */
	public static ToponymCountry getToponymContinentCountryFromElement(Element toponymElement) {		
		ToponymCountry toponym = new ToponymCountry();
		toponym.setName(toponymElement.getChildText("name"));
		toponym.setAlternateNames(toponymElement.getChildText("alternateNames"));
		toponym.setLatitude(Double.parseDouble(toponymElement
				.getChildText("lat")));
		toponym.setLongitude(Double.parseDouble(toponymElement
				.getChildText("lng")));

		String geonameId = toponymElement.getChildText("geonameId");
		if (geonameId != null) {
			toponym.setGeoNameId(Integer.parseInt(geonameId));
		}

		toponym.setContinentCode(toponymElement.getChildText("continentCode"));
		toponym.setCountryCode(toponymElement.getChildText("countryCode"));
		toponym.setCountryName(toponymElement.getChildText("countryName"));
		 
		toponym.setFeatureClass(FeatureClass.fromValue(toponymElement
				.getChildText("fcl")).toString());
		toponym.setFeatureCode(toponymElement.getChildText("fcode"));

		toponym.setFeatureClassName(toponymElement.getChildText("fclName"));
		toponym.setFeatureCodeName(toponymElement.getChildText("fCodeName"));

		String population = toponymElement.getChildText("population");
		if (population != null && !"".equals(population)) {
			toponym.setPopulation(Long.parseLong(population));
		}
		String elevation = toponymElement.getChildText("elevation");
		if (elevation != null && !"".equals(elevation)) {
			toponym.setElevation(Integer.parseInt(elevation));
		}

		/* 
		 * 
		toponym.setAdminCode1(toponymElement.getChildText("adminCode1"));
		toponym.setAdminName1(toponymElement.getChildText("adminName1"));
		toponym.setAdminCode2(toponymElement.getChildText("adminCode2"));
		toponym.setAdminName2(toponymElement.getChildText("adminName2"));
		toponym.setAdminCode3(toponymElement.getChildText("adminCode3"));
		toponym.setAdminCode4(toponymElement.getChildText("adminCode4"));
					
		Element timezoneElement = toponymElement.getChild("timezone");
		if (timezoneElement != null) {
			Timezone timezone = new Timezone();
			timezone.setTimezoneId(timezoneElement.getValue());
			timezone.setDstOffset(Double.parseDouble(timezoneElement
					.getAttributeValue("dstOffset")));
			timezone.setGmtOffset(Double.parseDouble(timezoneElement
					.getAttributeValue("gmtOffset")));
			toponym.setTimezone(timezone);
		}*/ 
		
		
		Element bboxElement = toponymElement.getChild("bbox");
		if (bboxElement != null) {						
			toponym.setWest(Double.parseDouble(bboxElement
					.getChildText("west")));
			toponym.setNorth(Double.parseDouble(bboxElement
					.getChildText("north")));
			toponym.setEast(Double.parseDouble(bboxElement
					.getChildText("east")));
			toponym.setSouth(Double.parseDouble(bboxElement
					.getChildText("south"))); 
		}
		
		toponym.setScore(Double.parseDouble(toponymElement
				.getChildText("score"))); 
		
		return toponym;
	}
		
	
	/**
	 *   
	 * 
	 * full text search on the GeoNames database.
	 * 
	 * This service gets the number of toponyms defined by the 'maxRows'
	 * parameter. The parameter 'style' determines which fields are returned by
	 * the service.
	 * 
	 * @see <a href="http://www.geonames.org/export/geonames-search.html">search
	 *      web service documentation</a>
	 * 
	 * <br>
	 * 
	 *      <pre>
	 * ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
	 * searchCriteria.setQ(&quot;z&amp;uumlrich&quot;);
	 * ToponymSearchResult searchResult = WebService.search(searchCriteria);
	 * for (Toponym toponym : searchResult.toponyms) {
	 * 	System.out.println(toponym.getName() + &quot; &quot; + toponym.getCountryName());
	 * }
	 * </pre>
	 * 
	 * 
	 * @param searchCriteria
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResultCustom search(
			ToponymSearchCriteria searchCriteria) throws Exception {
		ToponymSearchResultCustom searchResultCustom = new ToponymSearchResultCustom();

		String url = "/search?";

		if (searchCriteria.getQ() != null) {
			url = url + "q=" + URLEncoder.encode(searchCriteria.getQ(), "UTF8");
		}
		if (searchCriteria.getNameEquals() != null) {
			url = url + "&name_equals="
					+ URLEncoder.encode(searchCriteria.getNameEquals(), "UTF8");
		}
		if (searchCriteria.getNameStartsWith() != null) {
			url = url
					+ "&name_startsWith="
					+ URLEncoder.encode(searchCriteria.getNameStartsWith(),
							"UTF8");
		}

		if (searchCriteria.getName() != null) {
			url = url + "&name="
					+ URLEncoder.encode(searchCriteria.getName(), "UTF8");
		}

		if (searchCriteria.getTag() != null) {
			url = url + "&tag="
					+ URLEncoder.encode(searchCriteria.getTag(), "UTF8");
		}

		if (searchCriteria.getCountryCode() != null) {
			url = url + "&country=" + searchCriteria.getCountryCode();
		}
		if (searchCriteria.getCountryBias() != null) {
			if (!url.endsWith("&")) {
				url = url + "&";
			}
			url = url + "countryBias=" + searchCriteria.getCountryBias();
		}
		if (searchCriteria.getContinentCode() != null) {
			url = url + "&continentCode=" + searchCriteria.getContinentCode();
		}

		if (searchCriteria.getAdminCode1() != null) {
			url = url + "&adminCode1="
					+ URLEncoder.encode(searchCriteria.getAdminCode1(), "UTF8");
		}
		if (searchCriteria.getAdminCode2() != null) {
			url = url + "&adminCode2="
					+ URLEncoder.encode(searchCriteria.getAdminCode2(), "UTF8");
		}
		if (searchCriteria.getAdminCode3() != null) {
			url = url + "&adminCode3="
					+ URLEncoder.encode(searchCriteria.getAdminCode3(), "UTF8");
		}
		if (searchCriteria.getAdminCode4() != null) {
			url = url + "&adminCode4="
					+ URLEncoder.encode(searchCriteria.getAdminCode4(), "UTF8");
		}

		if (searchCriteria.getLanguage() != null) {
			url = url + "&lang=" + searchCriteria.getLanguage();
		}

		if (searchCriteria.getFeatureClass() != null) {
			url = url + "&featureClass=" + searchCriteria.getFeatureClass();
		}

		if (searchCriteria.getFeatureCodes() != null) {
			for (String featureCode : searchCriteria.getFeatureCodes()) {
				url = url + "&fcode=" + featureCode;
			}
		}
		if (searchCriteria.getMaxRows() > 0) {
			url = url + "&maxRows=" + searchCriteria.getMaxRows();
		}
		if (searchCriteria.getStartRow() > 0) {
			url = url + "&startRow=" + searchCriteria.getStartRow();
		}

		if (searchCriteria.getStyle() != null) {
			url = url + "&style=" + searchCriteria.getStyle();
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		searchResultCustom.setTotalResultsCount(Integer.parseInt(root
				.getChildText("totalResultsCount"))); 
		searchResultCustom.setStyle(Style.valueOf(root.getAttributeValue("style")));
		
		
		List<Toponym> toponyms = new ArrayList<Toponym>(); 
		for (Object obj : root.getChildren("geoname")) {						
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymContinentCountryFromElement(toponymElement);		
			toponyms.add(toponym); 			 
		}
		searchResultCustom.setToponyms(toponyms);

		return searchResultCustom;
	}	
	
	
	public static ToponymSearchResultCustom countryInfo(ToponymSearchCriteria searchCriteria) throws Exception {
		ToponymSearchResultCustom searchResultCustom = new ToponymSearchResultCustom();

		String url = "/countryInfo?";

		if (searchCriteria.getLanguage() != null) {
			url = url + "&lang=" + searchCriteria.getLanguage();
		}

		if (searchCriteria.getStyle() != null) {
			url = url + "&style=" + searchCriteria.getStyle();
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
				
		List<Toponym> toponyms = new ArrayList<Toponym>(); 
		for (Object obj : root.getChildren("country")) {						
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymCountryInfoFromElement(toponymElement);
			toponyms.add(toponym); 			 
		}
		searchResultCustom.setTotalResultsCount(toponyms.size()); 		
		searchResultCustom.setToponyms(toponyms);

		return searchResultCustom;
	}	


	/**
	 * @return the geoNamesServer, default is http://ws.geonames.org
	 */
	public static String getGeoNamesServer() {
		return geoNamesServer;
	}

	/**
	 * @return the geoNamesServerFailover
	 */
	public static String getGeoNamesServerFailover() {
		return geoNamesServerFailover;
	}

	/**
	 * sets the server name for the GeoNames server to be used for the requests.
	 * Default is ws.geonames.org
	 * 
	 * @param geoNamesServer
	 *            the geonamesServer to set
	 */
	public static void setGeoNamesServer(String pGeoNamesServer) {
		if (pGeoNamesServer == null) {
			throw new Error();
		}
		pGeoNamesServer = pGeoNamesServer.trim().toLowerCase();
		// add default http protocol if it is missing
		if (!pGeoNamesServer.startsWith("http://")
				&& !pGeoNamesServer.startsWith("https://")) {
			pGeoNamesServer = "http://" + pGeoNamesServer;
		}
		MyWebService.geoNamesServer = pGeoNamesServer;
	}

	/**
	 * sets the default failover server for requests in case the main server is
	 * not accessible. Default is ws.geonames.org<br>
	 * The failover server is only called if it is different from the main
	 * server.<br>
	 * The failover server is used for commercial GeoNames web service users.
	 * 
	 * @param geoNamesServerFailover
	 *            the geoNamesServerFailover to set
	 */
	public static void setGeoNamesServerFailover(String geoNamesServerFailover) {
		if (geoNamesServerFailover != null) {
			geoNamesServerFailover = geoNamesServerFailover.trim()
					.toLowerCase();
			if (!geoNamesServerFailover.startsWith("http://")) {
				geoNamesServerFailover = "http://" + geoNamesServerFailover;
			}
		}
		MyWebService.geoNamesServerFailover = geoNamesServerFailover;
	}

	/**
	 * @return the userName
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name to be used for the requests. Needed to access the
	 * commercial GeoNames web services.
	 * 
	 * @param userName
	 *            the userName to set
	 */
	public static void setUserName(String userName) {
		MyWebService.userName = userName;
	}

	/**
	 * @return the token
	 */
	public static String getToken() {
		return token;
	}

	/**
	 * sets the token to be used to authenticate the requests. This is an
	 * optional parameter for the commercial version of the GeoNames web
	 * services.
	 * 
	 * @param token
	 *            the token to set
	 */
	public static void setToken(String token) {
		MyWebService.token = token;
	}

	/**
	 * @return the defaultStyle
	 */
	public static Style getDefaultStyle() {
		return defaultStyle;
	}

	/**
	 * @param defaultStyle
	 *            the defaultStyle to set
	 */
	public static void setDefaultStyle(Style defaultStyle) {
		MyWebService.defaultStyle = defaultStyle;
	}

	/**
	 * @return the readTimeOut
	 */
	public static int getReadTimeOut() {
		return readTimeOut;
	}

	/**
	 * @param readTimeOut
	 *            the readTimeOut to set
	 */
	public static void setReadTimeOut(int readTimeOut) {
		MyWebService.readTimeOut = readTimeOut;
	}

	/**
	 * @return the connectTimeOut
	 */
	public static int getConnectTimeOut() {
		return connectTimeOut;
	}

	/**
	 * @param connectTimeOut
	 *            the connectTimeOut to set
	 */
	public static void setConnectTimeOut(int connectTimeOut) {
		MyWebService.connectTimeOut = connectTimeOut;
	}

}
