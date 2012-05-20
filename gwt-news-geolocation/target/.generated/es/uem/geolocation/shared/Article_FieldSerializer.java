package es.uem.geolocation.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Article_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getArticleID(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::articleID;
  }-*/;
  
  private static native void setArticleID(es.uem.geolocation.shared.Article instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::articleID = value;
  }-*/;
  
  private static native java.util.List getCategories(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::categories;
  }-*/;
  
  private static native void setCategories(es.uem.geolocation.shared.Article instance, java.util.List value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::categories = value;
  }-*/;
  
  private static native java.util.List getCategoriesLocations(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::categoriesLocations;
  }-*/;
  
  private static native void setCategoriesLocations(es.uem.geolocation.shared.Article instance, java.util.List value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::categoriesLocations = value;
  }-*/;
  
  private static native java.lang.String getDescription(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::description;
  }-*/;
  
  private static native void setDescription(es.uem.geolocation.shared.Article instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::description = value;
  }-*/;
  
  private static native java.lang.String getHeadline(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::headline;
  }-*/;
  
  private static native void setHeadline(es.uem.geolocation.shared.Article instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::headline = value;
  }-*/;
  
  private static native java.util.List getHeadlineDescriptionLocations(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::headlineDescriptionLocations;
  }-*/;
  
  private static native void setHeadlineDescriptionLocations(es.uem.geolocation.shared.Article instance, java.util.List value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::headlineDescriptionLocations = value;
  }-*/;
  
  private static native java.util.Date getPublishedDate(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::publishedDate;
  }-*/;
  
  private static native void setPublishedDate(es.uem.geolocation.shared.Article instance, java.util.Date value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::publishedDate = value;
  }-*/;
  
  private static native java.lang.String getUri(es.uem.geolocation.shared.Article instance) /*-{
    return instance.@es.uem.geolocation.shared.Article::uri;
  }-*/;
  
  private static native void setUri(es.uem.geolocation.shared.Article instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Article::uri = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, es.uem.geolocation.shared.Article instance) throws SerializationException {
    setArticleID(instance, streamReader.readString());
    setCategories(instance, (java.util.List) streamReader.readObject());
    setCategoriesLocations(instance, (java.util.List) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setHeadline(instance, streamReader.readString());
    setHeadlineDescriptionLocations(instance, (java.util.List) streamReader.readObject());
    setPublishedDate(instance, (java.util.Date) streamReader.readObject());
    setUri(instance, streamReader.readString());
    
  }
  
  public static es.uem.geolocation.shared.Article instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new es.uem.geolocation.shared.Article();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, es.uem.geolocation.shared.Article instance) throws SerializationException {
    streamWriter.writeString(getArticleID(instance));
    streamWriter.writeObject(getCategories(instance));
    streamWriter.writeObject(getCategoriesLocations(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getHeadline(instance));
    streamWriter.writeObject(getHeadlineDescriptionLocations(instance));
    streamWriter.writeObject(getPublishedDate(instance));
    streamWriter.writeString(getUri(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return es.uem.geolocation.shared.Article_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    es.uem.geolocation.shared.Article_FieldSerializer.deserialize(reader, (es.uem.geolocation.shared.Article)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    es.uem.geolocation.shared.Article_FieldSerializer.serialize(writer, (es.uem.geolocation.shared.Article)object);
  }
  
}
