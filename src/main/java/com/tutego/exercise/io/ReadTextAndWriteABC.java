package com.tutego.exercise.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTextAndWriteABC {

  //tag::solution[]
  private static final String VALID_MUSICAL_NOTES =
      "C, D, E, F, G, A, B, C D E F G A B c d e f g a b c' d' e' f' g' a' b'";

  public static void readTextAndWriteAsABC( String source, String target ) {
    try ( Scanner in      = new Scanner( Paths.get( source ) );
          PrintWriter out = new PrintWriter( target ) ) {

      out.println( "M:C" );
      out.println( "L:1/4" );
      out.println( "K:C" );

      String[] sortedMusicalNotes = VALID_MUSICAL_NOTES.split( " " );
      Arrays.sort( sortedMusicalNotes );

      while ( in.hasNextLine() ) {
        String line = in.nextLine();
        if ( Arrays.binarySearch( sortedMusicalNotes, line ) >= 0 ) {
          out.print( line );
          out.print( ' ' );
        }
      }
      out.println();
    }
    catch ( IOException e ) {
      System.err.println( "Cannot convert text file due to an input/output error" );
      e.printStackTrace();
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException, URISyntaxException {
    String filename = "musical-notes.txt";
    String source = Paths.get( ReadTextAndWriteABC.class.getResource( filename ).toURI() ).toString();
    String target = Files.createTempFile( "musical-note", ".txt" ).toString();
    System.out.println( source );
    System.out.println( target );
    readTextAndWriteAsABC( source, target );
  }
}