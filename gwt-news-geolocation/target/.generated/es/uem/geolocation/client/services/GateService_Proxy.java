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

public class GateService_Proxy extends RemoteServiceProxy implements es.uem.geolocation.client.services.GateServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "es.uem.geolocation.client.services.GateService";
  private static final String SERIALIZATION_POLICY ="76AE47941B73C884DEAFAEFF627F58C1";
  private static final es.uem.geolocation.client.services.GateService_TypeSerializer SERIALIZER = new es.uem.geolocation.client.services.GateService_TypeSerializer();
  
  public GateService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "gate", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getNamedEntities(java.lang.String texto, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GateService_Proxy", "getNamedEntities");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(texto);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void getNamedEntities(java.util.List articles, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GateService_Proxy", "getNamedEntities");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(articles);
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
