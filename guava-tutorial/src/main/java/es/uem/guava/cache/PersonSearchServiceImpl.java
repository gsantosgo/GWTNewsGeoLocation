package es.uem.guava.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;


public class PersonSearchServiceImpl implements SearchService<List<String>> {
	protected LoadingCache<String, List<String>> cache;
	
	public PersonSearchServiceImpl() {
		buildCache();
	}

	//@Override
	public List<String> search(String query) throws Exception {
		return cache.get(query);
	}

	private void buildCache() {
		cache = CacheBuilder.newBuilder()
				.expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000)
				.build(new CacheLoader<String, List<String>>() {
					
					@Override
					public List<String> load(String queryKey) throws Exception {

						System.out.println("Entraaaaaa");
						List<String> out = Lists.newArrayList(); 
						if (queryKey.equals("hola")) {							
							out.add("hola1"); 
							out.add("hola2"); 
							out.add("hola3"); 
						}
						
						if (queryKey.equals("hola2")) {
							out.add("holax"); 
							out.add("holay"); 
							out.add("holaz");
							 							
						}	
						return out;
					}
				});
	}
}
