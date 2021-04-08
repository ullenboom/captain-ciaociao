package com.tutego.exercise.math;

//tag::solution[]
import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction> {

  public final int numerator;
  public final int denominator;

  public Fraction( int numerator, int denominator ) {
    if ( denominator == 0 )
      throw new ArithmeticException( "denominator of a fraction can't be 0" );

    // denominator always positive
    if ( denominator < 0 ) {
      numerator   = -numerator;
      denominator = -denominator;
    }

    // shortcut if denominator == 1
    if ( denominator == 1 ) {
      this.numerator   = numerator;
      this.denominator = 1;
    }
    else {
      // try to simplify every fraction
      int gcd = gcd( numerator, denominator );
      // might be 1, but divide anyway
      this.numerator   = numerator / gcd;
      this.denominator = denominator / gcd;
    }
  }

  private static int gcd( int a, int b ) {
    return BigInteger.valueOf( a )
                     .gcd( BigInteger.valueOf( b ) )
                     .intValue();
  }

  public Fraction( int value ) {
    this( value, 1 );
  }

  public Fraction reciprocal() {
    return new Fraction( denominator, numerator );
  }

  public Fraction multiply( Fraction other ) {
    return new Fraction( Math.multiplyExact( numerator, other.numerator ),
                         Math.multiplyExact( denominator, other.denominator ) );
  }

  @Override
  public int intValue() {
    return numerator / denominator;
  }

  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  @Override
  public int compareTo( Fraction other ) {
    return Double.compare( doubleValue(), other.doubleValue() );
  }

  @Override
  public boolean equals( Object other ) {
    if ( other == this )
      return true;
    if ( ! (other instanceof Fraction) )
      return false;

    Fraction otherFraction = (Fraction) other;
    return    numerator   == otherFraction.numerator
           && denominator == otherFraction.denominator;
  }

  @Override
  public int hashCode() {
    return numerator + Integer.reverse( denominator );
  }

  @Override
  public String toString() {
    return numerator   == 0 ? "0" :
           denominator == 1 ? "" + numerator :
           numerator + " / " + denominator;
  }
}
//end::solution[]

class FractionDemo {
  public static void main( String[] args ) {
    System.out.println( new Fraction( 10, 2 ) );
    System.out.println( new Fraction( -100, 6 ) );
    System.out.println( new Fraction( -100, -6 ) );
    System.out.println( new Fraction( 100, -6 ) );
    System.out.println( new Fraction( 6, 4 ).multiply( new Fraction( 3 ).reciprocal() ) );
  }
}