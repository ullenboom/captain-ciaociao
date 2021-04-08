package com.tutego.exercise.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Holidays {
  public static void main( String[] args ) {
    //tag::solution[]
    NavigableMap<LocalDate, String> dates = new TreeMap<>();
    dates.put( LocalDate.of( 2020, Month.JANUARY, 1 ), "Neujahr" );
    dates.put( LocalDate.of( 2020, Month.APRIL, 10 ), "Karfreitag" );
    dates.put( LocalDate.of( 2020, Month.MAY, 1 ), "Tag der Arbeit" );
    dates.put( LocalDate.of( 2020, Month.JUNE, 1 ), "Pfingstmontag" );
    dates.put( LocalDate.of( 2020, Month.OCTOBER, 3 ), "Tag der Deutschen Einheit" );
    dates.put( LocalDate.of( 2020, Month.NOVEMBER, 1 ), "Allerheiligen" );
    dates.put( LocalDate.of( 2020, Month.JULY, 1 ), "Pfingstmontag" );
    dates.put( LocalDate.of( 2020, Month.DECEMBER, 25 ), "1. Weihnachtsfeiertag" );
    dates.put( LocalDate.of( 2020, Month.DECEMBER, 26 ), "2. Weihnachtsfeiertag" );
    dates.put( LocalDate.of( 2021, Month.JANUARY, 1 ), "Neujahr" );
    dates.put( LocalDate.of( 2021, Month.APRIL, 20 ), "Karfreitag" );

    System.out.println( dates.firstEntry() );
    System.out.println( dates.lastEntry() );

    LocalDate festiveSeasonStart = LocalDate.of( 2020, Month.DECEMBER, 23 );
    LocalDate festiveSeasonEnd   = LocalDate.of( 2021, Month.JANUARY, 6 );

    System.out.println( dates.higherEntry( festiveSeasonEnd ) );

    SortedMap<LocalDate, String> festiveSeason =
        dates.subMap( festiveSeasonStart, true, festiveSeasonEnd, true );

    System.out.printf( "%d Feiertage:%n", festiveSeason.size() );
    festiveSeason.forEach( ( date, name ) -> System.out.printf( "%s am %s%n", name, date ) );

    festiveSeason.clear();

    System.out.println( dates );
    //end::solution[]
  }
}