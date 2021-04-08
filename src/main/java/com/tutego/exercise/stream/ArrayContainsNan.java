package com.tutego.exercise.stream;

import java.util.stream.DoubleStream;

public class ArrayContainsNan {

  //tag::solution[]
  public static boolean containsNan( double[] numbers ) {
    return DoubleStream.of( numbers ).anyMatch( Double::isNaN );
  }
  //end::solution[]

  public static void main( String[] args ) {
    double[] numbers1 = { Math.sqrt( 2 ), Math.sqrt( 4 ) };
    System.out.println( containsNan( numbers1 ) );           // false

    double[] numbers2 = { Math.sqrt( 2 ), Math.sqrt( -4 ) };
    System.out.println( containsNan( numbers2 ) );           // true
  }
}
