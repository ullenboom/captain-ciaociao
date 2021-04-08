package com.tutego.exercise.string;

public class StringUtils {

  //tag::solution[]
  private static final int INDEX_NOT_FOUND = -1;

  public static int countMatches( String string, String other ) {

    if ( string == null || other == null || string.length() == 0 || other.length() == 0 )
      return 0;

    int result = 0;

    for ( int index = 0;
          (index = string.indexOf( other, index )) != INDEX_NOT_FOUND;
          index += other.length() )
      result++;

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( countMatches( "abba", "" ) );
    System.out.println( countMatches( "abba", "a" ) );
    System.out.println( countMatches( "abba", "ab" ) );
    System.out.println( countMatches( "abba", "xxx" ) );
    System.out.println( countMatches( "aaaa", "aa" ) );
  }
}
