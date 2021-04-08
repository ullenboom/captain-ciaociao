package com.tutego.exercise.string;

public class WordWrap {

  //tag::solution[]
  public static final char SEPARATOR = ' ';

  public static String wrap( String string, int width ) {

    if ( string.length() <= width )
      return string;

    int breakIndex = string.lastIndexOf( SEPARATOR, width );
    if ( breakIndex == -1 )
      breakIndex = width;

    String firstLine = string.substring( 0, breakIndex );
    String remaining = wrap( string.substring( breakIndex ).trim(), width );

    return firstLine + "\n" + remaining;
  }
  //end::solution[]

  public static void main( String[] args ) {
    //tag::example[]
    String s =   "Live now; make now always the most precious time. "
               +"Now will never come again.";
    System.out.println( wrap( s, 30 ) );
    //end::example[]
  }
}