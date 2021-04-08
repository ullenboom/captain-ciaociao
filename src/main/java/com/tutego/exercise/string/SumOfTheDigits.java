package com.tutego.exercise.string;

public class SumOfTheDigits {

  //tag::solution[]
  static int digitSum( long value ) {
    return digitSum( String.valueOf( value ) );
  }

  static int digitSum( String value ) {
    int sum = 0;

    for ( int i = 0; i < value.length(); i++ )
      // sum += value.charAt( i ) - '0';
      sum += Character.getNumericValue( value.charAt( i ) );

    return sum;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( digitSum( "12345" ) ); // 15
    System.out.println( digitSum( 12345 ) ); // 15
  }
}