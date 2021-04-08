package com.tutego.exercise.lang;

public class RandomColor {
  public static void main( String[] args ) {
    //tag::solution[]
    String color;
    double random = Math.random();
    if ( random < 1. / 3 )
      color = "red";
    else if ( random < 2. / 3 )
      color = "green";
    else
      color = "blue";
    System.out.println( color );

    System.out.printf( "<circle cx=\"20\" cy=\"20\" r=\"5\" fill=\"%s\" />", color );
    //end::solution[]
  }
}