package com.tutego.exercise.math;

public class RoundingModeDetector {

  //tag::solution[]
  public enum RoundingMode {
    CAST, ROUND, FLOOR, CEIL, RINT, UNKNOWN;
  }

  private static RoundingMode detectRoundingMode( double value, int rounded ) {
    return rounded == (int) value         ? RoundingMode.CAST :
           rounded == Math.round( value ) ? RoundingMode.ROUND :
           rounded == Math.floor( value ) ? RoundingMode.FLOOR :
           rounded == Math.ceil( value )  ? RoundingMode.CEIL :
           rounded == Math.rint( value )  ? RoundingMode.RINT :
           RoundingMode.UNKNOWN;
  }

  public static RoundingMode detectRoundingMode( double[] numbers, int sum ) {
    double realSum = 0;
    for ( double number : numbers )
      realSum += number;
    return detectRoundingMode( realSum, sum );
  }
  //end::solution[]

  public static void main( String[] args ) {
    double[] numbers = { 199.99 };
    System.out.println( detectRoundingMode( numbers, 200 ) );
  }
}
