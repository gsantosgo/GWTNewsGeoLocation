package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MapView_MapViewUiBinderImpl_GenBundle_default_StaticClientBundleGenerator implements es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle {
  private static MapView_MapViewUiBinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new MapView_MapViewUiBinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void imageInitializer() {
    image = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "image",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 64, 64, false, false
    );
  }
  private static class imageInitializer {
    static {
      _instance0.imageInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return image;
    }
  }
  public com.google.gwt.resources.client.ImageResource image() {
    return imageInitializer.get();
  }
  private void styleInitializer() {
    style = new es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GNV5U30HI{height:" + ("100%")  + ";width:" + ("100%")  + ";}.GNV5U30II{background-color:" + ("#6694e3")  + ";font-size:" + ("1.5em")  + ";padding:" + ("0.1em")  + ";}.GNV5U30GI{border-right:" + ("2px"+ " " +"solid"+ " " +"#6694e3")  + ";background-color:" + ("#6694e3")  + ";display:" + ("inline-block")  + ";}.GNV5U30LI{background:" + ("#e3e9ff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";margin:") + (("0.1em")  + ";padding:" + ("0.5em")  + ";}.GNV5U30KI{display:" + ("inline-block")  + ";padding:" + ("0.1em")  + ";vertical-align:" + ("top")  + ";}.GNV5U30MI{vertical-align:" + ("top")  + ";}")) : ((".GNV5U30HI{height:" + ("100%")  + ";width:" + ("100%")  + ";}.GNV5U30II{background-color:" + ("#6694e3")  + ";font-size:" + ("1.5em")  + ";padding:" + ("0.1em")  + ";}.GNV5U30GI{border-left:" + ("2px"+ " " +"solid"+ " " +"#6694e3")  + ";background-color:" + ("#6694e3")  + ";display:" + ("inline-block")  + ";}.GNV5U30LI{background:" + ("#e3e9ff")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";margin:") + (("0.1em")  + ";padding:" + ("0.5em")  + ";}.GNV5U30KI{display:" + ("inline-block")  + ";padding:" + ("0.1em")  + ";vertical-align:" + ("top")  + ";}.GNV5U30MI{vertical-align:" + ("top")  + ";}"));
      }
      public java.lang.String contentNews(){
        return "GNV5U30GI";
      }
      public java.lang.String fullscreen(){
        return "GNV5U30HI";
      }
      public java.lang.String header(){
        return "GNV5U30II";
      }
      public java.lang.String headerimage(){
        return "GNV5U30JI";
      }
      public java.lang.String label(){
        return "GNV5U30KI";
      }
      public java.lang.String sourceblock(){
        return "GNV5U30LI";
      }
      public java.lang.String sourcelink(){
        return "GNV5U30MI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "83F8E0471447279C356236FEB08938BC.cache.png";
  private static com.google.gwt.resources.client.ImageResource image;
  private static es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      image(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("image", image());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'image': return this.@es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle::image()();
      case 'style': return this.@es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
