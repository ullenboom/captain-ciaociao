package com.tutego.exercise.string;

import java.util.Arrays;

public class RepeatingStrings {
  //tag::solutiona[]
  public static String repeatingStrings( String string ) {

    if ( string == null || string.length() < 2 )
      return null;

    // Step 1: generate substrings, of length 1, length x, ...

    for ( int length : lengths( string.length() ) ) {
      String substring = string.substring( 0, length );

      // Step 2: check if repetitions of substring are equals to this text

      String repeatedSubstring = substring;
      while ( repeatedSubstring.length() < string.length() )
        repeatedSubstring += substring;

      if ( repeatedSubstring.equals( string ) )
        return substring;
    }

    return null;
  }
  //end::solutiona[]
  // System.out.printf( "Repeating '%s' leads to '%s'%n", substring, repeatedSubstring );

  //tag::solutionb[]
  static int[] lengths( int length ) {

    int[] dividers  = new int[ length / 2 ];
    int dividersIndex = 0;

    for ( int i = 1; i <= length / 2; i++ )
      if ( length % i == 0 )
        dividers[ dividersIndex++ ] = i;

    return Arrays.copyOf( dividers, dividersIndex );
  }
  //end::solutionb[]

  public static void main( String[] args ) {
    System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3C\uD83C\uDF3C" ) );
    System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B" ) );
    System.out.println( repeatingStrings( "CiaoCiao" ) );
    System.out.println( repeatingStrings( "Captain CiaoCiaoCaptain CiaoCiao" ) );
    System.out.println( repeatingStrings( "ababab" ) );
    System.out.println( repeatingStrings( "* * * * * * " ) );
    System.out.println( repeatingStrings( "\uD83C\uDF15\uD83C\uDF14\uD83C\uDF13\uD83C\uDF11" ) );
    System.out.println( repeatingStrings( "CaptainCiaoCiaoCaptain" ) );
    System.out.println( repeatingStrings( "" ) );
    System.out.println( repeatingStrings( "c" ) );
    System.out.println( repeatingStrings( null ) );
  }
}
