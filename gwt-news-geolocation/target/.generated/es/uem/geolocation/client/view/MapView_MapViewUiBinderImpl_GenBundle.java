package es.uem.geolocation.client.view;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.CssResource.Import;

public interface MapView_MapViewUiBinderImpl_GenBundle extends ClientBundle {
  @Source("uibinder:es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style.css")
  MapView_MapViewUiBinderImpl_GenCss_style style();

  @Source("images/globe-vista-64x64.png")
  ImageResource image();
}
