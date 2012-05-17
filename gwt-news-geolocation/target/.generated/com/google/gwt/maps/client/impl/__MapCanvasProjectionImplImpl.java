package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MapCanvasProjectionImplImpl implements com.google.gwt.maps.client.impl.MapCanvasProjectionImpl {
  public native int getWorldWidth(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getWorldWidth();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject fromLatLngToContainerPixel(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject latLng) /*-{
    var jsReturn = jso.fromLatLngToContainerPixel(latLng);
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject fromDivPixelToLatLng(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject pixel) /*-{
    var jsReturn = jso.fromDivPixelToLatLng(pixel);
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject fromLatLngToDivPixel(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject latLng) /*-{
    var jsReturn = jso.fromLatLngToDivPixel(latLng);
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject fromContainerPixelToLatLng(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject pixel) /*-{
    var jsReturn = jso.fromContainerPixelToLatLng(pixel);
    return jsReturn || null;
  }-*/;
}
