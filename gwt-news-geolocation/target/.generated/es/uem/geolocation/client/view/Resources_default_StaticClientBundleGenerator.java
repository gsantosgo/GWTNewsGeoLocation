package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_StaticClientBundleGenerator implements es.uem.geolocation.client.view.Resources {
  private static Resources_default_StaticClientBundleGenerator _instance0 = new Resources_default_StaticClientBundleGenerator();
  private void logoInitializer() {
    logo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "logo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 64, 64, false, false
    );
  }
  private static class logoInitializer {
    static {
      _instance0.logoInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return logo;
    }
  }
  public com.google.gwt.resources.client.ImageResource logo() {
    return logoInitializer.get();
  }
  private void newsInitializer() {
    news = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "news",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      64, 0, 22, 20, false, false
    );
  }
  private static class newsInitializer {
    static {
      _instance0.newsInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return news;
    }
  }
  public com.google.gwt.resources.client.ImageResource news() {
    return newsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "B540EC9E09C48CF4ABA41BA051C15A4B.cache.png";
  private static com.google.gwt.resources.client.ImageResource logo;
  private static com.google.gwt.resources.client.ImageResource news;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      logo(), 
      news(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("logo", logo());
        resourceMap.put("news", news());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'logo': return this.@es.uem.geolocation.client.view.Resources::logo()();
      case 'news': return this.@es.uem.geolocation.client.view.Resources::news()();
    }
    return null;
  }-*/;
}
