package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __ScaleControlOptionsImplImpl implements com.google.gwt.maps.client.impl.ScaleControlOptionsImpl {
  public native void setStyle(com.google.gwt.core.client.JavaScriptObject jso, int style) /*-{
    jso.style = style;
  }-*/;
  public native void setPosition(com.google.gwt.core.client.JavaScriptObject jso, int position) /*-{
    jso.position = position;
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new Object();
    return jsReturn;
  }-*/;
}
