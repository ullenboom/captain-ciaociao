package com.tutego.exercise.string;

public class ShortName {

  //tag::solution[]
  private static final int INDEX_NOT_FOUND = -1;

  private static String shortest( String s1, String s2 ) {
    return s1.length() <= s2.length() ? s1 : s2;
  }

  private static String shortestName( String... names ) {

    if ( names.length == 0 )
      return "";

    String result = names[ 0 ];

    for ( String name : names ) {
      int spacePos = name.indexOf( ' ' );
      if ( spacePos == INDEX_NOT_FOUND )
        result = shortest( result, name );
      else {
        String part1 = name.substring( 0, spacePos );
        String part2 = name.substring( spacePos + 1 );
        result = shortest( result, shortest( part1, part2 ) );
      }
    }
    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( shortestName( "Albert Tross", "Blowfish", "Nick Olaus", "Jo Ker" ) );
  }
}
