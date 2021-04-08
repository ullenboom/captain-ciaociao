package com.tutego.exercise.oop;

public class BermudaTriangle {

  public static void main( String[] args ) {
    //tag::solution[]
    java.awt.Polygon bermuda = new java.awt.Polygon();

    // Dimensions of the Bermuda triangle
    bermuda.addPoint( 10, 40 );
    bermuda.addPoint( 20, 5 );
    bermuda.addPoint( 40, 20 );

    // Inside the Bermuda triangle?
    System.out.println( bermuda.contains( 25, 25 ) );  // true

    final int DIMENSION = 50;
    final String OCTOPUS = "\uD83D\uDC19";
    final String RAINBOW = "\uD83C\uDF08";

    // For every coordinate pair test if inside triangle
    for ( int y = 0; y < DIMENSION; y++ ) {
      for ( int x = 0; x < DIMENSION; x++ )
        System.out.print( bermuda.contains( x, y ) ? OCTOPUS : RAINBOW );
      System.out.println();
    }
    //end::solution[]
  }
}