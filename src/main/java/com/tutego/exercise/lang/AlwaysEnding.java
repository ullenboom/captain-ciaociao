package com.tutego.exercise.lang;

public class AlwaysEnding {

  public static void main( String[] args ) {
    //tag::solution[]
    double t = Math.random() * 10;

    while ( t > 0 ) {
      System.out.println( t );
//      System.out.printf( "%64s%n", Long.toBinaryString(Double.doubleToLongBits(t)) );
      if ( t < 1 )
        t *= 2;
      else // t >= 1
        t--;
    }
    //end::solution[]
  }
}
