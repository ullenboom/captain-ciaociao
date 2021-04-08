package com.tutego.exercise.lang;

public class XOLLXXTLT {
  
  public static void main( String[] args ) {
    //tag::solution[]
    for ( int l = 0; l < 10; l++ ) {
      for ( int o = 0; o < 10; o++ ) {
        for ( int x = 0; x < 10; x++ ) {
          for ( int t = 0; t < 10; t++ ) {
            int xol = 100 * x + 10 * o + l;
            int lxx = 100 * l + 10 * x + x;
            int tlt = 100 * t + 10 * l + t;

            if ( (xol + lxx) == tlt ) {
              if ( (l != o) && (l != x) && (l != t) &&
                   (o != x) && (o != t) && (x != t) )
                System.out.println( "Alles ungleiche Variablen:" );

              System.out.printf( "l=%d, o=%d, x=%d, t=%d%n", l, o, x, t );
            }
          } // end for t
        } // end for x
      } // end for o
    } // end for l
    //end::solution[]
  }
}