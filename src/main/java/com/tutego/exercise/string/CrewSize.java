package com.tutego.exercise.string;

public class CrewSize {

  //tag::solution[]
  public static void printDecodedCrewSizes( String string ) {
    int index = string.indexOf( '-' );
    if ( index < 0 )
      throw new IllegalArgumentException( "Separator - is missing in " + string );
    System.out.print( string + " => " );
    int diff = 2 * index - (string.length() - 1);
    switch ( Integer.signum( diff ) ) {
      case -1:
        System.out.printf( "Raided ship had a larger crew, difference %d%n", -diff );
        break;
      case 0:
        System.out.println( "Ships had the same crew size" );
        break;
      case +1:
        System.out.printf( "Pirate ship had a larger crew, difference %d%n", diff );
        break;
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    printDecodedCrewSizes( "|-|||" );
    printDecodedCrewSizes( "|-||" );
    printDecodedCrewSizes( "|||-|||" );
    printDecodedCrewSizes( "|||||-||" );
    printDecodedCrewSizes( "|||||||" );
  }
}
