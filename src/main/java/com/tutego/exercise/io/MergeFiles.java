package com.tutego.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class MergeFiles {

  //tag::solution[]
  public static void mergeFiles( Path main, Path... temp ) throws IOException {

    Iterable<Path> paths = Stream.concat( Stream.of( main ), Stream.of( temp ) )::iterator;
    Collection<String> words = new LinkedHashSet<>();

    for ( Path path : paths )
      try ( Stream<String> lines = Files.lines( path ) ) {
        lines.forEach( words::add );
      }

    Files.write( main, words );
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    Path master = Paths.get( System.getProperty( "user.dir" ), "master.txt" );
    Path temp1  = Paths.get( System.getProperty( "user.dir" ), "temp1.txt" );
    Path temp2  = Paths.get( System.getProperty( "user.dir" ), "temp2.txt" );
    mergeFiles( master, temp1, temp2 );
  }
}
