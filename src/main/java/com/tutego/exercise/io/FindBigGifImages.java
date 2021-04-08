package com.tutego.exercise.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UncheckedIOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FindBigGifImages {

  public static void main( String[] args ) {
    String name = "D:/Dropbox/Homepage/javabuch/aufgaben/solutions/target/classes/image/";
    //tag::solution[]
    Path directory = Paths.get( name );
    try {
      try ( DirectoryStream<Path> files = Files.newDirectoryStream( directory,
                                                                    FindBigGifImages::isGifAndWidthGreaterThan1024 ) ) {
        files.forEach( System.out::println );
      }
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    //end::solution[]
  }

  private static final byte[] GIF87aGIF89a = "GIF87aGIF89a".getBytes();
  private static boolean isGifAndWidthGreaterThan1024( Path entry ) {
    if ( ! Files.isRegularFile( entry ) || !Files.isReadable( entry ) )
      return false;

    try ( RandomAccessFile raf = new RandomAccessFile( entry.toFile(), "r" ) ) {
      byte[] bytes = new byte[ 8 ];
      raf.read( bytes );

      if ( ! Arrays.equals( bytes, 0, 6, GIF87aGIF89a, 0, 6 ) &&
           ! Arrays.equals( bytes, 0, 6, GIF87aGIF89a, 6, 12 ) )
        return false;

      int width = Byte.toUnsignedInt( bytes[ 6 ] ) + (Byte.toUnsignedInt( bytes[ 7 ] ) << 8);
      return width > 1024;
    }
    catch ( IOException e ) {
      throw new UncheckedIOException( e );
    }
  }
}
