package com.tutego.exercise.string;

public class RepeatingCharacters {

  //tag::solution[]
  private static int isEveryCharacterTwice( String string ) {

    int FAILURE_CODE = 0;
    int SUCCESS_CODE = 1;

    if ( string.length() % 2 != 0 )
      return FAILURE_CODE;

    for ( int i = 0; i < string.length(); i += 2 ) {
      char first  = string.charAt( i );
      char second = string.charAt( i + 1 );
      if ( first != second )
        return -(i + 1);
    }

    return SUCCESS_CODE;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( isEveryCharacterTwice( "eehhrrwwüürrddiiggeerr$$ccaappttaaiinn" ) );
    System.out.println( isEveryCharacterTwice( "ccapptttaaiinn" ) );
    System.out.println( isEveryCharacterTwice( "222" ) );
  }
}
