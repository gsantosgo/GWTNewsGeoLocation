package com.google.gwt.maps.client.event.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MouseEventImplImpl implements com.google.gwt.maps.client.event.impl.MouseEventImpl {
  public native com.google.gwt.core.client.JavaScriptObject getLatLng(com.google.gwt.core.client.JavaScriptObject jso) /*-{
    return jso.latLng || null;
  }-*/;
}
