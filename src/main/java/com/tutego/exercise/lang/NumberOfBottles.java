package com.tutego.exercise.lang;

public class NumberOfBottles {

  public static void main( String[] args ) {
    //tag::solution[]
    int noOfBottles = 1;  // or 0, 1, 99, ...

    System.out.println(   noOfBottles + " "
                        + (noOfBottles != 1 ? "bottles" : "bottle") + " of rum" );

    System.out.printf( "%d bottle%s of rum%n",
                       noOfBottles, noOfBottles != 1 ? "s" : "" );
    //end::solution[]
  }
}
