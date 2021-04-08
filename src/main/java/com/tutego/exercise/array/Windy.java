package com.tutego.exercise.array;

public class Windy {

  public static void main( String[] args ) {
    //tag::solution[]
    final int MAX_WIND_SPEED = 200;
    final int MAX_DEGREE     = 360;

    final int LENGTH = 5;
    int[] windSpeed     = new int[ LENGTH ];
    int[] windDirection = new int[ LENGTH ];

    for ( int i = 0; i < LENGTH; i++ ) {
      windSpeed[ i ]     = (int) (Math.random() * MAX_WIND_SPEED);
      windDirection[ i ] = (int) (Math.random() * MAX_DEGREE);
    }

    for ( int i = 0; i < LENGTH; i++ ) {
      System.out.printf( "Wind speed %d km/h and wind direction %d°",
                         windSpeed[ i ], windDirection[ i ] );
      if ( i != LENGTH - 1 )
        System.out.print( ", " );
    }
    //end::solution[]
  }
}
