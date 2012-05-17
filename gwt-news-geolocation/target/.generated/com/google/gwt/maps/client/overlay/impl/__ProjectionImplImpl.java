package com.google.gwt.maps.client.overlay.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __ProjectionImplImpl implements com.google.gwt.maps.client.overlay.impl.ProjectionImpl {
  public native com.google.gwt.core.client.JavaScriptObject fromPointToLatLng(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject point) /*-{
    var jsReturn = jso.fromPointToLatLng(point);
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject fromLatLngToPoint(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject latLng) /*-{
    var jsReturn = jso.fromLatLngToPoint(latLng);
    return jsReturn || null;
  }-*/;
}
