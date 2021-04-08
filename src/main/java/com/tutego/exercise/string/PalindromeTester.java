package com.tutego.exercise.string;

public class PalindromeTester {

  //tag::solution[]
  public static boolean isPalindrome( String string ) {

    for ( int index = 0; index < string.length() / 2; index++ ) {
      char frontChar = string.charAt( index );
      char backChar  = string.charAt( string.length() - index - 1 );
      if ( frontChar != backChar )
        return false;
    }
    return true;
  }

  public static boolean isPalindromeIgnoringCase( String string ) {
    return isPalindrome( string.toLowerCase() );
  }

  public static boolean isPalindromeIgnoringNonLettersAndDigits( String string ) {

    for ( int startIndex = 0, endIndex = string.length() - 1;
          startIndex < endIndex;
          startIndex++, endIndex-- ) {
      while ( ! Character.isLetterOrDigit( string.charAt( startIndex ) ) )
        startIndex++;
      while ( ! Character.isLetterOrDigit( string.charAt( endIndex ) ) )
        endIndex--;

      char frontChar = Character.toLowerCase( string.charAt( startIndex ) );
      char backChar  = Character.toLowerCase( string.charAt( endIndex ) );
      if ( frontChar != backChar )
        return false;
    }
    return true;
  }

  public static boolean isPalindromeRecursive( String string ) {

    if ( string.length() < 2 )
      return true;

    if ( string.charAt( 0 ) != string.charAt( string.length() - 1 ) )
      return false;

    return isPalindromeRecursive( string.substring( 1, string.length() - 1 ) );
  }
  //end::solution[]

  //  public static boolean isPalindrome( String s ) {
  //    String reversed = "";
  //
  //    for ( int i = s.length() - 1; i >= 0; i-- )
  //      reversed += s.charAt( i );
  //
  //    return reversed.equals( s );
  //  }

  public static void main( String[] args ) {
    System.out.println( isPalindrome( "otso" ) );
    System.out.println( isPalindromeIgnoringCase( "Otto" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Ott o" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Sei fies – stets sei fies!" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "Pepe in Tahiti hat nie Pep" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "1" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "11" ) );
    System.out.println( isPalindromeIgnoringNonLettersAndDigits( "112" ) );
    System.out.println( isPalindromeRecursive( "otto" ) );

    boolean isPalindrome = new StringBuilder( "otto" ).reverse().toString().equals( "otto" );
    System.out.println( isPalindrome );
  }
}
