package com.tutego.exercise.array;

public class SvgVarargPolygon {

  //tag::solution[]
  /**
   * Prints an SVG polygon. Example output:
   * <pre>
   *  <polygon points="200,10 250,190 160,210 " />
   * </pre>
   * @param points of the SVG polygon.
   */
  public static void printSvgPolygon( int... points ) {

    if ( points.length % 2 == 1 )
      throw new IllegalArgumentException( "Array has an odd number of arguments: " + points.length );

    System.out.print( "<polygon points=\"" );

    for ( int i = 0; i < points.length; i += 2 )
      System.out.printf( "%d,%d ", points[ i ], points[ i + 1 ] );

    System.out.println( "\" />" );
  }
  //end::solution[]
}
