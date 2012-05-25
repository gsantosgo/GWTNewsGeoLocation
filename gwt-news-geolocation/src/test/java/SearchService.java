

/**
 * Servicio de servicio de busqueda
 * 
 * @author Guillermo Santos
 */
public interface SearchService<T> {
	 T search(String query) throws Exception;	 
}
