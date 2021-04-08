package com.tutego.exercise.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleStringCompressor {

  //tag::solution[]
  public static String compress( String string ) {

    if ( string.isEmpty() )
      return "";

    char lastChar = string.charAt( 0 );
    int  count = 1;
    StringBuilder result = new StringBuilder( string.length() );

    for ( int i = 1; i < string.length(); i++ ) {
      char currentChar = string.charAt( i );
      if ( currentChar == lastChar )
        count++;
      else {
        result.append( lastChar );
        if ( count > 1 )
          result.append( count );
        count = 1;
        lastChar = currentChar;
      }
    }

    result.append( lastChar );
    if ( count > 1 )
      result.append( count );

    return result.toString();
  }

  private static CharSequence decodeToken( String token ) {

    if ( token.isEmpty() )
      return "";

    if ( token.length() == 1 )
      return token;

    int length = Integer.parseInt( token.substring( 1 ) );
    StringBuilder result = new StringBuilder( length );
    for ( int i = 0; i < length; i++ )
      result.append( token.charAt( 0 ) );

    return result;
  }

  public static String decompress( String string ) {
    StringBuilder result = new StringBuilder( string.length() * 2 );
    Matcher pattern = Pattern.compile( "[.-](\\d*)" ).matcher( string );

    while ( pattern.find() )
      result.append( decodeToken( pattern.group() ) );

    return result.toString();
  }
  //end::solution[]

  public static void main( String[] args ) {
    String input = "--....--------..-";
    System.out.println( input.length() + " " + input );
    System.out.println( compress( input ).length() + " " + compress( input ) );
    System.out.println( decompress( compress( input ) ) );
  }
}
