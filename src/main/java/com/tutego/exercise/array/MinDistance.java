package com.tutego.exercise.array;

import java.awt.*;

public class MinDistance {

  //tag::solution1[]
  static double minDistance( Point[] points, int size ) {

    if ( points.length == 0 || size > points.length )
      throw new IllegalArgumentException( "Array is either empty or size out of bounds" );

    double minDistance = points[ 0 ].distance( 0, 0 );

    // Index variable i starting at 1, second element
    for ( int i = 1; i < size; i++ ) {
      double distance = points[ i ].distance( 0, 0 );
      if ( distance < minDistance )
        minDistance = distance;
    }

    return minDistance;
  }
  //end::solution1[]

  //tag::solution2[]
  static Point minDistance2( Point[] points, int size ) {
    Point  nearest = points[ 0 ];
    double minDistance = nearest.distance( 0, 0 );

    for ( int i = 1; i < size; i++ ) {
      double distance = points[ i ].distance( 0, 0 );
      if ( distance < minDistance ) {
        minDistance = distance;
        nearest = points[ i ];
      }
    }
    return nearest;
  }
  //end::solution2[]

  public static void main( String[] args ) {
    Point[] points = { new Point( 10, 20 ), new Point( 12, 2 ), new Point( 44, 4 ) };

    System.out.println( minDistance( points, 3 ) );
  }
}