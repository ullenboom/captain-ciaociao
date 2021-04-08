package com.tutego.exercise.stream;

import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class DecrementNumbers {

  //tag::solution[]
  private static String decrementNumbers( Reader input ) {
    return new Scanner( input )
        .findAll( "10|[1-9]" )          // Stream<MatchResult>
        .map( MatchResult::group )      // Stream<String>
        .mapToInt( Integer::parseInt )  // IntStream
        .map( Math::decrementExact )    // IntStream
        .mapToObj( Integer::toString )  // Stream<String>
        .collect( Collectors.joining( ", " ) );
  }
  //end::solution[]

  public static void main( String[] args ) {
    Reader input = new StringReader( "-1" );
    String string = decrementNumbers( input );
    System.out.println( string );
  }
}
