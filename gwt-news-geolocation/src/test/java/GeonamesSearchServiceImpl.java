

/*import es.uem.support.database.SampleDBService;
import es.uem.support.lucene.SampleLuceneSearcher;
import es.uem.support.model.Person;*/ 
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

/** 
 * 
 * Implementaci�n Servicios de B�squeda de Geonames
 *  
 * @author Guillermo Santos 
 *
 */
public class GeonamesSearchServiceImpl implements SearchService<List<Toponym>> {
    protected LoadingCache<String, List<Toponym>> cache;

    /**
     * Constructor 
     */
    public GeonamesSearchServiceImpl() {    	
        buildCache();
    }    

    private void buildCache() {    	                        
        cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(1000)
                //.refreshAfterWrite(duration, unit)
                .build(new CacheLoader<String, List<Toponym>>() {
                    @Override
                    public List<Toponym> load(String queryKey) throws Exception {
                		List<Toponym> toponymList = new ArrayList<Toponym>();
                		try {
                			ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();			
                			searchCriteria.setLanguage("ES");
                			searchCriteria.setNameEquals(queryKey);
                			searchCriteria.setStartRow(0);
                			searchCriteria.setStyle(Style.LONG); // Importante

                			WebService.setUserName("gsantosgo");

                		                			
                			
                			
                			ToponymSearchResult searchResult = WebService.search(searchCriteria);
                			for (org.geonames.Toponym toponym : searchResult.getToponyms()) {
                				Toponym newToponym = new Toponym();
                				newToponym.setGeoNameId(toponym.getGeoNameId());
                				newToponym.setName(toponym.getName());
                				newToponym.setContinentCode(toponym.getContinentCode());
                				newToponym.setCountryCode(toponym.getCountryCode()); 
                				newToponym.setCountryName(toponym.getCountryName());
                				newToponym.setAlternateNames(toponym.getAlternateNames());
                				newToponym.setFeatureCode(toponym.getFeatureCode());
                				newToponym.setFeatureCodeName(toponym.getFeatureCodeName());
                				newToponym.setFeatureClass(toponym.getFeatureClass().name()); 
                				newToponym.setFeatureClassName(toponym.getFeatureClassName());
                				newToponym.setLatitude(toponym.getLatitude());
                				newToponym.setLongitude(toponym.getLongitude());
                				newToponym.setElevation(toponym.getElevation());
                				newToponym.setPopulation(toponym.getPopulation());

                				toponymList.add(newToponym);
                			}
                		} catch (Exception e) {
                			e.printStackTrace();
                		}
                		return toponymList;                    	
                    }
                });
    }
       
    public List<Toponym> search(String query) throws Exception {
    	return cache.get(query);    
    }
    
    public Cache<String, List<Toponym>> getCache() {
        return cache;
    }


}