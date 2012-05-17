package es.uem.geolocation.client.services;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class RSSService_Proxy extends RemoteServiceProxy implements es.uem.geolocation.client.services.RSSServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "es.uem.geolocation.client.services.RSSService";
  private static final String SERIALIZATION_POLICY ="5B3DCFBD694E42A6A6BA594DCBA5D097";
  private static final es.uem.geolocation.client.services.RSSService_TypeSerializer SERIALIZER = new es.uem.geolocation.client.services.RSSService_TypeSerializer();
  
  public RSSService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "rss", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void loadGeoRSSNews(com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RSSService_Proxy", "loadGeoRSSNews");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void loadRSSNews(java.lang.String uri, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RSSService_Proxy", "loadRSSNews");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(uri);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
