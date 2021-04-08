package com.tutego.exercise.array;

import java.util.Arrays;

public class Tetraphobia {
  //tag::solution[]
  private static boolean containsFour( int number ) {
    return String.valueOf( number ).contains( "4" );
  }

  public static int[] fourLast( int... numbers ) {

    if ( numbers.length < 2 )
      return numbers;

    for ( int startIndex = 0; startIndex < numbers.length; startIndex++ ) {
      if ( ! containsFour( numbers[ startIndex ] ) )
        continue;

      // from right to left search the first number without a 4
      for ( int endIndex = numbers.length - 1; endIndex > startIndex; endIndex-- ) {
        if ( containsFour( numbers[ endIndex ] ) )
          continue;
        // swap number[i] (with 4) and number[j] no 4
        int swap = numbers[ startIndex ];
        numbers[ startIndex ] = numbers[ endIndex ];
        numbers[ endIndex ]   = swap;
      }
    }
    return numbers;
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] numbers1 = { 1, 44, 2, 4, 43 };
    System.out.println( Arrays.toString( fourLast( numbers1 ) ) );
    System.out.println( Arrays.toString( fourLast( 4, 4, 44, 1234 ) ) );
  }
}
