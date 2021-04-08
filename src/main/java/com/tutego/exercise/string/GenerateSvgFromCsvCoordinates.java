package com.tutego.exercise.string;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class GenerateSvgFromCsvCoordinates {

  public static void main( String[] args ) throws IOException {
    //tag::solution[]
    String filename = "coordinates.csv";
    try ( InputStream  is = GenerateSvgFromCsvCoordinates.class.getResourceAsStream( filename );
          Scanner scanner = new Scanner( is, StandardCharsets.ISO_8859_1.name() ) ) {
      scanner.useDelimiter( ",|\\s+" ).useLocale( Locale.ENGLISH );

      StringBuilder svg = new StringBuilder( 1024 );
      svg.append( "<svg height=\"210\" width=\"500\">\n<polygon points=\"" );

      while ( scanner.hasNextDouble() ) {
        double x = scanner.nextDouble();

        if ( ! scanner.hasNextDouble() )
          throw new IllegalStateException( "Missing second coordinate" );

        double y = scanner.nextDouble();
        svg.append( x ).append( "," ).append( y ).append( " " );
      }

      svg.append( "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />\n</svg>" );
      System.out.println( svg );
    }
    //end::solution[]
  }
}
