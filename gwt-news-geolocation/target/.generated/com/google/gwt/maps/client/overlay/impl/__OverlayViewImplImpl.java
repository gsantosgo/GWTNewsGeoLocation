package com.google.gwt.maps.client.overlay.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __OverlayViewImplImpl implements com.google.gwt.maps.client.overlay.impl.OverlayViewImpl {
  public void bind(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.maps.client.overlay.OverlayView obj) {
    assert JSONWrapperUtil.hasField(jso, "setMap") : "Backing JSO missing imported function setMap";
    assert JSONWrapperUtil.hasField(jso, "getProjection") : "Backing JSO missing imported function getProjection";
    assert JSONWrapperUtil.hasField(jso, "getMap") : "Backing JSO missing imported function getMap";
    assert JSONWrapperUtil.hasField(jso, "getPanes") : "Backing JSO missing imported function getPanes";
    bindNative (jso,obj);
  }
  public native void bindNative (com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.maps.client.overlay.OverlayView obj) /*-{
    if (jso.__gwtPeer) {
      @com.google.gwt.jsio.client.impl.JSONWrapperUtil::throwMultipleWrapperException()();
    }
    jso.__gwtPeer = obj;
    jso.draw = function() {
      return this.__gwtPeer.@com.google.gwt.maps.client.overlay.OverlayView::draw()(
      );
    };
    jso.onRemove = function() {
      return this.__gwtPeer.@com.google.gwt.maps.client.overlay.OverlayView::onRemove()(
      );
    };
    jso.onAdd = function() {
      return this.__gwtPeer.@com.google.gwt.maps.client.overlay.OverlayView::onAdd()(
      );
    };
  }-*/;
  public native void setMap(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject map) /*-{
    jso.setMap(map);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getProjection(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getProjection();
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getMap(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getMap();
    return jsReturn || null;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new $wnd.google.maps.OverlayView();
    return jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject getPanes(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.getPanes();
    return jsReturn || null;
  }-*/;
}
