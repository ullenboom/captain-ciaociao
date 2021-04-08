package com.tutego.exercise.string;

public class PrintAsciiTable {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Dec Hex   Dec Hex   Dec Hex   Dec Hex   Dec Hex   Dec Hex" );

    for ( int row = 0; row < 16; row++ ) {
      for ( int asciiCode = 32 + row; asciiCode <= 127; asciiCode += 16 ) {
        System.out.printf( "%1$3d %1$X %2$s  ",
                           asciiCode,
                           asciiCode == 127 ? "DEL" : Character.toString( asciiCode ) );
      }
      System.out.println();
    }
    //end::solution[]
  }
}
