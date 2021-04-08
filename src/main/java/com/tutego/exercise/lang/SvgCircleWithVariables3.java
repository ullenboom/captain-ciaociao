package com.tutego.exercise.lang;

public class SvgCircleWithVariables3 {
  public static void main( String[] args ) {

    //tag::solution[]
    int x = 100, y = 110;
    double r = 20.5;

    System.out.printf(   "<svg height=\"100\" width=\"1000\">\n"
                       + " <circle cx=\"%d\" cy=\"%d\" r=\"%s\" />\n"
                       + "</svg>\n%n",
                       x, y, r );
    //end::solution[]
  }
}
