package com.tutego.exercise.string;

public class DiamondPrinter {

  //tag::solution[]
  private static void printDiamondIndentation( int indentation ) {
    for ( int i = 0; i < indentation; i++ )
      System.out.print( " " );
  }

  private static void printDiamondCore( char character, char stopCharacter ) {
    if ( character == stopCharacter ) {
      System.out.print( character );
      return;
    }
    System.out.print( character );
    printDiamondCore( (char) (character + 1), stopCharacter );
    System.out.print( character );
  }

  public static void printDiamond( int diameter ) {
    if ( diameter < 1 )
      return;

    diameter = Math.min( diameter, 2 * 26 - 1 );

    int radius = diameter / 2;
    for ( int indentation = radius; indentation >= -radius; indentation-- ) {
      int absIndentation = Math.abs( indentation );
      printDiamondIndentation( absIndentation );
      printDiamondCore( 'A', (char) ('A' + radius - absIndentation) );
      System.out.println();
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    printDiamond( 7 );
    printDiamond( 1 );
    printDiamond( 0 );
    printDiamond( 200 );
  }
}
