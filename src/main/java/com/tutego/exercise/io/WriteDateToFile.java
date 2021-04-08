package com.tutego.exercise.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class WriteDateToFile {

  public static void main( String[] args ) {
    //tag::solution[]
    String fileName = "current-date.txt";
    try ( PrintWriter writer = new PrintWriter( fileName ) ) {
      writer.write( LocalDateTime.now().toString() );
    }
    catch ( FileNotFoundException e ) {
      System.err.println( "Can't create file " + fileName );
    }
    //end::solution[]
  }
}
