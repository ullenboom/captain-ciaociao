package com.tutego.exercise.os;

import java.io.IOException;
import java.io.InputStream;
import java.util.OptionalInt;
import java.util.Properties;

public class PortConfiguration {
  //tag::solution-a[]
  private static final String PORT = "port";
  private static final int DEFAULT_PORT = 8080;

  private static OptionalInt parseInt( String value ) {
    try {
      return OptionalInt.of( Integer.parseInt( value ) );
    }
    catch ( NumberFormatException e ) {
      return OptionalInt.empty();
    }
  }
  //end::solution-a[]

  //tag::solution-b[]
  private static OptionalInt portFromCommandLine( String[] args ) {
    for ( String arg : args )
      if ( arg.startsWith( "--" + PORT + "=" ) )
        return parseInt( arg.substring( ("--" + PORT + "=").length() ) );
    return OptionalInt.empty();
  }

  private static OptionalInt portFromPropertyFile() {
    String filename = "/application.properties";
    try ( InputStream is = PortConfiguration.class.getResourceAsStream( filename ) ) {
      Properties properties = new Properties();
      properties.load( is );
      return parseInt( properties.getProperty( PORT ) );
    }
    catch ( IOException e ) { /* Ignore */ }
    return OptionalInt.empty();
  }
  //end::solution-b[]

  //tag::solution-c[]
  static int port( String[] args ) {
    // Step 1
    OptionalInt maybePort = portFromCommandLine( args );
    if ( maybePort.isPresent() )
      return maybePort.getAsInt();

    // Step 2
    OptionalInt maybePortProperty = parseInt( System.getProperty( PORT ) );
    if ( maybePortProperty.isPresent() )
      return maybePortProperty.getAsInt();

    // Step 3
    OptionalInt maybePortApplicationProperty = portFromPropertyFile();
    if ( maybePortApplicationProperty.isPresent() )
      return maybePortApplicationProperty.getAsInt();

    // Step 4
    return DEFAULT_PORT;
  }
  //end::solution-c[]

  public static void main( String[] args ) {
    System.out.println( port( args ) );
  }
}
