package com.tutego.exercise.string;

public class WeightCheater {

  //tag::solution[]
  private static void swap( StringBuilder string, int i, int j ) {
    if ( i == j ) return;
    char temp = string.charAt( i );
    string.setCharAt( i, string.charAt( j ) );
    string.setCharAt( j, temp );
  }

  public static int cheatedWeight( int weight ) {
    StringBuilder weightString = new StringBuilder().append( weight );
    char smallestDigit = weightString.charAt( 0 );
    int  smallestDigitIndex = 0;
    for ( int i = 1; i < weightString.length(); i++ ) {
      char c = weightString.charAt( i );
      if ( c != '0' && c < smallestDigit ) {
        smallestDigit = c;
        smallestDigitIndex = i;
      }
    }

    swap( weightString, smallestDigitIndex, 0 );

    // Since Java 9
    return Integer.parseInt( weightString, 0, weightString.length(), 10 );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( cheatedWeight( 0 ) );
    System.out.println( cheatedWeight( 1 ) );
    System.out.println( cheatedWeight( 9 ) );
    System.out.println( cheatedWeight( 1234 ) );
    System.out.println( cheatedWeight( 4321 ) );
    System.out.println( cheatedWeight( 100 ) );
    System.out.println( cheatedWeight( 987654321 ) );
  }
}
