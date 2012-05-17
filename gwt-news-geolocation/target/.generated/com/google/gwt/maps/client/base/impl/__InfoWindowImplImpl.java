package com.google.gwt.maps.client.base.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __InfoWindowImplImpl implements com.google.gwt.maps.client.base.impl.InfoWindowImpl {
  public native void setZIndex(com.google.gwt.core.client.JavaScriptObject jso, int zIndex) /*-{
    jso.setZIndex(zIndex);
  }-*/;
  public native void setOptions(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject options) /*-{
    jso.setOptions(options);
  }-*/;
  public native int getZIndex(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getZIndex();
    return jsReturn;
  }-*/;
  public native void close(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    jso.close();
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getPosition(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getPosition();
    return jsReturn || null;
  }-*/;
  public native void setPosition(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject position) /*-{
    jso.setPosition(position);
  }-*/;
  public native void setContent(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String html) /*-{
    jso.setContent(html);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new $wnd.google.maps.InfoWindow();
    return jsReturn;
  }-*/;
  public native void open(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject map, com.google.gwt.core.client.JavaScriptObject anchor) /*-{
    jso.open(map, anchor);
  }-*/;
  public native java.lang.String getContent(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getContent();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(com.google.gwt.core.client.JavaScriptObject options) /*-{
    var jsReturn = new $wnd.google.maps.InfoWindow(options);
    return jsReturn;
  }-*/;
}
