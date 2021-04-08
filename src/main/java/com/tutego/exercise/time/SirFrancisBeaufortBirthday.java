package com.tutego.exercise.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class SirFrancisBeaufortBirthday {
  public static void main( String[] args ) {
    //tag::solution-a[]
    LocalDate beaufortBday = LocalDate.of( 1774, Month.MAY, 27 );

    // 1.
    LocalDate beaufortBdayThisYear = beaufortBday.withYear( Year.now().getValue() );

    // 2.
    LocalDate beaufortBdayThisYear2 = LocalDate.of( LocalDate.now().getYear(),
                                                    beaufortBday.getMonth(),
                                                    beaufortBday.getDayOfMonth() );

    // 3.
    LocalDate beaufortBdayThisYear3 = LocalDate.now()
                                               .withMonth( beaufortBday.getMonthValue() )
                                               .withDayOfMonth( beaufortBday.getDayOfMonth() );
    //end::solution-a[]

    System.out.println( beaufortBdayThisYear.equals( beaufortBdayThisYear2 ) );
    System.out.println( beaufortBdayThisYear2.equals( beaufortBdayThisYear3 ) );

    //tag::solution-b[]
    DayOfWeek dayOfWeek = beaufortBdayThisYear.getDayOfWeek();
    System.out.println( dayOfWeek );
    System.out.println( dayOfWeek.getValue() );
    System.out.println( dayOfWeek.getDisplayName( TextStyle.FULL, Locale.GERMANY ) );

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "EEEE" /*, Locale.GERMANY */ );
    System.out.println( beaufortBdayThisYear.format( formatter ) );
    //end::solution-b[]
  }
}
