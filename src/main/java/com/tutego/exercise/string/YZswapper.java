package com.tutego.exercise.string;

public class YZswapper {

  //tag::solution[]
  static void printSwappedYZ1( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( c == 'y' ) c = 'z';
      else if ( c == 'z' ) c = 'y';
      else if ( c == 'Y' ) c = 'Z';
      else if ( c == 'Z' ) c = 'Y';
      System.out.print( c );
    }
  }

  static void printSwappedYZ2( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      switch ( string.charAt( i ) ) {
        case 'y': System.out.print( 'z' ); break;
        case 'z': System.out.print( 'y' ); break;
        case 'Y': System.out.print( 'Z' ); break;
        case 'Z': System.out.print( 'Y' ); break;
        default:  System.out.print( string.charAt( i ) );
      }
    }
  }

  static void printSwappedYZ3( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      System.out.print( c == 'y' ? 'z' :
                        c == 'Y' ? 'Z' :
                        c == 'z' ? 'y' :
                        c == 'Z' ? 'Y' :
                        c );

    }
  }

  static void printSwappedYZ4( String string ) {
    char[] c = string.toCharArray();
    for ( int i = 0; i < c.length; i++ ) {
      if ( c[ i ] == 'y' ) c[ i ] = 'z';
      else if ( c[ i ] == 'z' ) c[ i ] = 'y';
      else if ( c[ i ] == 'Y' ) c[ i ] = 'Z';
      else if ( c[ i ] == 'Z' ) c[ i ] = 'Y';
    }
    String result = new String( c );
    System.out.print( result );
  }
  //end::solution[]

  /*
  static void printSwappedYZ5( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      switch ( string.charAt( i ) ) {
        case 'y' -> System.out.print( 'z' );
        case 'z' -> System.out.print( 'y' );
        case 'Y' -> System.out.print( 'Z' );
        case 'Z' -> System.out.print( 'Y' );
        default ->  System.out.print( string.charAt( i ) );
      }
    }
  }

  static void printSwappedYZ6( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      System.out.print(
          switch ( string.charAt( i ) ) {
            case 'y' -> 'z'; case 'Y' -> 'Z';
            case 'z' -> 'y'; case 'Z' -> 'Y';
            default -> string.charAt( i );
          } );
    }
  }
  */
  public static void main( String[] args ) {
    printSwappedYZ1( "yYzZ" );
    System.out.println();
    printSwappedYZ2( "yYzZ" );
    System.out.println();
    printSwappedYZ3( "yYzZ" );
    System.out.println();
    printSwappedYZ4( "yYzZ" );
    System.out.println();
  }
}