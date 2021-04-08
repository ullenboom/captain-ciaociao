package com.tutego.exercise.lang;

public class HumanReadableLiter {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Enter quantity in liters:" );
    double value = new java.util.Scanner( System.in ).nextDouble();

    if ( value >= 1 )
      System.out.printf( "ca. %d l", (long) value );
    else if ( value >= 0.1 )     // 1 l = 100 cl
      System.out.printf( "ca. %d cl", (long) (value * 100) );
    else if ( value >= 0.001 )   // 1 l = 1000 ml
      System.out.printf( "ca. %d ml", (long) (value * 1000) );
    else
      System.err.println( "Value too small to display" );
    //end::solution[]
  }
}
