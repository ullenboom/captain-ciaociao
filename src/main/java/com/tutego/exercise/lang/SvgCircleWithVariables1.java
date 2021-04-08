package com.tutego.exercise.lang;

public class SvgCircleWithVariables1 {
  public static void main( String[] args ) {

    //tag::solution[]
    int x = 100;
    int y = 110;
    double r = 20.5;

    System.out.println( "<svg height=\"100\" width=\"1000\">" );
    System.out.print( "  <circle cx=\"" );
    System.out.print( x );
    System.out.print( "\" cy=\"" );
    System.out.print( y );
    System.out.print( "\" r=\"" );
    System.out.print( r );
    System.out.println( "\" />" );
    System.out.println( "</svg>" );
    //end::solution[]
  }
}
