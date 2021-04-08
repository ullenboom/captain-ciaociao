package com.tutego.exercise.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerMean {
  //tag::solution[]
  private final static BigDecimal TWO = BigDecimal.valueOf( 2 );

  public static long meanExact( long x, long y ) {
    BigInteger bigSum  = BigInteger.valueOf( x ).add( BigInteger.valueOf( y ) );
    BigInteger bigMean = bigSum.divide( BigInteger.TWO );
    return bigMean.longValue();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( meanExact( 1, 2 ) );
    System.out.println( (1 + 2) / 2 );
    System.out.println( meanExact( -1, -2 ) );
    System.out.println( (-1 + -2) / 2 );
  }
}
