package com.tutego.exercise.array;

public class MountainVisualizer {

  //tag::solution[]
  private static String mountainChar() { return "*"; }

  public static void printMountain( int[] altitudes ) {

    int maxAltitude = altitudes[ 0 ];

    for ( int currentAltitude : altitudes )
      if ( currentAltitude > maxAltitude )
        maxAltitude = currentAltitude;

    // include height 0, so it’s >= 0
    for ( int height = maxAltitude; height >= 0; height-- ) {
      System.out.print( height + " " );
      for ( int altitude : altitudes )
        System.out.print( altitude == height ? mountainChar() : ' ' );
      System.out.println();
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
    printMountain( mountain );
  }
}
