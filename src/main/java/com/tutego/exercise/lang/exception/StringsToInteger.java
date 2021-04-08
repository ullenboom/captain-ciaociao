package com.tutego.exercise.lang.exception;

import java.util.Arrays;

public class StringsToInteger {

  //tag::solution[]
  private static int parseIntOrElse( String number, int defaultValue ) {
    try {
      return Integer.parseInt( number );
    }
    catch ( NumberFormatException e ) {
      return defaultValue;
    }
  }

  public static int[] parseInts( String... numbers ) {
    int[] result = new int[ numbers.length ];

    for ( int i = 0; i < numbers.length; i++ )
      result[ i ] = parseIntOrElse( numbers[ i ], 0 );

    // Arrays.setAll( result, index -> parseIntOrElse( numbers[ index ], 0 ) );

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( Arrays.toString( parseInts( "1", "234", "333" ) ) );
    System.out.println( Arrays.toString( parseInts( "1", "ll234", "333", null, "99" ) ) );
    System.out.println( Arrays.toString( parseInts( null ) ) );
  }
}