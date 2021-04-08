package com.tutego.exercise.lang;

public class PayDay {
  public static void main( String[] args ) {
    //tag::solution[]
    double tortsPayment = new java.util.Scanner( System.in ).nextDouble();

    double minPayment = 1000;
    minPayment -= minPayment * 0.1;
    double maxPayment = 1000;
    maxPayment += maxPayment * 0.2;

    // Solution 1
    if ( tortsPayment >= minPayment && tortsPayment <= maxPayment )
      System.out.println( "Good boy!" );
    else
      System.out.println( "You son of a bi***!" );

    // Solution 2
    if ( tortsPayment < minPayment || tortsPayment > maxPayment )
      System.out.println( "You son of a bi***!" );
    else
      System.out.println( "Good boy!" );
    //end::solution[]
  }
}