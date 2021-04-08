package com.tutego.exercise.array;

import java.util.Objects;

public class SaltySnook {
  //tag::solution[]
  public static boolean isProbablyApproaching( String[] signs ) {

    final int MIN_OCCURRENCES = 4;

    if ( signs.length < MIN_OCCURRENCES )
      return false;

    for ( int i = 0, count = 1; i < signs.length - 1; i++ ) {
      String currentSign = Objects.requireNonNull( signs[ i ] );
      String nextSign    = Objects.requireNonNull( signs[ i + 1 ] );
      if ( currentSign.equals( nextSign ) ) {
        count++;
        if ( count == MIN_OCCURRENCES )
          return true;
      }
      else // ! currentSign.equals( nextSign )
        count = 1;
    }
    return false;
  }
  //end::solution[]

  public static void main( String[] args ) {
    String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
    System.out.println( isProbablyApproaching( signs1 ) );   // true

    String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" };
    System.out.println( isProbablyApproaching( signs2 ) );  // false
  }
}
