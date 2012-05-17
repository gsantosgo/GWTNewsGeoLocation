package com.google.gwt.maps.client.base.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __PointImplImpl implements com.google.gwt.maps.client.base.impl.PointImpl {
  public native boolean equals(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject other) /*-{
    var jsReturn = jso.equals(other);
    return !!jsReturn;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct(double x, double y) /*-{
    var jsReturn = new $wnd.google.maps.Point(x, y);
    if (!jsReturn.hasOwnProperty('y')) {
      jsReturn.y = 0;
    }
    if (!jsReturn.hasOwnProperty('x')) {
      jsReturn.x = 0;
    }
    return jsReturn;
  }-*/;
  public native java.lang.String toString(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    var jsReturn = jso.toString();
    return jsReturn;
  }-*/;
  public native double getY(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.y;
  }-*/;
  public native double getX(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.x;
  }-*/;
}
