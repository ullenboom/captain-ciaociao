package com.tutego.exercise.util;

import java.math.BigInteger;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class CachedCatalan {
  //tag::solution[]
  private static final Map<BigInteger, BigInteger> factorialCache = new WeakHashMap<>();

  private static BigInteger factorial( BigInteger n ) {
    BigInteger maybeCachedValue = factorialCache.get( n );

    if ( maybeCachedValue != null )
      return maybeCachedValue;

    // n < 2 ? 1 : n * factorial( n - 1 )
    BigInteger result = isLessThan( n, TWO )
                        ? ONE
                        : n.multiply( factorial( n.subtract( ONE ) ) );

    factorialCache.put( n, result );
    return result;
  }

  private static boolean isLessThan( BigInteger a, BigInteger b ) {
    return a.compareTo( b ) < 0;
  }

  public static BigInteger catalan( BigInteger n ) {
    // (2n)! / (n+1)!n!
    BigInteger numerator   = factorial( TWO.multiply( n ) );
    BigInteger denominator = factorial( n.add( ONE ) ).multiply( factorial( n ) );
    return numerator.divide( denominator );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( factorial( BigInteger.valueOf( 0 ) ) );
    System.out.println( factorial( BigInteger.valueOf( 1 ) ) );
    System.out.println( factorial( BigInteger.valueOf( -1 ) ) );
    System.out.println( factorial( BigInteger.valueOf( 100 ) ) );
    System.out.println( catalan( BigInteger.valueOf( 1 ) ) );  // 1
    System.out.println( catalan( BigInteger.valueOf( 2 ) ) );  // 2
    System.out.println( catalan( BigInteger.valueOf( 3 ) ) );  // 5
    System.out.println( catalan( BigInteger.valueOf( 4 ) ) );  // 14
    System.out.println( catalan( BigInteger.valueOf( 10 ) ) );

    long start = System.nanoTime();
    BigInteger catalan1000 = catalan( BigInteger.valueOf( 1000 ) );
    long end = System.nanoTime();
    System.out.println( catalan1000 );
    System.out.println( TimeUnit.NANOSECONDS.toMillis( end - start ) );

    start = System.nanoTime();
    catalan1000 = catalan( BigInteger.valueOf( 1000 ) );
    end = System.nanoTime();
    System.out.println( catalan1000 );
    System.out.println( TimeUnit.NANOSECONDS.toMillis( end - start ) );
  }
}
