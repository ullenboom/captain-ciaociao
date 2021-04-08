package com.tutego.exercise.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AverageDuration {
  public static void main( String[] args ) {
    //tag::solution[]
    String input = "2022-03-12, 20:20 - 2022-03-12, 23:50\n" +
                   "2022-04-01, 21:30 - 2022-04-02, 01:20";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd, HH:mm" );
    Scanner scanner = new Scanner( input ).useDelimiter( " - |\\n" );
    Duration totalDuration = Duration.ZERO;

    int lines;
    for ( lines = 0; scanner.hasNext(); lines++ ) {
      String start = scanner.next();
      String end   = scanner.next();  // potential NoSuchElementException

      // potential DateTimeParseException
      LocalDateTime startDateTime = LocalDateTime.parse( start, formatter );
      LocalDateTime endDateTime   = LocalDateTime.parse( end, formatter );

      Duration duration = Duration.between( startDateTime, endDateTime );
      totalDuration = totalDuration.plus( duration );
    }

    Duration averageDuration = totalDuration.dividedBy( lines );
    System.out.printf( "%d h %02d m", averageDuration.toHours(),
                                      averageDuration.toMinutesPart() );
    //end::solution[]
  }
}
