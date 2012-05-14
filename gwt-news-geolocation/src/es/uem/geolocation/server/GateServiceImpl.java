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

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import es.uem.geolocation.client.Constant;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.services.GateService;

import gate.*;
import gate.creole.*;
import gate.util.persistence.PersistenceManager;
import gate.corpora.DocumentContentImpl;
import gate.corpora.DocumentImpl;

/**
 * 
 * GATE-ANNIE Service Implementation  
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */

@SuppressWarnings("serial")
public class GateServiceImpl extends RemoteServiceServlet implements
		GateService {
	//private RealtimeCorpusController annieController; 
	private SerialAnalyserController annieController;

	@Override
	public void init() throws ServletException {
		if (!Gate.isInitialised()) {
			try {
				ServletContext servletContext = getServletContext();
				File gateHome = new File(
						servletContext.getRealPath(Constant.WEB_INF));

				// Establece directorio de instalación GATE
				Gate.setGateHome(gateHome);
				Gate.setUserConfigFile(new File(gateHome, Constant.USER_GATE));

				// Inicializando Gate
				Gate.init();

				// Cargando plugin ANNIE
				// Gate.getCreoleRegister().registerDirectories(servletContext.getResource(Constant.PLUGIN_ANNIE));
				Gate.getCreoleRegister().registerDirectories(
						new File(Gate.getPluginsHome(),
								ANNIEConstants.PLUGIN_DIR).toURI().toURL());

				// DEFAULT_FILE = "ANNIE_with_defaults.gapp";
				// FILE_LOCATIONS = "ANNIE_locations.gapp";
								
				annieController = (SerialAnalyserController) PersistenceManager
						.loadObjectFromFile(new File(new File(Gate
								.getPluginsHome(), ANNIEConstants.PLUGIN_DIR),
								Constant.FILE_LOCATIONS));

			} catch (Exception ex) {
				throw new ServletException(
						"Excepcion en la inicializacion GATE ", ex);
			}
		} // end init() 
	}

	/**
	 * Metodo que nos sirve para obtener Entidades Nombradas
	 */
	public List<String> getNamedEntities(String texto) throws ExecutionException, ResourceInstantiationException {
		// Para eliminar elementos repetidos.  
		Set<String> namedEntities = new HashSet<String>();  
		if (Gate.isInitialised()) {
				gate.Corpus corpus = (Corpus) Factory
						.createResource("gate.corpora.CorpusImpl");

				Document document = new DocumentImpl();
				DocumentContentImpl documentContent = new DocumentContentImpl(
						texto);
				document.setContent(documentContent);

				corpus.clear();
				corpus.add(document);

				annieController.cleanup();
				annieController.setCorpus(corpus);
				annieController.execute();

				Set<String> annotationTypesRequired = new HashSet<String>();
				annotationTypesRequired
						.add(ANNIEConstants.LOCATION_ANNOTATION_TYPE);

				Iterator<Document> iterator = corpus.iterator();
				while (iterator.hasNext()) {
					Document document2 = (Document) iterator.next();
					AnnotationSet defaultAnnotationSet = document2
							.getAnnotations();
					Set<Annotation> locations = new HashSet<Annotation>(
							defaultAnnotationSet.get(annotationTypesRequired));

					Iterator<Annotation> annotations = locations.iterator();
					while (annotations.hasNext()) {
						Annotation annotation = (Annotation) annotations.next();						
						long start = annotation.getStartNode().getOffset(); 
						long end = annotation.getEndNode().getOffset();											
						String location = document2.getContent().toString().substring((int)start,(int) end);						
						namedEntities.add(location); 
					}
				}
		}
				 
		return new ArrayList<String>(namedEntities); 
	} // end getNamedEntities 

	@Override
	public void destroy() {
		super.destroy();
		if (annieController != null) {
			annieController = null;
		}
	} // end destroy

}
