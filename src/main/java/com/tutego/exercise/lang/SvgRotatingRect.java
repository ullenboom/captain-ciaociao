package com.tutego.exercise.lang;

public class SvgRotatingRect {

  public static void main( String[] args ) {

    //tag::solution[]
    System.out.println( "<svg height=\"200\" width=\"200\">" );

    for ( int rotation = 0; rotation < 360; rotation += 10 )
      System.out.printf(   " <rect x=\"50\" y=\"50\" "
                         + "width=\"100\" height=\"100\" "
                         + "stroke=\"black\" fill=\"none\" "
                         + "transform=\"rotate(%d 100 100)\" />%n",
                         rotation );

    System.out.println( "</svg>" );
    //end::solution[]
  }
}
