package com.tutego.exercise.math;

import java.math.BigInteger;

public class SequentialNumbersToOneNumber {

  //tag::solution[]
  static BigInteger completeNumber( int... parts ) {
    StringBuilder bigNumber = new StringBuilder( parts.length * 2 );
    for ( int part : parts )
      bigNumber.append( part );

    return new BigInteger( bigNumber.toString() );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( completeNumber( 123, 22, 989, 77, 90 ) );
  }
}