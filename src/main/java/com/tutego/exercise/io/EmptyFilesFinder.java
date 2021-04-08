package com.tutego.exercise.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Consumer;

public class EmptyFilesFinder {

  //tag::solution[]
  public static void findEmptyTextFiles( Path base, Consumer<Path> callback ) throws IOException {
    class PrintingFileVisitor extends SimpleFileVisitor<Path> {
      @Override
      public FileVisitResult visitFile( Path visitedFile, BasicFileAttributes fileAttributes ) {
        if ( visitedFile.toString().toLowerCase().endsWith( ".txt" )
            && fileAttributes.size() == 0L )
          callback.accept( visitedFile );
        return FileVisitResult.CONTINUE;
      }
    }
    Files.walkFileTree( base, new PrintingFileVisitor() );
  }
  //end::solution[]

  public static void main( String[] args ) {
    String userHome = System.getProperty( "user.home" );
    try {
      findEmptyTextFiles( Paths.get( userHome ), System.out::println );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}