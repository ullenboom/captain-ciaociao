package com.tutego.exercise.string;

public class ABCZ {

  //tag::solution[]
  static String abcz() {
    StringBuilder result = new StringBuilder();

    for ( char c = 'A'; c <= 'Z'; c++ )
      result.append( c );

    return result.toString();
  }

  static String abcz( char start, char end ) {

    if ( end < start )
      return "";

    StringBuilder result = new StringBuilder( end - start + 1 );
    for ( char c = start; c <= end; c++ )
      result.append( c );

    return result.toString();
  }

  static String abcz( char start, int length ) {
    return abcz( start, (char) (start + length - 1) );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( abcz() );
    System.out.println( abcz( 'a', 'g' ) );
    System.out.println( abcz( 'a', 'a' ) );
    System.out.println( abcz( 'z', 'g' ) );
    System.out.println( abcz( 'a', 2 ) );
  }
}
