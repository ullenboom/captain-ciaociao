package com.tutego.exercise.io;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class DailyWordsOfWisdom {
  public static void main( String[] args ) {
    //tag::solution[]
    try {
      String html = "<!DOCTYPE html><html><body>" +
          "›The things we steal tell us who we are.‹ - Thomas von Tew" +
          "</body></html>";
      Path tmpPath = Files.createTempFile( "wisdom", ".html" );
      Files.write( tmpPath, Collections.singleton( html ) );
      Desktop.getDesktop().open( tmpPath.toFile() );
    }
    catch ( IOException e ) {
      System.err.println( "Couldn't write HTML file in temp folder or open file" );
      e.printStackTrace();
    }
    //end::solution[]
  }
}
