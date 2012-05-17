package com.google.gwt.user.client.rpc.core.java.util.concurrent;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExecutionException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, java.util.concurrent.ExecutionException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.util.concurrent.ExecutionException instantiate(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.concurrent.ExecutionException::new()();
  }-*/;
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.concurrent.ExecutionException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.java.util.concurrent.ExecutionException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.util.concurrent.ExecutionException_FieldSerializer.deserialize(reader, (java.util.concurrent.ExecutionException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.util.concurrent.ExecutionException_FieldSerializer.serialize(writer, (java.util.concurrent.ExecutionException)object);
  }
  
}
