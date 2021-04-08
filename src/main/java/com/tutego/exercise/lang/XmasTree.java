package com.tutego.exercise.lang;

public class XmasTree {

  public static void main( String[] args ) {
    //tag::solution[]
    int width = 8;

    for ( int stars = 1, indentation = (width - 1) / 2;
          stars <= width;
          stars += 2, indentation-- ) {

      for ( int i = 0; i < indentation; i++ )
        System.out.print( ' ' );

      for ( int col = 0; col < stars; col++ )
        System.out.print( Math.random() < 0.9 ? '*' : 'o' );

      System.out.println();
    }
    //end::solution[]
  }
}
