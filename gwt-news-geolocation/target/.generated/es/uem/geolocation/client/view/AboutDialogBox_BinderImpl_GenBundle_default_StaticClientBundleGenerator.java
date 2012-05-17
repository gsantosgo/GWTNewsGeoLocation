package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AboutDialogBox_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle {
  private static AboutDialogBox_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new AboutDialogBox_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void imageInitializer() {
    image = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "image",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 350, 72, false, false
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
    style = new es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenCss_style() {
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
        return (".GNV5U30EI{background-color:" + ("ivory")  + ";}");
      }
      public java.lang.String panel(){
        return "GNV5U30EI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "17A67948925B98B2FC2C57BAB6F06D0F.cache.png";
  private static com.google.gwt.resources.client.ImageResource image;
  private static es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenCss_style style;
  
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
      case 'image': return this.@es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle::image()();
      case 'style': return this.@es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
