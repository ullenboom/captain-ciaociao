package com.tutego.exercise.lang;

public class SmallestLargestDigit {

  public static void main( String[] args ) {
    //tag::solution[]
    final long n = 30;

    long largest  = 0;
    long smallest = n == 0 ? 0 : 9;

    for ( long value = Math.abs( n ); value != 0; value /= 10 ) {
      long lastDigit = value % 10;
      largest  = Math.max( lastDigit, largest );
      smallest = Math.min( lastDigit, smallest );
    }

    System.out.println( smallest + ", " + largest );
    //end::solution[]
  }
}
