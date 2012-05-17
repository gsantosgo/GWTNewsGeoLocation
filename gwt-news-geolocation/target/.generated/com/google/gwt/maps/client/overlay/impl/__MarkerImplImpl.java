package com.google.gwt.maps.client.overlay.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MarkerImplImpl implements com.google.gwt.maps.client.overlay.impl.MarkerImpl {
  public native int getZIndex(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getZIndex();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getPosition(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getPosition();
    return jsReturn || null;
  }-*/;
  public native void setMap(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject map) /*-{
    jso.setMap(map);
  }-*/;
  public native boolean isDraggable(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.isDraggable();
    return !!jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new $wnd.google.maps.Marker();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getMap(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getMap();
    return jsReturn || null;
  }-*/;
  public native void setCursor(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String cursor) /*-{
    jso.setCursor(cursor);
  }-*/;
  public native boolean isFlat(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.isFlat();
    return !!jsReturn;
  }-*/;
  public native void setTitle(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String title) /*-{
    jso.setTitle(title);
  }-*/;
  public native void setZIndex(com.google.gwt.core.client.JavaScriptObject jso, int zIndex) /*-{
    jso.setZIndex(zIndex);
  }-*/;
  public native boolean isClickable(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.isClickable();
    return !!jsReturn;
  }-*/;
  public native void setVisible(com.google.gwt.core.client.JavaScriptObject jso, boolean visible) /*-{
    jso.setVisible(visible);
  }-*/;
  public native void setClickable(com.google.gwt.core.client.JavaScriptObject jso, boolean clickable) /*-{
    jso.setClickable(clickable);
  }-*/;
  public native void setFlat(com.google.gwt.core.client.JavaScriptObject jso, boolean flat) /*-{
    jso.setFlat(flat);
  }-*/;
  public native java.lang.String getTitle(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getTitle();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getIcon(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getIcon();
    return jsReturn || null;
  }-*/;
  public native void setPosition(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject position) /*-{
    jso.setPosition(position);
  }-*/;
  public native void setDraggable(com.google.gwt.core.client.JavaScriptObject jso, boolean draggable) /*-{
    jso.setDraggable(draggable);
  }-*/;
  public native void setIcon(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject image) /*-{
    jso.setIcon(image);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(com.google.gwt.core.client.JavaScriptObject options) /*-{
    var jsReturn = new $wnd.google.maps.Marker(options);
    return jsReturn;
  }-*/;
  public native java.lang.String getCursor(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getCursor();
    return jsReturn;
  }-*/;
  public native boolean isVisible(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.isVisible();
    return !!jsReturn;
  }-*/;
}
