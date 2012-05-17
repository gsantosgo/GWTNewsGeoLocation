package es.uem.geolocation.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NewMap_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getArticles(es.uem.geolocation.shared.NewMap instance) /*-{
    return instance.@es.uem.geolocation.shared.NewMap::articles;
  }-*/;
  
  private static native void setArticles(es.uem.geolocation.shared.NewMap instance, java.util.List value) 
  /*-{
    instance.@es.uem.geolocation.shared.NewMap::articles = value;
  }-*/;
  
  private static native java.lang.Double getLatitude(es.uem.geolocation.shared.NewMap instance) /*-{
    return instance.@es.uem.geolocation.shared.NewMap::latitude;
  }-*/;
  
  private static native void setLatitude(es.uem.geolocation.shared.NewMap instance, java.lang.Double value) 
  /*-{
    instance.@es.uem.geolocation.shared.NewMap::latitude = value;
  }-*/;
  
  private static native java.lang.Double getLongitude(es.uem.geolocation.shared.NewMap instance) /*-{
    return instance.@es.uem.geolocation.shared.NewMap::longitude;
  }-*/;
  
  private static native void setLongitude(es.uem.geolocation.shared.NewMap instance, java.lang.Double value) 
  /*-{
    instance.@es.uem.geolocation.shared.NewMap::longitude = value;
  }-*/;
  
  private static native java.lang.String getPlacename(es.uem.geolocation.shared.NewMap instance) /*-{
    return instance.@es.uem.geolocation.shared.NewMap::placename;
  }-*/;
  
  private static native void setPlacename(es.uem.geolocation.shared.NewMap instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.NewMap::placename = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, es.uem.geolocation.shared.NewMap instance) throws SerializationException {
    setArticles(instance, (java.util.List) streamReader.readObject());
    setLatitude(instance, (java.lang.Double) streamReader.readObject());
    setLongitude(instance, (java.lang.Double) streamReader.readObject());
    setPlacename(instance, streamReader.readString());
    
  }
  
  public static es.uem.geolocation.shared.NewMap instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new es.uem.geolocation.shared.NewMap();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, es.uem.geolocation.shared.NewMap instance) throws SerializationException {
    streamWriter.writeObject(getArticles(instance));
    streamWriter.writeObject(getLatitude(instance));
    streamWriter.writeObject(getLongitude(instance));
    streamWriter.writeString(getPlacename(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return es.uem.geolocation.shared.NewMap_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    es.uem.geolocation.shared.NewMap_FieldSerializer.deserialize(reader, (es.uem.geolocation.shared.NewMap)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    es.uem.geolocation.shared.NewMap_FieldSerializer.serialize(writer, (es.uem.geolocation.shared.NewMap)object);
  }
  
}
