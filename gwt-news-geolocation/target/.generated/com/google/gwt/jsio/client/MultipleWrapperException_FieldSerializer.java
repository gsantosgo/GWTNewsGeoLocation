package com.google.gwt.jsio.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MultipleWrapperException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.jsio.client.MultipleWrapperException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.jsio.client.MultipleWrapperException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.jsio.client.MultipleWrapperException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.jsio.client.MultipleWrapperException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.jsio.client.MultipleWrapperException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.jsio.client.MultipleWrapperException_FieldSerializer.deserialize(reader, (com.google.gwt.jsio.client.MultipleWrapperException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.jsio.client.MultipleWrapperException_FieldSerializer.serialize(writer, (com.google.gwt.jsio.client.MultipleWrapperException)object);
  }
  
}
