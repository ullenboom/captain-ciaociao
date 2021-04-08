package com.tutego.exercise.net;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _HtmlClientPost {
  public static void main( String[] args ) {
    Map<String, String> arguments = new HashMap<>();
    arguments.put( "username", "nice" );
    arguments.put( "password", "gummy!bear!" );

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder( URI.create( "https://httpbin.org/post" ) )
        .POST( HttpRequest.BodyPublishers.ofString( encode( arguments ) ) )
        .header( "Content-Type", "application/x-www-form-urlencoded" )
        .build();

    try {
      HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString() );
      System.out.println( response.statusCode() );
      System.out.println( response.body() );
    }
    catch ( IOException | InterruptedException e ) {
      e.printStackTrace();
    }
  }

  static String encode( Map<String, String> arguments ) {
    return arguments.entrySet().stream()
        .map( entry -> URLEncoder.encode( entry.getKey(), StandardCharsets.UTF_8 )
                       + "="
                       + URLEncoder.encode( entry.getValue(), StandardCharsets.UTF_8 ) )
        .collect( Collectors.joining( "&" ) );
  }
}
