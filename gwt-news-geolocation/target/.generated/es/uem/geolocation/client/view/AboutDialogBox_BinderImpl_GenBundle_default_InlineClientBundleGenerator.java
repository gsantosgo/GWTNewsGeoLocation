package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AboutDialogBox_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle {
  private static AboutDialogBox_BinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new AboutDialogBox_BinderImpl_GenBundle_default_InlineClientBundleGenerator();
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
  private static final java.lang.String externalImage = "data:image/png;base64,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";
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
