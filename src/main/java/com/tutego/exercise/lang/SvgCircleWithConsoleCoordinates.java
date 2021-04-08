package com.tutego.exercise.lang;

import java.util.Locale;

public class SvgCircleWithConsoleCoordinates {
  public static void main( String[] args ) {
    //tag::solution[]
    int x = new java.util.Scanner( System.in ).nextInt();
    int y = new java.util.Scanner( System.in ).nextInt();

    double r = Math.random() * 10 + 10;

    System.out.printf(
        Locale.ENGLISH,
        "<svg height=\"100\" width=\"1000\">\n <circle cx=\"%d\" cy=\"%d\" r=\"%.2f\" />\n</svg>\n%n",
        x, y, r );
    //end::solution[]
  }
}
