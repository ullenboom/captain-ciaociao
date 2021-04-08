package com.tutego.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClone {

  //tag::solution[]
  private static final String COPY_OF          = "Copy of %s";
  private static final String NUMBERED_COPY_OF = "Copy (%d) of %s";

  public static void cloneFile( Path path ) throws IOException {

    if ( Files.isDirectory( path ) )
      throw new IllegalArgumentException( "Path has to be a file but was a directory" );

    Path parent   = path.getParent();
    Path filename = path.getFileName();

    Path copyPath = parent.resolve( String.format( COPY_OF, filename ) );

    for ( int i = 2; Files.exists( copyPath ); i++ )
      copyPath = parent.resolve( String.format( NUMBERED_COPY_OF, i, filename ) );

    Files.copy( path, copyPath );
  }
  //end::solution[]

  public static void main( String[] args ) {
    try {
      cloneFile( Paths.get( "c:/test.txt" ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}
