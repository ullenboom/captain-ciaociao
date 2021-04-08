package com.tutego.exercise.lang;

public class Checkerboard {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.print( "Checkerboard width: " );
    int width = new java.util.Scanner( System.in ).nextInt();

    System.out.print( "Checkerboard height: " );
    int height = new java.util.Scanner( System.in ).nextInt();

    for ( int y = 0; y < height; y++ ) {
      for ( int x = 0; x < width; x++ )
        System.out.print( (x + y) % 2 == 1 ? '#' : '_' );
      System.out.println();
    }
    //end::solution[]

    System.out.println();

    // Alternative solution with an array for the two characters
    char[] chars = { '_', '#' };
    for ( int y = 0; y < height; y++ ) {
      for ( int x = 0; x < width; x++ )
        System.out.print( chars[ (x + y) % 2 ] );
      System.out.println();
    }
  }
}