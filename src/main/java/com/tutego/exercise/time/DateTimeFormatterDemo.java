package com.tutego.exercise.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterDemo {
  public static void main( String[] args ) {
    //tag::solution[]
    LocalDate date = LocalDate.of( Year.now().getValue(), Month.SEPTEMBER, 19 );
    System.out.println( date );

    DateTimeFormatter formatterShort  = DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT );
    DateTimeFormatter formatterMedium = DateTimeFormatter.ofLocalizedDate( FormatStyle.MEDIUM );
    DateTimeFormatter formatterLong   = DateTimeFormatter.ofLocalizedDate( FormatStyle.LONG );
    DateTimeFormatter formatterFull   = DateTimeFormatter.ofLocalizedDate( FormatStyle.FULL );

    System.out.println( date.format( formatterShort ) );
    System.out.println( date.format( formatterMedium ) );
    System.out.println( date.format( formatterLong ) );
    System.out.println( date.format( formatterFull ) );

    System.out.println( date.format( formatterShort.withLocale( Locale.CANADA_FRENCH ) ) );
    System.out.println( date.format( formatterMedium.withLocale( Locale.CHINESE ) ) );
    System.out.println( date.format( formatterLong.withLocale( Locale.ITALIAN ) ) );
    System.out.println( date.format( formatterFull.withLocale( new Locale( "th" ) ) ) );
    //end::solution[]
  }
}
