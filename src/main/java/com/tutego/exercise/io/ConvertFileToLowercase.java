package com.tutego.exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertFileToLowercase {

  //tag::solution[]
  private static final int EOF = -1;

  static void convertFileToLowercase( String source, String target ) throws IOException {
    convertFileToLowercase( Paths.get( source ), Paths.get( target ) );
  }

  static void convertFileToLowercase( Path source, Path target ) throws IOException {

    try ( BufferedReader reader = Files.newBufferedReader( source );
          BufferedWriter writer = Files.newBufferedWriter( target ) ) {
      for ( int c; (c = reader.read()) != EOF; )
        writer.write( Character.toLowerCase( (char) c ) );
    }
  }
  //end::solution[]
}
