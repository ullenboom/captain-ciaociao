package com.tutego.exercise.lang;

// http://www.artists.de/281604-hommage-au-pointillismus

public class SoManyCircles {

  static void circleSvg( int x, int y, int offset ) {
    System.out.printf( "<circle cx=\"%d\" cy=\"%d\" r=\"7\" fill=\"%s\" />%n",
                       x + offset, y, randomColor() );
  }

  static void startSvg() {
    System.out.println( "<svg height=\"1000\" width=\"1000\" style='background-color: #5C5B57'>" );
  }

  static void endSvg() {
    System.out.println( "</svg>" );
  }

  static String randomColor() {
    switch ( (int) (Math.random() * 6) ) {
      case 0: return "#137546";
      case 1: return "#AB1912";
      case 2: return "#9F7B07";
      case 3: return "#110F14";
      case 4: return "#97948F";
      default : return "#004F88";
    }
  }

  public static void main( String[] args ) {

    final int DISTANCE = 20;
    final int MARGIN = 2 * DISTANCE;

    startSvg();
    for ( int y = MARGIN; y <= 1000 - MARGIN; y = y + DISTANCE ) {
      int offset = y % (2 * DISTANCE) == 0 ? 0 : DISTANCE / 2;

      for ( int x = MARGIN; x < 1000 - MARGIN; x = x + DISTANCE ) {
        circleSvg( x, y, offset );
      }
    }
    endSvg();
  }
}
