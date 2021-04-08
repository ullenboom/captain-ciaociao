package com.tutego.exercise.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class ObjectBase64 {

  //tag::solution-a[]
  public static String serializeObjectToBase64( Object object ) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try ( OutputStream b64os     = Base64.getEncoder().wrap( baos );
          OutputStream dos       = new DeflaterOutputStream( b64os );
          ObjectOutputStream oos = new ObjectOutputStream( dos ) ) {
      oos.writeObject( object );
    }
    catch ( IOException e ) {
      throw new IllegalStateException( e );
    }

    try {
      return baos.toString( StandardCharsets.US_ASCII.name() );
    }
    catch ( UnsupportedEncodingException e ) {
      throw new IllegalStateException( e );
    }
  }
  //end::solution-a[]

  //tag::solution-b[]
  public static Object deserializeObjectFromBase64( String string ) {
    final byte[] bytes = string.getBytes( StandardCharsets.US_ASCII );

    try ( ByteArrayInputStream bis = new ByteArrayInputStream( bytes );
          InputStream b64is        = Base64.getDecoder().wrap( bis );
          InputStream iis          = new InflaterInputStream( b64is );
          ObjectInputStream ois    = new ObjectInputStream( iis ) ) {
      return ois.readObject();
    }
    catch ( IOException | ClassNotFoundException e ) {
      throw new IllegalStateException( e );
    }
  }
  //end::solution-b[]

  public static void main( String[] args ) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put( "datei.php", 1 );
    map1.put( "Zwei", 2 );
    map1.put( "Drei", 3 );

    String base64 = serializeObjectToBase64( map1 );
    System.out.println( base64 );
    Object reconstructedMap = deserializeObjectFromBase64( base64 );
    System.out.println( reconstructedMap );
  }
}