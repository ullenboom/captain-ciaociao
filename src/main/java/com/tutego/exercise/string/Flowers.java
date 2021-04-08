package com.tutego.exercise.string;

public class Flowers {

  //tag::solution[]
  private final static String FLOWERS =
        "                _\n"
      + "              _(_)_                          wWWWw   _\n"
      + "  @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_\n"
      + " @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)\n"
      + "  @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\\n"
      + "   /      Y       \\|    \\|/    /(_)    \\|      |/      |\n"
      + "\\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/\n"
      + "\\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//\n"
      + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";

  private static final int[] FLOWER_START_POS = { 0, 7, 13, 22, 29, 37, 44, 50, 57 };

  private static final String[] FLOWER_LINES = FLOWERS.split( "\n" );
  private static final int FLOWER_HEIGHT = FLOWER_LINES.length;
  private static final int LONGEST_LINE_LEN = FLOWER_LINES[ FLOWER_HEIGHT - 1 ].length();

  private static String flowerLine( int flower, int line ) {
    String s = FLOWER_LINES[ line ] + " ".repeat( LONGEST_LINE_LEN );
    return s.substring( FLOWER_START_POS[ flower ], FLOWER_START_POS[ flower + 1 ] );
  }

  private static int flowerFromId( char id ) {
    switch ( id ) {
      case '8': return 7;
      case '7': return 6;
      case '6': return 5;
      case '5': return 4;
      case '4': return 3;
      case '3': return 2;
      case '2': return 1;
      case '1':
      default:  return 0;
    }
  }

  public static void printFlowers( String order ) {
    for ( int line = 0; line < FLOWER_HEIGHT; line++ ) {
      for ( char id : order.toCharArray() )
        System.out.print( flowerLine( flowerFromId( id ), line ) );
      System.out.println();
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    printFlowers( "12345678" );
    printFlowers( "8383765432" );
    printFlowers( "ABC9" );
    printFlowers( "838" );
  }
}
