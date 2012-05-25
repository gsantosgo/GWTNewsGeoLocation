

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class Main {

	/**
	 *  
	 * Programa principal 
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		//Configuracion PROXY. Para conectarse correctamente este necesario configurar el PROXY.
        System.setProperty("http.proxySet","true");
        System.setProperty("http.proxyHost","10.14.79.204");
        System.setProperty("http.proxyPort","8080");
        System.setProperty("http.proxyUser","");
        System.setProperty("http.proxyPassword","");		

       	Stopwatch stopWatch = new Stopwatch(); 
		GeonamesSearchServiceImpl search = new GeonamesSearchServiceImpl();   
		for (int i=0;i<1000;i++) {
			System.out.println(search.getCache().stats());			

			stopWatch.start();
			List<Toponym>  lista = search.search("Talavera de la Reina");		
			System.out.println(stopWatch.elapsedTime(TimeUnit.MILLISECONDS));
			System.out.println("Size: " + lista.size() + ",Query" + lista.toString());
			stopWatch.reset();
			stopWatch.start();
			List<Toponym>  lista2 = search.search("Madrid");	
			System.out.println(stopWatch.elapsedTime(TimeUnit.MILLISECONDS));
			stopWatch.reset();			
			System.out.println("Size: " + lista2.size() + ",Query" + lista2.toString());			
			Thread.sleep(1 * 1000);
		}	
	}

}
