package com.tutego.exercise.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastLine {

  //tag::solution[]
  private static final int MAX_LINE_LENGTH = 100;
  private static final int MAX_NUMBER_OF_BYTES_PER_UTF_8_CHAR = 4;

  private static void printLastLine( String filename ) throws IOException {
    try ( RandomAccessFile file = new RandomAccessFile( filename, "r" ) ) {
      int blockSize = MAX_LINE_LENGTH * MAX_NUMBER_OF_BYTES_PER_UTF_8_CHAR;
      file.seek( file.length() - blockSize );
      byte[] bytes = new byte[ blockSize ];
      file.read( bytes );

      String string = new String( bytes, StandardCharsets.UTF_8 );
      Matcher matcher = Pattern.compile( "([^\\r\\n]*)$" ).matcher( string );
      if ( matcher.find() )
        System.out.println( matcher.group( 1 ) );
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    String filename = "C:\\Users\\Christian\\Downloads\\enable1.txt";
    printLastLine( filename );
  }
}
