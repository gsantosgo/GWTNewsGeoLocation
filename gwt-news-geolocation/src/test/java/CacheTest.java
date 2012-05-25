
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class CacheTest {

	/**
	 * Programa principal 
	 * 
	 * @param args
	 */
	public static void main(String args[]) throws Exception {
	
		// Create the cache. Only allow a max of 10 entries.
		// Old entries will be evicted.
		final Cache<String, String> cache = CacheBuilder.newBuilder()
		    .maximumSize(10)
		    .removalListener(new RemovalListener<String, String>() {
				public void onRemoval(
						RemovalNotification<String, String> notification) {
		            System.out.println("REMOVED: " + notification);										
				}
		    	
			})		    		   
		    .build(new CacheLoader<String, String>() {
		        @Override
		        public String load(String key) throws Exception {
		            System.out.println("LOADING: " + key);
		            return key + "-VALUE";
		        }
		    }); 
			
		// Get values from the cache.
		// If a key does not exist, it will be loaded.
		for (int i = 0; i < 10; i++) {
//		  System.out.println(cache.get("Key" + i));
		}
		
		
		for (int i = 9; i >= 0; i--) {
//		  System.out.println(cache.get("Key" + i));
		}
		
		//Print out the hit counts.
		System.out.println(cache.stats());		
	}
}
