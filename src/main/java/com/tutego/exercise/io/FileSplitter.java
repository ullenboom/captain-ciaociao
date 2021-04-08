package com.tutego.exercise.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileSplitter {

  //tag::solution[]
  private static final int EOF = -1;

  private static void splitFile( Path source, int size ) throws IOException {
    Objects.requireNonNull( source );
    Objects.checkIndex( size, Integer.MAX_VALUE );

    try ( InputStream fis = Files.newInputStream( source ) ) {
      byte[] buffer = new byte[ size ];
      for ( int cnt = 1, remaining; (remaining = fis.read( buffer )) != EOF; cnt++ )
        try ( OutputStream fos = Files.newOutputStream( Paths.get( source + "." + cnt ) ) ) {
          fos.write( buffer, 0, remaining );
        }
    }
  }

  public static void main( String[] args ) {

    if ( args.length == 0 ) {
      System.err.println( "You need to specify a file name to split the file." );
      return;
    }

    try {
      String filename = args[ 0 ];
      splitFile( Paths.get( filename ), 1_474_560 );
    }
    catch ( IOException e ) {
      System.err.println( e.getMessage() );
    }
  }
  //end::solution[]
}
