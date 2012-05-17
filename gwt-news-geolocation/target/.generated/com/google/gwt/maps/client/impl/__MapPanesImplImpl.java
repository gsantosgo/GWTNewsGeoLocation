package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MapPanesImplImpl implements com.google.gwt.maps.client.impl.MapPanesImpl {
  public native com.google.gwt.user.client.Element getOverlayLayer(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.overlayLayer || null;
  }-*/;
  public native com.google.gwt.user.client.Element getMapPane(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.mapPane || null;
  }-*/;
  public native com.google.gwt.user.client.Element getFloatShadow(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.floatShadow || null;
  }-*/;
  public native com.google.gwt.user.client.Element getFloatPane(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.floatPane || null;
  }-*/;
  public native com.google.gwt.user.client.Element getOverlayShadow(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.overlayShadow || null;
  }-*/;
  public native com.google.gwt.user.client.Element getOverlayImage(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.overlayImage || null;
  }-*/;
  public native com.google.gwt.user.client.Element getOverlayMouseTarget(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.overlayMouseTarget || null;
  }-*/;
}
