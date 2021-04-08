package com.tutego.exercise.lang;

public class SvgCircle2 {
  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "<svg height='400' width='1000'>" );
    System.out.println( " <circle cx='100' cy='100' r='50' />" );
    System.out.println( "</svg>" );

    System.out.println(
      "<svg height='400' width='1000'>\n <circle cx='100' cy='100' r='50' />\n</svg>"
    );

    System.out.println(   "<svg height='400' width='1000'>\n"
                        + " <circle cx='100' cy='100' r='50' />\n"
                        + "</svg>" );
    //end::solution[]
  }
}
