package com.tutego.exercise.oop.gol;

import java.util.concurrent.ThreadLocalRandom;

public class ConwaysGameOfLife {

  public static void main( String[] args ) {

    Cells generation1 = new Cells( 10 );
    generation1.randomCellsAlive();
    generation1.print();

    System.out.println( "------------------------------------------" );

    Cells generation2 = generation1.nextGeneration();
    generation2.print();
  }
}

class Cells {

  private final boolean[][] array;

  public Cells( int size ) {
    // at the beginning the array elements are false = everything is dead
    array = new boolean[ size ][ size ];
  }

  public Cells randomCellsAlive() {
    int size = array.length;
    for ( int i = 0; i < (size * size) / 5; i++ )
      liveAt( ThreadLocalRandom.current().nextInt( size ),
              ThreadLocalRandom.current().nextInt( size ) );
    return this;
  }

  public void liveAt( int x, int y ) {
    array[ x ][ y ] = true;
  }

  public void dieAt( int x, int y ) {
    array[ x ][ y ] = false;
  }

  private int countLiveAt( int x, int y ) {
    return ( x < 0 || y < 0 || x > array.length - 1 || y > array.length - 1 )
           ? 0
           : array[ x ][ y ] ? 1 : 0;
  }

  public boolean isLiveAt( int x, int y ) {
    return countLiveAt( x, y ) == 1;
  }

  public int countLivingNeighbors( int x, int y ) {
    return countLiveAt( x-1, y-1 ) + countLiveAt( x, y-1 ) + countLiveAt( x+1, y-1 ) +
        countLiveAt( x-1, y   ) +                       + countLiveAt( x+1, y   ) +
        countLiveAt( x-1, y+1 ) + countLiveAt( x, y+1 ) + countLiveAt( x+1, y+1 );
  }

  public Cells nextGeneration() {
    int size = array.length;
    Cells result = new Cells( size );
    for ( int x = 0; x < size; x++ )
      for ( int y = 0; y < size; y++ )
        nextGenerationAt( x, y, result );
    return result;
  }

  private void nextGenerationAt( int x, int y, Cells newArea ) {
    int  livingCellsAround = countLivingNeighbors( x, y );
    boolean isCellAlive    = isLiveAt( x, y );

    // Eine lebendige Zelle mit zwei oder drei lebendigen Nachbarn lebt weiter.
    if ( isCellAlive && (livingCellsAround == 2 || livingCellsAround == 3) )
      newArea.liveAt( x, y );

      // Eine lebendige Zelle stirbt, wenn sie weniger als zwei lebendige Nachbarzellen hat.
    else if ( isCellAlive && livingCellsAround < 2 )
      newArea.dieAt( x, y );

      // Eine lebendige Zelle mit mehr als drei lebenden Nachbarzellen stirbt im nächsten Zeitschritt.
    else if ( isCellAlive && livingCellsAround > 3 )
      newArea.dieAt( x, y );

      // Eine tote Zelle wird wiederbelebt, wenn sie genau drei lebende Nachbarzellen hat.
    else if ( ! isCellAlive && livingCellsAround == 3 )
      newArea.liveAt( x, y );
  }

  public void print() {
    for ( int y = 0; y < array.length; y++ ) {
      for ( int x = 0; x < array.length; x++ )
        System.out.print( isLiveAt( x, y ) ? "*" : " " );
      System.out.println();
    }
  }
}
