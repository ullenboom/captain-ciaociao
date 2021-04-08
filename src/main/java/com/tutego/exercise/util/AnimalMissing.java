package com.tutego.exercise.util;

import java.util.BitSet;

public class AnimalMissing {
  //tag::solution[]
  private static String sameSymbols( String string1, String string2 ) {

    BitSet bits = new BitSet( 1024 );

    string1.codePoints().forEach( character -> bits.set( character ) );

    int capacity = (int) ((long) string1.length() + string2.length()) / 2;
    StringBuilder result = new StringBuilder( capacity );
    string2.codePoints().forEach( character -> {
      if ( bits.get( character ) )
        result.appendCodePoint( character );
    } );

    return result.toString();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( sameSymbols( "🐩🐏🐴🦋🐙", "🐴🐏🐧🐸🦋🐌" ) );
    System.out.println( sameSymbols( "abcy", "bcd" ) );
  }
}
