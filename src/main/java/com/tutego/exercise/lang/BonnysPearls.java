package com.tutego.exercise.lang;

public class BonnysPearls {
  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "<svg height=\"100\" width=\"1000\">" );
    for ( int i = 0; i < 50; i++ ) {
      double random = Math.random();
      String color = random < 1./3 ? "blue" :
                     random < 2./3 ? "green" : "orange";
      System.out.printf( "<circle cx=\"%d\" cy=\"20\" r=\"5\" fill=\"%s\" />%n",
                         20 + (i * 10), color );
    }
    System.out.println( "</svg>" );
    //end::solution[]
  }
}
