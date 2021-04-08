package com.tutego.exercise.stream;

import java.util.Arrays;

public class DoubleStreamMedian {

  //tag::solution[]
  public static double median( double... values ) {
    if ( values.length < 1 )
      throw new IllegalArgumentException( "array contains no elements" );

    int skip  = (values.length - 1) / 2;
    int limit = 2 - values.length % 2;
    return Arrays.stream( values ).sorted().skip( skip ).limit( limit ).average().getAsDouble();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( median( 9 ) );
    System.out.println( median( 9, 11, 11, 11, 12 ) );
    System.out.println( median( 10, 10, 12, 12 ) );
  }
}
