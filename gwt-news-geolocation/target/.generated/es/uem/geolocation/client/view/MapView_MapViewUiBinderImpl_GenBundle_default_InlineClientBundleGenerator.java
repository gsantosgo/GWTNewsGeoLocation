package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MapView_MapViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle {
  private static MapView_MapViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new MapView_MapViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void imageInitializer() {
    image = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "image",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
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
  private static final java.lang.String externalImage = "data:image/png;base64,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";
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
