package com.tutego.exercise.lang;

public class LinePrinterDemo {

  public static void main( String[] args ) {
    //tag::solution1[]
    LinePrinter.line();
    //end::solution1[]

    //tag::solution2[]
    int len = new java.util.Scanner( System.in ).nextInt();
    LinePrinter.line( len );
    System.out.println();

    LinePrinter.line( 4, '*' );
    System.out.println();

    LinePrinter.line( "{", 4, '*', "}" );
    System.out.println();
    //end::solution2[]

    LinePrinter.line( 10, "Oma" );
  }
}

