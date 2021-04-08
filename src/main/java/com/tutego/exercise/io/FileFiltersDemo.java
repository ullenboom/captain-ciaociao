package com.tutego.exercise.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.tutego.exercise.io.FileFilters.*;

//tag::solution[]
class FileFilters {

  public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and( AbstractFilter other ) {
      return path -> accept( path ) && other.accept( path );
    }

    default AbstractFilter negate() {
      return path -> ! accept( path );
    }

    static AbstractFilter not( AbstractFilter target ) {
      return target.negate();
    }
  }

  /**
   * Tests if a {@code Path} is readable.
   */
  public static final AbstractFilter readable = Files::isReadable;

  /**
   * Tests if a {@code Path} is writable.
   */
  public static final AbstractFilter writable = Files::isWritable;

  /**
   * Tests if a {@code Path} is a regular file.
   */
  public static final AbstractFilter directory = Files::isDirectory;

  /**
   * Tests if a {@code Path} is a regular file.
   */
  public static final AbstractFilter regularFile = Files::isRegularFile;

  /**
   * Tests if a {@code Path} is hidden.
   */
  public static final AbstractFilter hidden = Files::isHidden;

  /**
   * Tests if the file size of a {@code Path} is zero.
   */
  public static final AbstractFilter empty = path -> Files.size( path ) == 0L;

  /**
   * Tests if the file size of a {@code Path} is larger than the specified size.
   */
  public static AbstractFilter largerThan( long size ) {
    return path -> Files.size( path ) > size;
  }

  /**
   * Tests if the file size of a {@code Path} is smaller than the specified size.
   */
  public static AbstractFilter smallerThan( long size ) {
    return path -> Files.size( path ) < size;
  }

  /**
   * Tests if a {@code Path} is older than the specified {@code FileTime}.
   */
  public static AbstractFilter olderThan( FileTime other ) {
    return path -> Files.getLastModifiedTime( path ).compareTo( other ) > 0;
  }

  /**
   * Tests if a {@code Path} has a specified suffix, ignoring case, e.g. ".txt".
   */
  public static AbstractFilter suffix( String suffix, String... more ) {
    return path ->
        Stream.concat( Stream.of( suffix ), Stream.of( more ) )
            .anyMatch( aSuffix -> {
              String filename  = path.toString();
              int suffixLen    = aSuffix.length();
              int suffixOffset = filename.length() - suffixLen;
              return filename.regionMatches( /* ignore case */ true,
                                             suffixOffset, suffix, 0, suffixLen );
            } );
  }

  /**
   * Tests if the content of a {@code Path} starts with a specified sequence of bytes.
   */
  public static AbstractFilter magicNumber( int... bytes ) {
    ByteBuffer byteBuffer = ByteBuffer.allocate( bytes.length );
    for ( int b : bytes ) byteBuffer.put( (byte) b );
    return magicNumber( byteBuffer.array() );
  }

  /**
   * Tests if the content of a {@code Path} starts with a specified sequence of bytes.
   */
  public static AbstractFilter magicNumber( byte... bytes ) {
    return path -> {
      try ( InputStream in = Files.newInputStream( path ) ) {
        byte[] buffer = new byte[ bytes.length ];
        in.read( buffer );
        // If file is smaller than bytes.length, the result is false
        return Arrays.equals( bytes, buffer );
      }
    };
  }

  /**
   * Tests if a {@code Path} regexContains a specified regex.
   */
  public static AbstractFilter regexContains( String regex ) {
    return path -> Pattern.compile( regex ).matcher( path.toString() ).find();
  }

  /**
   * Tests if a filename of a {@code Path} matches a given glob string.
   */
  public static AbstractFilter globMatches( String glob ) {
    return path -> path.getFileSystem().getPathMatcher( "glob:" + glob )
                       .matches( path.getFileName() );
  }
  //end::solution[]
}

public class FileFiltersDemo {
  public static void main( String[] args ) throws IOException {

    Path dir = Paths.get( "C:\\Users\\Christian\\Dropbox\\Homepage\\images\\seminare\\logos" );
    //tag::example[]
    DirectoryStream.Filter<Path> filter =
        regularFile.and( readable )
                   .and( largerThan( 100_000 ) )
                   .and( magicNumber( 0x89, 'P', 'N', 'G' ) )
                   .and( globMatches( "*.png" ) )
                   .and( regexContains( "[-]" ) );

    try ( DirectoryStream<Path> entries =Files.newDirectoryStream( dir, filter ) ) {
      entries.forEach( System.out::println );
    }
    //end::example[]
  }
}