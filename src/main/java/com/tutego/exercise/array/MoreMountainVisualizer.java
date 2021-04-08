package com.tutego.exercise.array;

public class MoreMountainVisualizer {

  public static void printMountain( int[] altitudes ) {
    int maxAltitude = altitudes[ 0 ];

    for ( int i = 0; i < altitudes.length; i++ )
      if ( altitudes[ i ] > maxAltitude )
        maxAltitude = altitudes[ i ];

    //tag::solution-a[]
    for ( int height = maxAltitude; height >= 0; height-- ) {
      System.out.print( height + " " );
      for ( int x = 0; x < altitudes.length; x++ )
        System.out.print( altitudes[ x ] == height ? mountainChar( altitudes, x ) : ' ' );
      System.out.println();
    }
    //end::solution-a[]
  }

  //tag::solution-b[]
  private static char mountainChar( int[] altitudes, int index ) {
    int previous = index == 0 ? 0 : altitudes[ index - 1 ];
    int current  = altitudes[ index ];
    int next     = index < altitudes.length - 1 ? altitudes[ index + 1 ] : -1;

    if ( previous < current && current > next )
      return '^';
    if ( current < next )
      return '/';
    if ( current > next )
      return '\\';
    // current == next )
    return '-';
  }
  //end::solution-b[]

  public static void main( String[] args ) {
    int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
    printMountain( mountain );
  }
}
