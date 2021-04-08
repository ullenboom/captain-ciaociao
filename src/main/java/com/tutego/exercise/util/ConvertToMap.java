package com.tutego.exercise.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConvertToMap {

  //tag::solution[]
  public static Map<String, String> convertToMap( String[][] array ) {

    if ( array.length == 0 )
      return Collections.emptyMap();

    if ( array.length == 1 )
      return Collections.singletonMap( Objects.requireNonNull( array[ 0 ][ 0 ] ),
                                       Objects.requireNonNull( array[ 0 ][ 0 ] ) );

    Map<String, String> result = new HashMap<>( Math.max( array.length, 16 ) );

    for ( String[] row : array )
      result.put( Objects.requireNonNull( row[ 0 ] ),
                  Objects.requireNonNull( row[ 1 ] ) );

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    //tag::example[]
    String[][] array = {
        { "red",   "#FF0000" },
        { "green", "#00FF00" },
        { "blue",  "#0000FF" }
    };
    Map<String, String> colorMap = convertToMap( array );
    System.out.println( colorMap ); // {red=#FF0000, green=#00FF00, blue=#0000FF}
    //end::example[]
  }
}