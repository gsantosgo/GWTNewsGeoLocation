package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MapOptionsImplImpl implements com.google.gwt.maps.client.impl.MapOptionsImpl {
  public native boolean isNoClear(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.noClear;
  }-*/;
  public native void setNoClear(com.google.gwt.core.client.JavaScriptObject jso, boolean noClear) /*-{
    jso.noClear = noClear;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getScaleControlOptions(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.scaleControlOptions || null;
  }-*/;
  public native void setScaleControlOptions(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject scaleControlOptions) /*-{
    jso.scaleControlOptions = scaleControlOptions;
  }-*/;
  public native boolean isMapTypeControl(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.mapTypeControl;
  }-*/;
  public native void setMapTypeControl(com.google.gwt.core.client.JavaScriptObject jso, boolean mapTypeControl) /*-{
    jso.mapTypeControl = mapTypeControl;
  }-*/;
  public native int getZoom(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.zoom;
  }-*/;
  public native void setZoom(com.google.gwt.core.client.JavaScriptObject jso, int zoom) /*-{
    jso.zoom = zoom;
  }-*/;
  public native java.lang.String getDraggableCursor(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.draggableCursor;
  }-*/;
  public native void setDraggableCursor(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String draggableCursor) /*-{
    jso.draggableCursor = draggableCursor;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getNavigationControlOptions(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.navigationControlOptions || null;
  }-*/;
  public native void setNavigationControlOptions(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject navigationControlOptions) /*-{
    jso.navigationControlOptions = navigationControlOptions;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new Object();
    if (!jsReturn.hasOwnProperty('noClear')) {
      jsReturn.noClear = false;
    }
    if (!jsReturn.hasOwnProperty('scaleControlOptions')) {
      jsReturn.scaleControlOptions = null;
    }
    if (!jsReturn.hasOwnProperty('mapTypeControl')) {
      jsReturn.mapTypeControl = false;
    }
    if (!jsReturn.hasOwnProperty('zoom')) {
      jsReturn.zoom = 0;
    }
    if (!jsReturn.hasOwnProperty('draggableCursor')) {
      jsReturn.draggableCursor = null;
    }
    if (!jsReturn.hasOwnProperty('navigationControlOptions')) {
      jsReturn.navigationControlOptions = null;
    }
    if (!jsReturn.hasOwnProperty('disableDoubleClickZoom')) {
      jsReturn.disableDoubleClickZoom = false;
    }
    if (!jsReturn.hasOwnProperty('backgroundColor')) {
      jsReturn.backgroundColor = null;
    }
    if (!jsReturn.hasOwnProperty('navigationControl')) {
      jsReturn.navigationControl = false;
    }
    if (!jsReturn.hasOwnProperty('disableDefaultUI')) {
      jsReturn.disableDefaultUI = false;
    }
    if (!jsReturn.hasOwnProperty('keyboardShortcuts')) {
      jsReturn.keyboardShortcuts = false;
    }
    if (!jsReturn.hasOwnProperty('draggingCursor')) {
      jsReturn.draggingCursor = null;
    }
    if (!jsReturn.hasOwnProperty('scrollwheel')) {
      jsReturn.scrollwheel = false;
    }
    if (!jsReturn.hasOwnProperty('draggable')) {
      jsReturn.draggable = false;
    }
    if (!jsReturn.hasOwnProperty('scaleControl')) {
      jsReturn.scaleControl = false;
    }
    if (!jsReturn.hasOwnProperty('center')) {
      jsReturn.center = null;
    }
    if (!jsReturn.hasOwnProperty('mapTypeId')) {
      jsReturn.mapTypeId = null;
    }
    if (!jsReturn.hasOwnProperty('mapTypeControlOptions')) {
      jsReturn.mapTypeControlOptions = null;
    }
    return jsReturn;
  }-*/;
  public native boolean isDisableDoubleClickZoom(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.disableDoubleClickZoom;
  }-*/;
  public native void setDisableDoubleClickZoom(com.google.gwt.core.client.JavaScriptObject jso, boolean disableDoubleClickZoom) /*-{
    jso.disableDoubleClickZoom = disableDoubleClickZoom;
  }-*/;
  public native java.lang.String getBackgroundColor(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.backgroundColor;
  }-*/;
  public native void setBackgroundColor(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String backgroundColor) /*-{
    jso.backgroundColor = backgroundColor;
  }-*/;
  public native boolean isNavigationControl(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.navigationControl;
  }-*/;
  public native void setNavigationControl(com.google.gwt.core.client.JavaScriptObject jso, boolean navigationControl) /*-{
    jso.navigationControl = navigationControl;
  }-*/;
  public native boolean isDisableDefaultUI(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.disableDefaultUI;
  }-*/;
  public native void setDisableDefaultUI(com.google.gwt.core.client.JavaScriptObject jso, boolean disableDefaultUI) /*-{
    jso.disableDefaultUI = disableDefaultUI;
  }-*/;
  public native boolean isKeyboardShortcuts(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.keyboardShortcuts;
  }-*/;
  public native void setKeyboardShortcuts(com.google.gwt.core.client.JavaScriptObject jso, boolean keyboardShortcuts) /*-{
    jso.keyboardShortcuts = keyboardShortcuts;
  }-*/;
  public native java.lang.String getDraggingCursor(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.draggingCursor;
  }-*/;
  public native void setDraggingCursor(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String draggingCursor) /*-{
    jso.draggingCursor = draggingCursor;
  }-*/;
  public native boolean isScrollwheel(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.scrollwheel;
  }-*/;
  public native void setScrollwheel(com.google.gwt.core.client.JavaScriptObject jso, boolean scrollwheel) /*-{
    jso.scrollwheel = scrollwheel;
  }-*/;
  public native boolean isDraggable(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.draggable;
  }-*/;
  public native void setDraggable(com.google.gwt.core.client.JavaScriptObject jso, boolean draggable) /*-{
    jso.draggable = draggable;
  }-*/;
  public native boolean isScaleControl(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return !!jso.scaleControl;
  }-*/;
  public native void setScaleControl(com.google.gwt.core.client.JavaScriptObject jso, boolean scaleControl) /*-{
    jso.scaleControl = scaleControl;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getCenter(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.center || null;
  }-*/;
  public native void setCenter(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject center) /*-{
    jso.center = center;
  }-*/;
  public native java.lang.String getMapTypeId(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.mapTypeId;
  }-*/;
  public native void setMapTypeId(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String mapTypeId) /*-{
    jso.mapTypeId = mapTypeId;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getMapTypeControlOptions(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.mapTypeControlOptions || null;
  }-*/;
  public native void setMapTypeControlOptions(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject mapTypeControlOptions) /*-{
    jso.mapTypeControlOptions = mapTypeControlOptions;
  }-*/;
}
