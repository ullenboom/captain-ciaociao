package com.tutego.exercise.array;

import java.util.logging.Logger;

public class FairSharing {

  //tag::solution[]
  public static int findSplitPoint( int[] values ) {

    if ( values.length < 2 )
      return -1;

    int sumLeft = values[ 0 ];

    int sumRight = 0;
    for ( int i = 1; i < values.length; i++ )
      sumRight += values[ i ];

    for ( int splitIndex = 1; splitIndex < values.length; splitIndex++ ) {
      int relativeDifference = relativeDifference( sumLeft, sumRight );

      Logger.getLogger( "MuggingFairly" )
            .info( "splitIndex=" + splitIndex
                       + ", sum left/right=" + sumLeft + "/" + sumRight
                       + ", difference=" + relativeDifference );

      if ( relativeDifference <= 10 )
        return splitIndex;

      int element = values[ splitIndex ];
      sumLeft  += element;
      sumRight -= element;
    }
    return -1;
  }

  // https://en.wikipedia.org/wiki/Relative_change_and_difference
  private static int relativeDifference( int a, int b ) {
    if ( a == b ) return 0;
    int absoluteDifference = Math.abs( a - b );
    return (int) (100. * absoluteDifference / Math.max( a, b ));
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] values1 = { 10, 20, 30, 40, 40, 50 };
    System.out.println( findSplitPoint( values1 ) );
    int[] values2 = { 0, 0, 0 };
    System.out.println( findSplitPoint( values2 ) );
    int[] values3 = { 10, 20, 30, 40, 40, 100 };
    System.out.println( findSplitPoint( values3 ) );
  }
}
