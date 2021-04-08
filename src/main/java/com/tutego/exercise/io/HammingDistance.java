package com.tutego.exercise.io;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HammingDistance {

  //tag::solution[]
  public static long distance( Path file1, Path file2 ) throws IOException {

    long filesize1 = Files.size( file1 );
    long filesize2 = Files.size( file2 );

    if ( filesize1 != filesize2 )
      throw new IllegalStateException(
          String.format( "File size is not equal, but %d for %s and %d for %s",
                         filesize1, file1, filesize2, file2 ) );
    long result = 0;

    try ( Reader input1 = Files.newBufferedReader( file1 );
          Reader input2 = Files.newBufferedReader( file2 ) ) {

      for ( int i = 0; i < filesize1; i++ )
        if ( input1.read() != input2.read() )
          result++;
    }

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException, URISyntaxException {
    String filename1 = "ToArris HumanToErrisPirate1.txt";
    String filename2 = "ToArris HumanToErrisPirate2.txt";
    Path file1 = Path.of( HammingDistance.class.getResource( filename1 ).toURI() );
    Path file2 = Path.of( HammingDistance.class.getResource( filename2 ).toURI() );
    System.out.println( distance( file1, file2 ) );
  }
}
