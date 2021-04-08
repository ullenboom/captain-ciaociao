package com.tutego.exercise.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DecadesArray {

  //tag::solution[]
  public static int[] decades( int start, int end ) {
    return IntStream.rangeClosed( start / 10, end / 10 )
                    .map( x -> x * 10 )
                    .toArray();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( Arrays.toString( decades( 1890, 1920 ) ) ); // [1890, 1900, 1910, 1920]
    System.out.println( Arrays.toString( decades( 0, 10 ) ) );      // [0, 10]
    System.out.println( Arrays.toString( decades( 10, 10 ) ) );     // [10]
    System.out.println( Arrays.toString( decades( 10, -10 ) ) );    // []
  }
}
