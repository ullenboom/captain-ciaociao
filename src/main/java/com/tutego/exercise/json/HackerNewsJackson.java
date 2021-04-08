package com.tutego.exercise.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class HackerNewsJackson {

  static class HackerNewsViaJacksonUrl {
    //tag::solution-a[]
    public static Map<?, ?> news( long id ) {
      try {
        URI uri = URI.create( "https://hacker-news.firebaseio.com/v0/item/" + id + ".json" );
        return new ObjectMapper().readValue( uri.toURL(), Map.class );
      }
      catch ( IOException e ) {
        return Collections.emptyMap();
      }
    }
    //end::solution-a[]
  }

  static class HackerNewsViaHttpClient {
    //tag::solution-b[]
    public static Map<?, ?> news( long id ) {
      HttpClient client = HttpClient.newHttpClient();
      ObjectMapper mapper = new ObjectMapper();

      HttpRequest request = HttpRequest
          .newBuilder( URI.create( "https://hacker-news.firebaseio.com/v0/item/" + id + ".json" ) )
          .timeout( Duration.ofSeconds( 5 ) )
          .build();

      try {
        InputStream body = client.send( request, HttpResponse.BodyHandlers.ofInputStream() ).body();
        return mapper.readValue( body, Map.class );
      }
      catch ( IOException | InterruptedException e ) {
        return Collections.emptyMap();
      }
    }
    //end::solution-b[]
  }

  public static void main( String[] args ) {
    System.out.println( HackerNewsViaJacksonUrl.news( 24857356 ).get( "title" ) );
    System.out.println( HackerNewsViaHttpClient.news( 111111 ).get( "title" ) );
  }
}
