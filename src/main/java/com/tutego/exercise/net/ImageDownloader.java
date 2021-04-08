package com.tutego.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class ImageDownloader {
  //tag::solution[]
  public static void downloadImage( URL url ) throws IOException {
    try ( InputStream inputStream = url.openStream() ) {
      String filename = url.toString().replaceAll( "[^a-zA-Z0-9_.-]", "_" );
      Files.copy( inputStream, Paths.get( filename ), StandardCopyOption.REPLACE_EXISTING );
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    URL url = new URL(
        "https://upload.wikimedia.org/wikipedia/en/thumb/e/ef/Captain_Future_anime_screenshot.jpg/230px-Captain_Future_anime_screenshot.jpg" );
    downloadImage( url );
  }
}
