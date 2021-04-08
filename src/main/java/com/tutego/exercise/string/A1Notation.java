package com.tutego.exercise.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1Notation {

  //tag::solution[]
  private static final int NUMBER_OF_LETTERS = 26;

  private static int parseColumnIndex( String string ) {
    int result = 0;
    for ( int i = 0; i < string.length(); i++ ) {
      // Map A..Z to 1..26
      int val = Character.getNumericValue( string.charAt( i ) ) - 9;
      result = NUMBER_OF_LETTERS * result + val;
    }
    return result;
  }

  public static int[] parseA1Notation( String cell ) {
    Matcher matcher = Pattern.compile( "([A-Z]+)(\\d+)" ).matcher( cell );
    if ( ! matcher.find() || matcher.groupCount() != 2 )
      return new int[]{ 0, 0 };
    int column = parseColumnIndex( matcher.group( 1 ) );
    int row    = Integer.parseInt( matcher.group( 2 ) );
    return new int[]{ column, row };
  }
  //end::solution[]

  public static void main( String[] args ) {

    System.out.println(Character.getNumericValue( 'Z'));


    //    System.out.println( Arrays.toString( parseA1Notation( "A" ) ) );  // 0
    System.out.println( parseColumnIndex( "A" ) );  // 1
    System.out.println( parseColumnIndex( "Z" ) );  // 26
    System.out.println( parseColumnIndex( "AA" ) );  // 27
    System.out.println( parseColumnIndex( "BA" ) );  // 53
    System.out.println( parseColumnIndex( "IV" ) );  // 256
    System.out.println( parseColumnIndex( "AAA" ) );  // 703
    System.out.println( parseColumnIndex( "WDE" ) );  // 15657
    System.out.println( Arrays.toString( parseA1Notation( "A1" ) ) );
    System.out.println( Arrays.toString( parseA1Notation( "Z2" ) ) );
    System.out.println( Arrays.toString( parseA1Notation( "AA34" ) ) ); // [27, 34]

    System.out.println( Arrays.toString( parseA1Notation( "BZ" ) ) );
    System.out.println( Arrays.toString( parseA1Notation( "34" ) ) );
    System.out.println( Arrays.toString( parseA1Notation( "  " ) ) );
    System.out.println( Arrays.toString( parseA1Notation( "" ) ) );
  }
}
