package com.tutego.exercise.string;

public class ChocolateCovered {

  //tag::solution[]
  private static final String FRUIT = "F";

  public static boolean checkChocolate( String string ) {
    return checkChocolate( string, 0 );
  }

  private static boolean checkChocolate( String string, int layer ) {

    if ( string.isEmpty() )
      return false;

    if ( string.length() == 1 )
      return string.equals( FRUIT ) && layer != 0;

    if ( string.charAt( 0 ) != string.charAt( string.length() - 1 ) )
      return false;

    return checkChocolate( string.substring( 1, string.length() - 1 ), layer + 1 );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( checkChocolate( "dhFhd" ) );
    System.out.println( checkChocolate( "dhXhd" ) );
    System.out.println( checkChocolate( "dhFhdd" ) );
    System.out.println( checkChocolate( "F" ) );
    System.out.println( checkChocolate( "" ) );
  }
}
