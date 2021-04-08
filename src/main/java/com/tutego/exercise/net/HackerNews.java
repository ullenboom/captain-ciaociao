package com.tutego.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class HackerNews {

  //tag::solution-a[]
  private static final HttpClient client = HttpClient.newHttpClient();

  public static long[] hackerNewsTopStories() {
    HttpRequest request = HttpRequest
        .newBuilder( URI.create( "https://hacker-news.firebaseio.com/v0/topstories.json" ) )
        .timeout( Duration.ofSeconds( 5 ) )
        .build();

    try {
      HttpResponse<InputStream> response =
          client.send( request, HttpResponse.BodyHandlers.ofInputStream() );
      Scanner scanner = new Scanner( response.body() ).useDelimiter( "[,\\[\\]]" );
      return scanner.tokens().mapToLong( Long::parseLong ).toArray();
    }
    catch ( IOException | InterruptedException e ) {
      e.printStackTrace();
    }
    return new long[ 0 ];
  }
  //end::solution-a[]

  //tag::solution-b[]
  public static String news( long id ) {
    HttpRequest request = HttpRequest
        .newBuilder( URI.create( "https://hacker-news.firebaseio.com/v0/item/" + id + ".json" ) )
        .timeout( Duration.ofSeconds( 5 ) )
        .build();

    try {
      return client.send( request, HttpResponse.BodyHandlers.ofString() ).body();
    }
    catch ( IOException | InterruptedException e ) {
      e.printStackTrace();
      return "";
    }
  }
  //end::solution-b[]

  public static void main( String[] args ) {
    //tag::example[]
    System.out.println( Arrays.toString( hackerNewsTopStories() ) );
    String newsInJson = news( 24857356 );
    System.out.println( newsInJson );
    //end::example[]
  }
}

//     HttpRequest request = HttpRequest.newBuilder()
//        .uri( URI.create( "http://tutego.de/javabuch/aufgaben/bond.txt" ) )