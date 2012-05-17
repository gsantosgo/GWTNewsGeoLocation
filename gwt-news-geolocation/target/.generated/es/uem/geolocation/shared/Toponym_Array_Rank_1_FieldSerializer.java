package es.uem.geolocation.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Toponym_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, es.uem.geolocation.shared.Toponym[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static es.uem.geolocation.shared.Toponym[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new es.uem.geolocation.shared.Toponym[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, es.uem.geolocation.shared.Toponym[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return es.uem.geolocation.shared.Toponym_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    es.uem.geolocation.shared.Toponym_Array_Rank_1_FieldSerializer.deserialize(reader, (es.uem.geolocation.shared.Toponym[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    es.uem.geolocation.shared.Toponym_Array_Rank_1_FieldSerializer.serialize(writer, (es.uem.geolocation.shared.Toponym[])object);
  }
  
}
