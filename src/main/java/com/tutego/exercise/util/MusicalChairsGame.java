package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//tag::solution[]
class MusicalChairs {

  private final List<String> names;

  public MusicalChairs( String... names ) {
    if ( names.length == 0 )
      throw new IllegalArgumentException( "no names are given, but names must not be empty" );
    this.names = new ArrayList<>( Arrays.asList( names ) );
  }

  public void rotate( int distance ) {
    Collections.rotate( names, distance );
  }

  public void rotateAndRemoveLast( int distance ) {
    if ( names.isEmpty() )
      throw new IllegalStateException( "names is empty, no names to remove" );

    rotate( distance );
    names.remove( names.size() - 1 );
  }

  public String play() {
    if ( names.isEmpty() )
      throw new IllegalStateException( "names is empty, no names to play with" );

    while ( names.size() > 1 ) {
      rotateAndRemoveLast( ThreadLocalRandom.current().nextInt() );
      System.out.println( names );
    }

    return names.get( 0 );
  }

  @Override public String toString() {
    return String.join( ", ", names );
  }
}
//end::solution[]

public class MusicalChairsGame {

  public static void main( String[] args ) {
    MusicalChairs musicalChairs = new MusicalChairs( "Laser", "Milka", "Popo", "Despot" );

    // Rotate
    musicalChairs.rotate( 2 );
    System.out.println( musicalChairs ); // Popo, Despot, Laser, Milka

    // rotate and remove last
    musicalChairs.rotateAndRemoveLast( 2 );
    System.out.println( musicalChairs );

    // Rotate and remove last in a loop
    String winner = musicalChairs.play();
    System.out.println( "The winner is: " + winner );
  }
}