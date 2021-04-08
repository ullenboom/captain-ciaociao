package com.tutego.exercise.array;

public class Sudoku3x3Checker {

  public static void main( String[] args ) {
    int[][] array = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 8 }
    };

    //tag::solution1[]
    final int DIMENSION = 3;
    for ( int i = 1; i <= DIMENSION * DIMENSION; i++ ) {
      boolean found = false;
      matrixLoop:
      for ( int row = 0; row < DIMENSION; row++ ) {
        for ( int column = 0; column < DIMENSION; column++ ) {
          int element = array[ row ][ column ];
          if ( element == i ) {
            found = true;
            break matrixLoop;
          }
        }
      }
      if ( ! found )
        System.out.printf( "Missing %d%n", i );
    }
    //end::solution1[]

    //tag::solution2[]
    boolean[] numberExisted = new boolean[ DIMENSION * DIMENSION ];

    for ( int row = 0; row < DIMENSION; row++ ) {
      for ( int column = 0; column < DIMENSION; column++ ) {
        int element = array[ row ][ column ];
        if ( element >= 1 && element <= 9 )
          numberExisted[ element - 1 ] = true;
      }
    }

    for ( int i = 0; i < numberExisted.length; i++ ) {
      boolean found = numberExisted[ i ];
      if ( ! found )
        System.out.printf( "Missing %d%n", i + 1 );
    }
    //end::solution2[]
  }
}
