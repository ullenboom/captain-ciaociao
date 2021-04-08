package com.tutego.exercise.thread;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

//tag::solution[]
public class FileChangeWatcher implements Runnable {

  private final Path path;
  private final Consumer<Path> callback;

  public FileChangeWatcher( String filename, Consumer<Path> callback ) {
    this.callback = Objects.requireNonNull( callback );
    path = Paths.get( filename );
  }

  @Override
  public void run() {
    try {
      FileTime oldLastModified = Files.getLastModifiedTime( path );

      while ( true ) {
        TimeUnit.MILLISECONDS.sleep( 500 );

        FileTime lastModified = Files.getLastModifiedTime( path );
        if ( ! oldLastModified.equals( lastModified ) ) {
          callback.accept( path );
          oldLastModified = lastModified;
        }
      }
    }
    catch ( Exception e ) {
      // Catch any exception and wrap in a runtime exception
      throw new RuntimeException( e );
    }
  }

  public static void main( String[] args ) {
    Consumer<Path> callback = path -> System.out.println( "File changed " + path );
    new Thread( new FileChangeWatcher( "c:/file.txt", callback ) ).start();
  }
}
//end::solution[]
