package com.tutego.exercise.io;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XorFractal {

  public static void main( String[] args ) {
    //tag::solution[]
    final String filename = "xorpic.html";
    try {
      try ( Writer out = Files.newBufferedWriter( Paths.get( filename ) );
            PrintWriter printer = new PrintWriter( out ) ) {

        printer.println( "<!DOCTYPE html>" );
        printer.println( "<html><body><svg width=\"256\" height=\"256\">" );

        for ( int x = 0; x < 256; x++ )
          for ( int y = 0; y < 256; y++ )
            printer.printf(
                "<rect x=\"%d\" y=\"%d\" width=\"1\" height=\"1\" style=\"fill:rgb(0,%d,0);\" />",
                x, y, x ^ y );

        printer.println( "</svg></body></html>" );
      }
      Desktop.getDesktop().open( new File( filename ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
  //end::solution[]
}
