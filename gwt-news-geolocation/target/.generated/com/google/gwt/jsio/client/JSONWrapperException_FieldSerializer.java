package com.google.gwt.jsio.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JSONWrapperException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.jsio.client.JSONWrapperException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.jsio.client.JSONWrapperException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.jsio.client.JSONWrapperException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.jsio.client.JSONWrapperException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.jsio.client.JSONWrapperException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.jsio.client.JSONWrapperException_FieldSerializer.deserialize(reader, (com.google.gwt.jsio.client.JSONWrapperException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.jsio.client.JSONWrapperException_FieldSerializer.serialize(writer, (com.google.gwt.jsio.client.JSONWrapperException)object);
  }
  
}
