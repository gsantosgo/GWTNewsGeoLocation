package com.google.gwt.maps.client.base.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __LatLngImplImpl implements com.google.gwt.maps.client.base.impl.LatLngImpl {
  public native double lng(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.lng();
    return jsReturn;
  }-*/;
  public native boolean equals(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject other) /*-{
    var jsReturn = jso.equals(other);
    return !!jsReturn;
  }-*/;
  public native java.lang.String toUrlValue(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toUrlValue();
    return jsReturn;
  }-*/;
  public native java.lang.String toString(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toString();
    return jsReturn;
  }-*/;
  public native java.lang.String toUrlValue(com.google.gwt.core.client.JavaScriptObject jso, int precision) /*-{
    var jsReturn = jso.toUrlValue(precision);
    return jsReturn;
  }-*/;
  public native double lat(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.lat();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(double lat, double lng, boolean noWrap) /*-{
    var jsReturn = new $wnd.google.maps.LatLng(lat, lng, noWrap);
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(double lat, double lng) /*-{
    var jsReturn = new $wnd.google.maps.LatLng(lat, lng);
    return jsReturn;
  }-*/;
}
