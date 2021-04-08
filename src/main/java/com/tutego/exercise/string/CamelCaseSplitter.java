package com.tutego.exercise.string;

public class CamelCaseSplitter {

  //tag::solution[]
  private static String camelCaseSplitter( String string ) {
    StringBuilder result = new StringBuilder( string );

    for ( int i = 1; i < result.length(); i++ ) {
      char previousChar = result.charAt( i - 1 );
      char currentChar  = result.charAt( i );
      boolean isPreviousCharLowercase = Character.isLowerCase( previousChar );
      boolean isCurrentCharUppercase  = Character.isUpperCase( currentChar );
      if ( isPreviousCharLowercase && isCurrentCharUppercase ) {
        result.insert( i, " " );
        i++;
      }
    }

    return result.toString();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( camelCaseSplitter( "List" ) );
    System.out.println( camelCaseSplitter( "CiaoCiao" ) );
    System.out.println( camelCaseSplitter( "numberOfElements" ) );
    System.out.println( camelCaseSplitter( "CiaoCiaoCAPTAIN" ) );
    System.out.println( camelCaseSplitter( "CiaoCiaoCAPTAINCiaoCiao" ) );
    System.out.println( camelCaseSplitter( "1" ) );
    System.out.println( camelCaseSplitter( "" ) );

    // ?<= zero-width positive lookbehind
    // ?=  zero-width positive lookahead

    String regex = "(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})";
    String s = String.join( " ", "CiaoCiaoCAPTAINCiaoCiao".split( regex ) );
    System.out.println( s );
  }
}
