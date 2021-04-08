package com.tutego.exercise.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

//tag::solution[]
public class ColorNames {
  public static class Color {
    private final String name;
    private final int rgb;

    private Color( String name, String rgb ) {
      this.name = Objects.requireNonNull( name );
      this.rgb  = decodeHexRgb( rgb );
    }

    public static int decodeHexRgb( String hexRgb ) {
      if ( ! hexRgb.startsWith( "#" ) )
        throw new IllegalArgumentException( "hex does not start with #" );
      if ( ! (hexRgb.length() == 4 || hexRgb.length() == 7) )
        throw new IllegalArgumentException( hexRgb + " is not neither 4 (#RGB) nor 7 symbols (#RRGGBB) long" );

      if ( hexRgb.length() == 4 )
        hexRgb = "#" + hexRgb.charAt( 1 ) + hexRgb.charAt( 1 ) + hexRgb.charAt( 2 )
                     + hexRgb.charAt( 2 ) + hexRgb.charAt( 3 ) + hexRgb.charAt( 3 );
      return Integer.decode( hexRgb );
    }

    @Override public String toString() {
      return String.format( "'%s' is RGB #%06X", name, rgb );
    }
  }

  private final HashMap<Integer, Color> colorMap = new HashMap<>();

  public ColorNames( String filename ) throws IOException {
    for ( String line : Files.readAllLines( Paths.get( filename ) ) ) {
      String[] tokens = line.split( "([\",])+" );
      Color color = new Color( tokens[ 1 ], tokens[ 2 ] );
      colorMap.put( color.rgb, color );
    }
  }

  public Optional<Color> decode( int rgb ) {
    return Optional.ofNullable( colorMap.get( rgb ) );
  }
}
//end::solution[]

class ColorNamesDemo {
  public static void main( String[] args ) throws Exception {
    String file = Paths.get( ColorNamesDemo.class.getResource( "colors.csv" ).toURI() ).toString();
    ColorNames mapper = new ColorNames( file );
    System.out.println( mapper.decode( 7483191 ) );
    System.out.println( mapper.decode( 7 ) );
    System.out.println( mapper.decode( ColorNames.Color.decodeHexRgb( "#00ff00" ) ) );
    System.out.println( mapper.decode( ColorNames.Color.decodeHexRgb( "#ffddf4" ) ) );
    System.out.println( mapper.decode( ColorNames.Color.decodeHexRgb( "#0ff" ) ) );
  }
}
