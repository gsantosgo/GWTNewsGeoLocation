package com.google.gwt.maps.client.overlay.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.*;
import com.google.gwt.jsio.client.impl.*;

public class __MarkerImageImplImpl implements com.google.gwt.maps.client.overlay.impl.MarkerImageImpl {
  public native com.google.gwt.core.client.JavaScriptObject construct(java.lang.String url, com.google.gwt.core.client.JavaScriptObject size, com.google.gwt.core.client.JavaScriptObject origin, com.google.gwt.core.client.JavaScriptObject anchor, com.google.gwt.core.client.JavaScriptObject scaledSize) /*-{
    var jsReturn = new $wnd.google.maps.MarkerImage(url, size, origin, anchor, scaledSize);
    return jsReturn;
  }-*/;
}
