package com.tutego.exercise.lang;

public class RightTriangle {

  //tag::solution[]
  public static boolean isRightTriangle( double a, double b, double c ) {

    // Step 1: propagate the largest value into c

    // If a > c then swap
    if ( a > c ) {
      double swap = a;
      a = c;
      c = swap;
    }

    // If b > c then swap
    if ( b > c ) {
      double tmp = b;
      b = c;
      c = tmp;
    }

    // Step 2: The test
    return a * a + b * b == c * c;
  }
  //end::solution[]

//  public static boolean almostEqual( double a, double b, double eps ) {
//    return Math.abs( a - b ) < eps;
//  }

  public static void main( String[] args ) {
    // 3^2 + 4^2 = 5^3
    // Pythagorean Triple ratio of 3:4:5
    System.out.println( isRightTriangle(3, 4, 5 ) );
    System.out.println( isRightTriangle(5, 4, 3 ) );
    System.out.println( isRightTriangle(5, 12, 13 ) ); // 25.0 + 144.0 = 169.0
    System.out.println( isRightTriangle(1, 2, 3 ) );
    System.out.println( isRightTriangle(1, 1, Math.sqrt( 2 ) ) );
    System.out.println( Math.sqrt( 2 ) * Math.sqrt( 2 ) ); // 2.0000000000000004
  }
}
