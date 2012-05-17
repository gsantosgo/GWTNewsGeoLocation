package com.google.gwt.maps.client.base.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __LatLngBoundsImplImpl implements com.google.gwt.maps.client.base.impl.LatLngBoundsImpl {
  public native com.google.gwt.core.client.JavaScriptObject toSpan(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toSpan();
    return jsReturn || null;
  }-*/;
  public native boolean equals(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject other) /*-{
    var jsReturn = jso.equals(other);
    return !!jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject union(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject other) /*-{
    var jsReturn = jso.union(other);
    return jsReturn || null;
  }-*/;
  public native java.lang.String toUrlValue(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toUrlValue();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getSouthWest(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getSouthWest();
    return jsReturn || null;
  }-*/;
  public native java.lang.String toUrlValue(com.google.gwt.core.client.JavaScriptObject jso, int precision) /*-{
    var jsReturn = jso.toUrlValue(precision);
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new $wnd.google.maps.LatLngBounds();
    return jsReturn;
  }-*/;
  public native boolean intersects(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject other) /*-{
    var jsReturn = jso.intersects(other);
    return !!jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject extend(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject point) /*-{
    var jsReturn = jso.extend(point);
    return jsReturn || null;
  }-*/;
  public native boolean isEmpty(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.isEmpty();
    return !!jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getNorthEast(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getNorthEast();
    return jsReturn || null;
  }-*/;
  public native boolean contains(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject point) /*-{
    var jsReturn = jso.contains(point);
    return !!jsReturn;
  }-*/;
  public native java.lang.String toString(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toString();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getCenter(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getCenter();
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(com.google.gwt.core.client.JavaScriptObject sw, com.google.gwt.core.client.JavaScriptObject ne) /*-{
    var jsReturn = new $wnd.google.maps.LatLngBounds(sw, ne);
    return jsReturn;
  }-*/;
}
