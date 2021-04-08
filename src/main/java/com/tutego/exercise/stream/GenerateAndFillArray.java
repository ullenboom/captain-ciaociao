package com.tutego.exercise.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateAndFillArray {

  //tag::solution[]
  public static int[] fillNewArray( int size, int value ) {
    if ( size < 0 )
      throw new IllegalArgumentException( "size can not be negative" );

    return IntStream.range( 0, size ).map( __ -> value ).toArray();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( Arrays.toString( fillNewArray( 3, -1 ) ) );
  }
}
