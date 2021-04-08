package com.tutego.exercise.lang;

import java.util.Locale;

public class SvgCircleWithRandomRadius {
  public static void main( String[] args ) {
    //tag::solution[]
    int x = 100, y = 110;
    double r = Math.random() * 10 + 10;

    System.out.printf(
      "<svg height=\"100\" width=\"1000\">\n <circle cx=\"%d\" cy=\"%d\" r=\"%s\" />\n</svg>\n%n",
      x, y, r );

    System.out.printf(
      Locale.ENGLISH,
      "<svg height=\"100\" width=\"1000\">\n <circle cx=\"%d\" cy=\"%d\" r=\"%.2f\" />\n</svg>\n%n",
      x, y, r );
    //end::solution[]
  }
}
