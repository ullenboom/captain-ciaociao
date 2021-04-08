package com.tutego.exercise.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class LongestLineInFile {
  public static void main( String[] args ) {
    //tag::solution[]
    String filename = "src\\main\\resources\\com\\tutego\\exercises\\util\\family-names.txt";
    try {
      Collection<String> lines = Files.readAllLines( Paths.get( filename ) );
      String first = "", second = "";
      for ( String line : lines ) {
        if ( line.length() > first.length() ) {
          second = first;
          first = line;
        }
        else if ( line.length() > second.length() )
          second = line;
      }
      System.out.println( first + ", " + second );
    }
    catch ( IOException e ) {
      System.err.println( "Error reading file " + new File( filename ).getAbsolutePath() );
      e.printStackTrace();
    }
    //end::solution[]
  }
}
