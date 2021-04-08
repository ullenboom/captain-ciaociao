package com.tutego.exercise.lang;

import java.util.Scanner;

public class Factorial {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Enter a number:" );
    int n = new Scanner( System.in ).nextInt();

    if ( n < 0 )
      System.err.println( "Number must not be negative" );
    else if ( n < 2 )
      System.out.printf( "%d! = 1%n", n );
    else {
      System.out.printf( "%d! = 1", n );
      long factorial = 1;

      for ( int multiplier = 2; multiplier <= n; multiplier++ ) {
        System.out.printf( " * %d", multiplier );
        factorial *= multiplier;
      }

      System.out.printf( " = %d%n", factorial );
    }
    //end::solution[]
  }
}
