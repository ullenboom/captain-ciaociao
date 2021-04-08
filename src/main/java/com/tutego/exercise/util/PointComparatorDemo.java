package com.tutego.exercise.util;

import java.util.*;
import java.awt.Point;

//tag::solution[]
class PointDistanceToZeroComparator implements Comparator<Point> {
  @Override
  public int compare( Point p1, Point p2 ) {
    double distanceToZeroPoint1 = p1.distanceSq( 0, 0 );
    double distanceToZeroPoint2 = p2.distanceSq( 0, 0 );
    return Double.compare( distanceToZeroPoint1, distanceToZeroPoint2 );
  }
}
//end::solution[]

public class PointComparatorDemo {
  public static void main( String[] args ) {
    Point[] points = { new Point( 9, 3 ), new Point( 3, 4 ), new Point( 4, 3 ), new Point( 1, 2 ) };
    Arrays.sort( points, new PointDistanceToZeroComparator() );
    System.out.println( Arrays.toString( points ) );
  }
}