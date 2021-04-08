package com.tutego.exercise.string;

public class PasswordTester {

  //tag::solution[]
  public static final int MIN_PASSWORD_LEN = 8;

  public static boolean isGoodPassword( String password ) {

    if ( password.length() < MIN_PASSWORD_LEN ) {
      System.err.println( "Password is too short" );
      return false;
    }

    if ( !containsUppercaseLetter( password ) ) {
      System.err.println( "Must contain uppercase letters" );
      return false;
    }

    if ( !containsLowercaseLetter( password ) ) {
      System.err.println( "Must contain lowercase letters" );
      return false;
    }

    if ( !containsDigit( password ) ) {
      System.err.println( "Must contain a number" );
      return false;
    }

    if ( !containsSpecialCharacter( password ) ) {
      System.err.println( "Must contain special characters like .," );
      return false;
    }

    return true;
  }

  private static boolean containsUppercaseLetter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isUpperCase( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsLowercaseLetter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isLowerCase( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsDigit( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isDigit( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsSpecialCharacter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      switch ( c ) {
        case '.':
        case ',':
          return true;
      }
    }
    return false;
  }

  public static void main( String[] args ) {
    System.out.println( isGoodPassword( "zukurz" ) );
    System.out.println( isGoodPassword( "nurkleinbuchstaben" ) );
    System.out.println( isGoodPassword( "keineziffern" ) );
    System.out.println( isGoodPassword( "Mit0Sonderzeichen" ) );
    System.out.println( isGoodPassword( "Mit 3 Sonderzeichen .$#&" ) );
  }
  //end::solution[]
}
