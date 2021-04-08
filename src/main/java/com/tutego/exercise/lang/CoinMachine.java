package com.tutego.exercise.lang;

public class CoinMachine {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Please the enter amount of money:" );
    double input = new java.util.Scanner( System.in ).nextDouble();
    int cents = (int) (input * 100);

    System.out.println( cents / 200 + " x 2 €" );
    cents %= 200;

    System.out.println( cents / 100 + " x 1 €" );
    cents %= 100;

    System.out.println( cents / 50 + " x 50 Cent" );
    cents %= 50;

    System.out.println( cents / 20 + " x 20 Cent" );
    cents %= 20;

    System.out.println( cents / 10 + " x 10 Cent" );
    cents %= 10;

    System.out.println( cents / 5 + " x 5 Cent" );
    cents %= 5;

    System.out.println( cents / 2 + " x 2 Cent" );
    cents %= 2;

    System.out.println( cents + " x 1 Cent" );
    //end::solution[]
  }
}