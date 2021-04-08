package com.tutego.exercise.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DosDir {
  public static void main( String[] args ) {
    try {
      Path dir = Paths.get( "." );
      listDirectory( dir );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  //tag::solution[]
  private final static DateTimeFormatter ddMMyyyy_hhmm =
      DateTimeFormatter.ofPattern( "dd.MM.yyyy  hh:mm" );

  static void listDirectory( Path dir ) throws IOException {
    try ( DirectoryStream<Path> entries = Files.newDirectoryStream( dir ) ) {
      for ( Path path : entries ) {
        Instant instant = Files.getLastModifiedTime( path ).toInstant();
        LocalDateTime dateTime = LocalDateTime.ofInstant( instant, ZoneId.systemDefault() );
        String formattedDateTime = dateTime.format( ddMMyyyy_hhmm );
        String dirLength = Files.isDirectory( path ) ? "<DIR>         "
                                                     : String.format( "%,14d", Files.size( path ) );
        String filename = path.getFileName().toString();
        System.out.printf( "%s   %s %s%n", formattedDateTime, dirLength, filename );
      }
    }
    //end::solution[]
  }
}
