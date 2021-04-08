package com.tutego.exercise.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

public class ParseDatePattern {
  //tag::solution[]
  public static Optional<LocalDate> parseDate( String string ) {
    LocalDate now = LocalDate.now();

    Collection<Function<String, LocalDate>> parsers = Arrays.asList(
        input -> LocalDate.parse( input, DateTimeFormatter.ofPattern( "yyyy-M-d" ) ),
        input -> LocalDate.parse( input, DateTimeFormatter.ofPattern( "d/M/yyyy" ) ),
        input -> LocalDate.parse( input, DateTimeFormatter.ofPattern( "d/M/yy" ) ),
        input -> input.equalsIgnoreCase( "yesterday" ) ? now.minusDays( 1 ) : null,
        input -> input.equalsIgnoreCase( "today" ) ? now : null,
        input -> input.equalsIgnoreCase( "tomorrow" ) ? now.plusDays( 1 ) : null,
        input -> new Scanner( input ).findAll( "(\\d+) days? ago" )
                                     .map( matchResult -> matchResult.group( 1 ) )
                                     .mapToInt( Integer::parseInt )
                                     .mapToObj( now::minusDays )
                                     .findFirst().orElse( null ) );

    for ( Function<String, LocalDate> parser : parsers ) {
      try { return Optional.of( parser.apply( string ) ); }
      catch ( Exception e ) { /* Ignore */ }
    }
    return Optional.empty();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( parseDate( "2020-10-10" ) );
    System.out.println( parseDate( "2020-12-2" ) );
    System.out.println( parseDate( "1/3/1976" ) );
    System.out.println( parseDate( "1/3/20" ) );
    System.out.println( parseDate( "tomorrow" ) );
    System.out.println( parseDate( "today" ) );
    System.out.println( parseDate( "yesterday" ) );
    System.out.println( parseDate( "1 day ago" ) );
    System.out.println( parseDate( "2234 days ago" ) );
  }
}
