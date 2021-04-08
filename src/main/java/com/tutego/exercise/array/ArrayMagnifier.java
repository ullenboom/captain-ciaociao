package com.tutego.exercise.array;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayMagnifier {

  //tag::solution[]
  public static int[][] magnify( int[][] array, int factor ) {
    int width = array[ 0 ].length;
    int height = array.length;
    int[][] result = new int[ height * factor ][ width * factor ];

    for ( int row = 0; row < result.length; row++ ) {
      for ( int col = 0; col < result[ row ].length; col++ )
        result[ row ][ col ] = array[ row / factor ][ col / factor ];
    }
    return result;
  }

  private static void printValues( int[][] array ) {
    for ( int[] rows : array ) {
      for ( int col = 0; col < rows.length; col++ )
        System.out.printf( "%03d%s", rows[ col ], col == rows.length - 1 ? "" : ", " );
      System.out.println();
    }
  }

  private static void fillWithRandomValues( int[][] array ) {
    for ( int row = 0; row < array.length; row++ ) {
      int[] cols = array[ row ];
      for ( int col = 0; col < cols.length; col++ ) {
        array[ row ][ col ] = ThreadLocalRandom.current().nextInt( 256 );
      }
    }
  }

  public static void main( String[] args ) {
    int[][] testArray = new int[ 2 ][ 5 ];
    fillWithRandomValues( testArray );
    printValues( testArray );
    int[][] result = magnify( testArray, 2 );
    printValues( result );
  }
  //end::solution[]
}
