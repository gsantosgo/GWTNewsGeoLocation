package es.uem.geolocation.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Toponym_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getAlternateNames(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::alternateNames;
  }-*/;
  
  private static native void setAlternateNames(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::alternateNames = value;
  }-*/;
  
  private static native java.lang.String getContinentCode(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::continentCode;
  }-*/;
  
  private static native void setContinentCode(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::continentCode = value;
  }-*/;
  
  private static native java.lang.String getCountryCode(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::countryCode;
  }-*/;
  
  private static native void setCountryCode(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::countryCode = value;
  }-*/;
  
  private static native java.lang.String getCountryName(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::countryName;
  }-*/;
  
  private static native void setCountryName(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::countryName = value;
  }-*/;
  
  private static native java.lang.Integer getElevation(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::elevation;
  }-*/;
  
  private static native void setElevation(es.uem.geolocation.shared.Toponym instance, java.lang.Integer value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::elevation = value;
  }-*/;
  
  private static native java.lang.String getFeatureClassName(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::featureClassName;
  }-*/;
  
  private static native void setFeatureClassName(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::featureClassName = value;
  }-*/;
  
  private static native java.lang.String getFeatureCode(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::featureCode;
  }-*/;
  
  private static native void setFeatureCode(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::featureCode = value;
  }-*/;
  
  private static native java.lang.String getFeatureCodeName(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::featureCodeName;
  }-*/;
  
  private static native void setFeatureCodeName(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::featureCodeName = value;
  }-*/;
  
  private static native int getGeoNameId(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::geoNameId;
  }-*/;
  
  private static native void setGeoNameId(es.uem.geolocation.shared.Toponym instance, int value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::geoNameId = value;
  }-*/;
  
  private static native double getLatitude(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::latitude;
  }-*/;
  
  private static native void setLatitude(es.uem.geolocation.shared.Toponym instance, double value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::latitude = value;
  }-*/;
  
  private static native double getLongitude(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::longitude;
  }-*/;
  
  private static native void setLongitude(es.uem.geolocation.shared.Toponym instance, double value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::longitude = value;
  }-*/;
  
  private static native java.lang.String getName(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::name;
  }-*/;
  
  private static native void setName(es.uem.geolocation.shared.Toponym instance, java.lang.String value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::name = value;
  }-*/;
  
  private static native java.lang.Long getPopulation(es.uem.geolocation.shared.Toponym instance) /*-{
    return instance.@es.uem.geolocation.shared.Toponym::population;
  }-*/;
  
  private static native void setPopulation(es.uem.geolocation.shared.Toponym instance, java.lang.Long value) 
  /*-{
    instance.@es.uem.geolocation.shared.Toponym::population = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, es.uem.geolocation.shared.Toponym instance) throws SerializationException {
    setAlternateNames(instance, streamReader.readString());
    setContinentCode(instance, streamReader.readString());
    setCountryCode(instance, streamReader.readString());
    setCountryName(instance, streamReader.readString());
    setElevation(instance, (java.lang.Integer) streamReader.readObject());
    setFeatureClassName(instance, streamReader.readString());
    setFeatureCode(instance, streamReader.readString());
    setFeatureCodeName(instance, streamReader.readString());
    setGeoNameId(instance, streamReader.readInt());
    setLatitude(instance, streamReader.readDouble());
    setLongitude(instance, streamReader.readDouble());
    setName(instance, streamReader.readString());
    setPopulation(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static es.uem.geolocation.shared.Toponym instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new es.uem.geolocation.shared.Toponym();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, es.uem.geolocation.shared.Toponym instance) throws SerializationException {
    streamWriter.writeString(getAlternateNames(instance));
    streamWriter.writeString(getContinentCode(instance));
    streamWriter.writeString(getCountryCode(instance));
    streamWriter.writeString(getCountryName(instance));
    streamWriter.writeObject(getElevation(instance));
    streamWriter.writeString(getFeatureClassName(instance));
    streamWriter.writeString(getFeatureCode(instance));
    streamWriter.writeString(getFeatureCodeName(instance));
    streamWriter.writeInt(getGeoNameId(instance));
    streamWriter.writeDouble(getLatitude(instance));
    streamWriter.writeDouble(getLongitude(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getPopulation(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return es.uem.geolocation.shared.Toponym_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    es.uem.geolocation.shared.Toponym_FieldSerializer.deserialize(reader, (es.uem.geolocation.shared.Toponym)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    es.uem.geolocation.shared.Toponym_FieldSerializer.serialize(writer, (es.uem.geolocation.shared.Toponym)object);
  }
  
}
