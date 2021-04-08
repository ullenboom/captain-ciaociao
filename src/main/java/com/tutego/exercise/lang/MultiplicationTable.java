package com.tutego.exercise.lang;

public class MultiplicationTable {

  //tag::solution[]
  private static void startTable() { System.out.println( "<table>" ); }

  private static void endTable() { System.out.println( "</table>" ); }

  private static void startRow() { System.out.print( "<tr>" ); }

  private static void endRow() { System.out.println( "</tr>" ); }

  private static void headerCell( String value ) {
    System.out.print( "<th>" + value + "</th>" );
  }

  private static void dataCell( String value ) {
    System.out.print( "<td>" + value + "</td>" );
  }

  private static void dataCell( int value ) {
    dataCell( Integer.toString( value ) );
  }

  public static void main( String[] args ) {
    final int BASE_PRICE_FLAMETHROWER      = 500;
    final int BASE_PRICE_FIRE_EXTINGUISHER = 100;

    startTable();

    startRow();
    headerCell( "Quantity" );
    headerCell( "Flamethrower" );
    headerCell( "Fire extinguisher" );
    endRow();

    for ( int i = 1; i <= 10; i++ ) {
      startRow();
      dataCell( i );
      dataCell( BASE_PRICE_FLAMETHROWER * i );
      dataCell( BASE_PRICE_FIRE_EXTINGUISHER * i );
      endRow();
    }

    endTable();
  }
  //end::solution[]
}
