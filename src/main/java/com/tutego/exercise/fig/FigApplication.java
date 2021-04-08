package com.tutego.exercise.fig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

//tag::solution[]
public class FigApplication {

  public static void main( String[] args ) throws IOException, URISyntaxException {

    FigParser parser = new FigParser();
    URI uri = FigApplication.class.getResource( "big.flf" ).toURI();
    FigAlphabet alphabet = parser.parseFile( Paths.get( uri ) );

//    System.out.println( alphabet );
    
//    FigAlphabet alphabet = new FigAlphabet();
//    FigGlyph zero = new FigGlyph(
//            "   ___  \r\n" + 
//            "  / _ \\ \r\n" + 
//            " | | | |\r\n" + 
//            " | | | |\r\n" + 
//            " | |_| |\r\n" + 
//            "  \\___/ \r\n" + 
//            "        \r\n" + 
//            "        ");
//    
//    for ( char c = ' '; c < 127; c++ ) {
//      alphabet.put( c, zero );
//    }

    FigLayouter layouter = new FigLayouter();
    String s = layouter.layoutHorizontal( "Hallo Welt", alphabet );
    System.out.println( s );
  }
}

class FigAlphabet {

  private static final int FIRST_CHAR = ' ';
  private static final int LAST_CHAR  = '~';

  private final Map<Character, FigGlyph> glyphs = new HashMap<>();
  private int height;

  public FigAlphabet( int height ) {
    this.height = height;
  }

  public FigAlphabet put( char character, FigGlyph glyph ) {
    Objects.requireNonNull( glyph );

    glyphs.put( character, glyph );
    return this;
  }

  /**
   * @param character input.
   * @return glyph for character or null if no glyph exists.
   */
  public FigGlyph glyph( char character ) {
    return glyphs.get( character );
  }

  public int height() {
    return height;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    for ( char c = FIRST_CHAR; c <= LAST_CHAR; c++ ) {
      result.append( glyph( c ).format() );
      result.append( "\n" );
    }

    return result.toString();
  }
}

class FigGlyph {

  private final List<String> glyph;

  public FigGlyph( String glyph ) {
    this.glyph = Arrays.asList( glyph.split( "\\r\\n" ) );
  }

  public FigGlyph( List<String> lines ) {
    this.glyph = lines;
  }

  public String format() {
    return String.join( "\n", glyph );
  }

  public String lineAt( int line ) {
    return glyph.get( line );
  }
}

class FigParser {

  public FigAlphabet parseFile( Path path ) throws IOException {

    FigAlphabet result;

    try ( Scanner scanner = new Scanner( path ) ) {

      // e.g. flf2a$ 8 6 59 15 10 0 24463 153
      String header = scanner.nextLine();
      String[] headerTokens = header.split( " " );
      int height = Integer.parseInt( headerTokens[ 1 ] );
      int noOfCommentLines = Integer.parseInt( headerTokens[ 5 ] );

      result = new FigAlphabet( height );

      // Read over comment lines
      for ( int i = 0; i < noOfCommentLines; i++ )
        scanner.nextLine();

      for ( char c = ' '; c < 127; c++ ) {
        List<String> lines = new ArrayList<>( height );

        for ( int line = 0; line < height; line++ )
          lines.add( scanner.nextLine().replace( "@", "" ).replace( '$', ' ' ) );

        result.put( c, new FigGlyph( lines ) );
      }
    }

    return result;
  }
}

class FigLayouter {

  public String layoutHorizontal( String string, FigAlphabet alphabet ) {

    StringBuilder result = new StringBuilder( string.length() * 100 );

    for ( int lineNumber = 0; lineNumber < alphabet.height(); lineNumber++ ) {
      for ( char c : string.toCharArray() ) {
        FigGlyph glyph = alphabet.glyph( c );
        if ( glyph == null ) continue;
        result.append( glyph.lineAt( lineNumber ) );
      }
      result.append( "\n" );
    }
    return result.toString();
  }
}
//end::solution[]
