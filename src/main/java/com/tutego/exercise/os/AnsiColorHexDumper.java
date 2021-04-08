package com.tutego.exercise.os;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnsiColorHexDumper {
  //tag::constants[]
  public static final String ANSI_RED    = "\u001B[31m";
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static final String ANSI_BLUE   = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN   = "\u001B[36m";
  public static final String ANSI_RESET  = "\u001B[0m";
  //end::constants[]

  //tag::solution[]
  private static final int EOF = -1;
  private static final int HEX_PER_LINE = 32;
  private static void printColorfulHexDump( Path path ) throws IOException {
    try ( InputStream is = new BufferedInputStream( Files.newInputStream( path ) ) ) {
      for ( int i = 0, b; (b = is.read()) != EOF; i++ ) {
        String color = b == 0 ? ANSI_GREEN :
                       b == 0xFF ? ANSI_RED :
                       Character.isDigit( b ) ? ANSI_PURPLE :
                       Character.isLetter( b ) ? ANSI_BLUE :
                       b == ' ' ? ANSI_CYAN :
                       ANSI_RESET;
        System.out.printf( "%s%02X ", color, b );
        if ( i % HEX_PER_LINE == (HEX_PER_LINE - 1) )
          System.out.println();
      }
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "pom.xml" );
    printColorfulHexDump( path );
  }
}
