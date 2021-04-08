package com.tutego.exercise.lang;

public class SvgCircleWithVariables2 {
  public static void main( String[] args ) {

    //tag::solution[]
    int x = 100, y = 110;
    double r = 20.5;

    System.out.println(   "<svg height=\"100\" width=\"1000\">\n"
                        + " <circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + r + "\" />\n"
                        + "</svg>" );
    //end::solution[]
  }
}
