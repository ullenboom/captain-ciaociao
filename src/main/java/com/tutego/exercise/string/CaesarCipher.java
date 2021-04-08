package com.tutego.exercise.string;

public class CaesarCipher {

  //tag::solution-1[]
  public static final int ALPHABET_LENGTH = 26;

  private static int rotate( int c, int rotation ) {
    if ( rotation < 0 )
      throw new IllegalArgumentException(
          "rotation is not allowed to be negative, but was " + rotation );

    if ( c >= 'A' && c <= 'Z' )   // Character.isUpperCase( c ) is too broad
      return 'A' + (c - 'A' + rotation) % ALPHABET_LENGTH;
    else if ( c >= 'a' && c <= 'z' )
      return 'a' + (c - 'a' + rotation) % ALPHABET_LENGTH;
    else
      return c;
  }
  //end::solution-1[]

  //tag::solution-2[]
  public static String caesar( String s, int rotation ) {
    StringBuilder result = new StringBuilder( s.length() );

    for ( int i = 0; i < s.length(); i++ )
      result.append( (char) rotate( s.charAt( i ), rotation ) );

    return result.toString();

    // Freaky solution
    // IntUnaryOperator rotation = c -> rotate( c, rotation );
    // return s.chars().map( rotation ).mapToObj( Character::toString )
    //         .collect( Collectors.joining() );
  }

  public static String decaesar( String s, int rotation ) {
    return caesar( s, ALPHABET_LENGTH - rotation );
  }
  //end::solution-2[]

  public static void main( String[] args ) {
    System.out.println( (char) rotate( 'A', 0 ) );
    System.out.println( (char) rotate( 'A', 1 ) );
    //    System.out.println( (char) rotate( 'A', -1 ) );

    char rotation = 13;
    String s = "abxyz. ABXYZ!";
    System.out.println( s );
    System.out.println( caesar( s, rotation ) );
    System.out.println( decaesar( caesar( s, rotation ), rotation ) );
  }
}