package com.tutego.exercise.lang;

import java.util.Scanner;

public class IsFactorial {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Enter a number:" );
    long n = new Scanner( System.in ).nextLong();

    if ( n < 1 )
      System.err.println( "Factorials are always >= 1" );
    else {
      long number  = n;
      long divisor = 2;

      while ( number % divisor == 0 ) {
        number /= divisor;
        divisor++;
      }

      if ( number == 1 )
        System.out.printf( "%d = %d!%n", n, divisor - 1 );
      else
        System.out.printf( "%d is not a factorial%n", n );
    }
    //end::solution[]
  }
}
