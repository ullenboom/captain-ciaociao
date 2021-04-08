package com.tutego.exercise.array;

public class ArrayReverser {

  public static void main( String[] args ) {
    double[] elements = { Math.random() * 10, Math.random() * 10,
                          Math.random() * 10, Math.random() * 10 };

    for ( int i = 0; i < elements.length; i++ )
      System.out.printf( "%f ", elements[ i ] );

    reverse( elements );
    System.out.println();

    for ( int i = 0; i < elements.length; i++ )
      System.out.printf( "%f ", elements[ i ] );
  }

  //tag::solution[]
  public static void reverse( double[] numbers ) {
    final int middle = numbers.length / 2;

    for ( int left = 0; left < middle; left++ ) {
      int right = numbers.length - left - 1;
      swap( numbers, left, right );
    }
  }

  private static void swap( double[] numbers, int i, int j ) {
    double swap  = numbers[ i ];
    numbers[ i ] = numbers[ j ];
    numbers[ j ] = swap;
  }
  //end::solution[]
}