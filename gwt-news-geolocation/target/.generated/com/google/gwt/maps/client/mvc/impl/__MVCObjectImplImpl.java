package com.google.gwt.maps.client.mvc.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MVCObjectImplImpl implements com.google.gwt.maps.client.mvc.impl.MVCObjectImpl {
  public native void unbind(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key) /*-{
    jso.unbind(key);
  }-*/;
  public native void changed(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key) /*-{
    jso.changed(key);
  }-*/;
  public native void notify(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key) /*-{
    jso.notify(key);
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject get(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key) /*-{
    var jsReturn = jso.get(key);
    return jsReturn || null;
  }-*/;
  public native void bindTo(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key, com.google.gwt.core.client.JavaScriptObject target) /*-{
    jso.bindTo(key, target);
  }-*/;
  public native void unbindAll(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    jso.unbindAll();
  }-*/;
  public native com.google.gwt.core.client.JavaScriptObject construct() /*-{
    var jsReturn = new $wnd.google.maps.MVCObject();
    return jsReturn;
  }-*/;
  public native void setValues(com.google.gwt.core.client.JavaScriptObject jso, com.google.gwt.core.client.JavaScriptObject values) /*-{
    jso.setValues(values);
  }-*/;
  public native void set(com.google.gwt.core.client.JavaScriptObject jso, java.lang.String key, com.google.gwt.core.client.JavaScriptObject value) /*-{
    jso.set(key, value);
  }-*/;
}
