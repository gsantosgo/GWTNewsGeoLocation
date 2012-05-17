package es.uem.geolocation.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RSS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCopyright(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::copyright;
  }-*/;
  
  private static native void setCopyright(es.uem.geolocation.shared.RSS instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::copyright = value;
  }-*/;
  
  private static native java.lang.String getDescription(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::description;
  }-*/;
  
  private static native void setDescription(es.uem.geolocation.shared.RSS instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::description = value;
  }-*/;
  
  private static native java.util.List getItems(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::items;
  }-*/;
  
  private static native void setItems(es.uem.geolocation.shared.RSS instance, java.util.List value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::items = value;
  }-*/;
  
  private static native java.lang.String getLink(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::link;
  }-*/;
  
  private static native void setLink(es.uem.geolocation.shared.RSS instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::link = value;
  }-*/;
  
  private static native java.util.Date getPublishedDate(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::publishedDate;
  }-*/;
  
  private static native void setPublishedDate(es.uem.geolocation.shared.RSS instance, java.util.Date value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::publishedDate = value;
  }-*/;
  
  private static native java.lang.String getTitle(es.uem.geolocation.shared.RSS instance) /*-{
    return instance.@es.uem.geolocation.shared.RSS::title;
  }-*/;
  
  private static native void setTitle(es.uem.geolocation.shared.RSS instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.RSS::title = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, es.uem.geolocation.shared.RSS instance) throws SerializationException {
    setCopyright(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setItems(instance, (java.util.List) streamReader.readObject());
    setLink(instance, streamReader.readString());
    setPublishedDate(instance, (java.util.Date) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    
  }
  
  public static es.uem.geolocation.shared.RSS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new es.uem.geolocation.shared.RSS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, es.uem.geolocation.shared.RSS instance) throws SerializationException {
    streamWriter.writeString(getCopyright(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getItems(instance));
    streamWriter.writeString(getLink(instance));
    streamWriter.writeObject(getPublishedDate(instance));
    streamWriter.writeString(getTitle(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return es.uem.geolocation.shared.RSS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    es.uem.geolocation.shared.RSS_FieldSerializer.deserialize(reader, (es.uem.geolocation.shared.RSS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    es.uem.geolocation.shared.RSS_FieldSerializer.serialize(writer, (es.uem.geolocation.shared.RSS)object);
  }
  
}
