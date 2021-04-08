package com.tutego.exercise.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class XhtmlHasImgTagWithAltAttribute {
  //tag::solution[]
  static void reportMissingAltElements( Path path ) {
    try ( InputStream is = Files.newInputStream( path ) ) {
      for ( XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader( is );
            parser.hasNext(); ) {
        parser.next();
        boolean isStartElement = parser.getEventType() == XMLStreamConstants.START_ELEMENT;
        if ( isStartElement ) {
          boolean isImgTag = "img".equalsIgnoreCase( parser.getLocalName() );
          if ( isImgTag && ! containsAltAttribute( parser ) )
            System.err.printf( "img does not contain alt attribute:%n%s%n", parser.getLocation() );
        }
      }
    }
    catch ( IOException | XMLStreamException e ) {
      throw new RuntimeException( e );
    }
  }

  private static boolean containsAltAttribute( XMLStreamReader parser ) {
    return IntStream.range( 0, parser.getAttributeCount() )
                    .mapToObj( parser::getAttributeLocalName )
                    .anyMatch( "alt"::equalsIgnoreCase );
  }
  //end::solution[]

  public static void main( String[] args ) throws URISyntaxException {
    String filename = "index.xhtml";
    Path source = Path.of( XhtmlHasImgTagWithAltAttribute.class.getResource( filename ).toURI() );
    reportMissingAltElements( source );
  }
}
