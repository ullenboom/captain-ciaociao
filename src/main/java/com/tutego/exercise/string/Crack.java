package com.tutego.exercise.string;

public class Crack {

  //tag::solution[]
  private static final String CRACK = "♬KNACK♪";

  public static String crackle( String string ) {
    StringBuilder result = new StringBuilder( string );

    for ( int i = string.length() - 1; i >= 0; i-- )
      if ( Math.random() < 0.1 )
        result.insert( i, CRACK );

    return result.toString();
  }

  public static String decrackle( String string ) {
    return string.replace( CRACK, "" );
  }
  //end::solution[]

  public static void main( String[] args ) {
    String s = "Why does it take pirates so long to learn the alphabet? "
             + "Because they can spend years at C!";
    String t = crackle( s );
    System.out.println( t );
    System.out.println( decrackle( t ) );
  }
}