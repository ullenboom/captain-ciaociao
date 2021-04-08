package com.tutego.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WikipediaImageLoader {
  public static void main( String[] args ) throws IOException {
    //tag::solution[]
    String url = "https://de.wikipedia.org/wiki/Wikipedia:Hauptseite";
    Document doc = Jsoup.parse( new URL( url ), 1000 /* ms */ );

    for ( Element img : doc.select( "img[src~=(?i)\\.(png|gif|jpg)]" ) ) {
      String imgUrl = img.absUrl( "src" );
      String filename = imgUrl.replaceAll( "[^a-zA-Z0-9_.-]", "_" );
      try ( InputStream imgStream = new URL( imgUrl ).openStream() ) {
        Files.copy( imgStream, Paths.get( filename ),
                    StandardCopyOption.REPLACE_EXISTING );
      }
    }
  }
  //end::solution[]
}
