package com.tutego.exercise.lang;

class Collatz {

  //tag::solution[]
  static void collatz( long n ) {
    while ( n > 1 ) {
      System.out.print( n + " -> " );
      if ( n % 2 == 0 )
        n /= 2;
      else
        n = 3 * n + 1;
    }
    System.out.println( 1 );
  }

  static long collatzMax( long n ) {
    long max = n;
    while ( n > 1 ) {
      if ( n % 2 == 0 )
        n /= 2;
      else {
        n = 3 * n + 1;
        if ( n > max )
          max = n;
      }
    }
    return max;
  }

  static long collatz( long n, long max ) {
    if ( n > 1 ) {
      if ( n % 2 == 0 )
        return collatz( n / 2, Math.max( n, max ) );
      return collatz( 3 * n + 1, Math.max( n, max ) );
    }
    return max;
  }

  public static void main( String[] args ) {
    collatz( 27 );
    System.out.println( collatzMax( 27 ) );
    System.out.println( collatz( 27, 0 ) );
    collatz( 20 );
    System.out.println( collatzMax( 20 ) );
    System.out.println( collatz( 20, 0 ) );
  }
  //end::solution[]
}