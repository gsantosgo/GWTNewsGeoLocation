package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MapImplImpl implements com.google.gwt.maps.client.impl.MapImpl {
  public native void setOptions(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject options) /*-{
    jso.setOptions(options);
  }-*/;
  public native java.lang.String getMapTypeId(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getMapTypeId();
    return jsReturn;
  }-*/;
  public native int getZoom(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getZoom();
    return jsReturn;
  }-*/;
  public native void setCenter(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject latLng) /*-{
    jso.setCenter(latLng);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getProjection(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getProjection();
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(com.google.gwt.user.client.Element mapDiv, com.google.gwt.core.client.JavaScriptObject mapOptions) /*-{
    var jsReturn = new $wnd.google.maps.Map(mapDiv, mapOptions);
    return jsReturn;
  }-*/;
  public native void panToBounds(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject bounds) /*-{
    jso.panToBounds(bounds);
  }-*/;
  public native com.google.gwt.user.client.Element getDiv(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getDiv();
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(com.google.gwt.user.client.Element mapDiv) /*-{
    var jsReturn = new $wnd.google.maps.Map(mapDiv);
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getBounds(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getBounds();
    return jsReturn || null;
  }-*/;
  public native void setZoom(com.google.gwt.core.client.JavaScriptObject jso, int zoom) /*-{
    jso.setZoom(zoom);
  }-*/;
  public native void fitBounds(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject bounds) /*-{
    jso.fitBounds(bounds);
  }-*/;
  public native void panTo(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject latLng) /*-{
    jso.panTo(latLng);
  }-*/;
  public native void setMapTypeId(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String mapTypeId) /*-{
    jso.setMapTypeId(mapTypeId);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getCenter(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getCenter();
    return jsReturn || null;
  }-*/;
  public native void panBy(com.google.gwt.core.client.JavaScriptObject jso, int x, int y) /*-{
    jso.panBy(x, y);
  }-*/;
}
