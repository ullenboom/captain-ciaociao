package com.tutego.exercise.lang;

public class SummingCalculator {
  public static void main( String[] args ) {
    /*
    //tag::solution1[]
    final int END_OF_INPUT = 0;
    int sum   = 0;
    int input = 0;

    do {
      input = new java.util.Scanner( System.in ).nextInt();
      sum += input;
    } while ( input != END_OF_INPUT );

    System.out.printf( "Sum: %d%n", sum );
    //end::solution1[]
    */

    //tag::solution2[]
    final int END_OF_INPUT = 0;
    int sum = 0;

    for ( int input; (input = new java.util.Scanner( System.in ).nextInt()) != END_OF_INPUT; )
      sum += input;

    System.out.printf( "Sum: %d%n", sum );
    //end::solution2[]
  }
}
