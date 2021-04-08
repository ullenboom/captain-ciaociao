package com.tutego.exercise.oop;

import java.awt.Polygon;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BermudaTriangle2 {

  //tag::solution[]
  private static final int DIMENSION = 50;

  static Polygon resetWithRandomTriangle( Polygon poly ) {
    poly.reset();

    Random random = ThreadLocalRandom.current();
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    
    return poly;
  }

  static Polygon createRandomTriangle() {
    return resetWithRandomTriangle( new Polygon() );
  }
  //end::solution[]

  public static void main( String[] args ) {
    Polygon polygonX = resetWithRandomTriangle( new Polygon() );
    Polygon polygon = createRandomTriangle();

    for ( int y = 0; y < DIMENSION; y++ ) {
      for ( int x = 0; x < DIMENSION; x++ )
        System.out.print( polygon.contains( x, y ) ? "#" : " " );
      System.out.println();
    }
  }
}