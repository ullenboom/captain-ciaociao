package com.tutego.exercise.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WeatherOccurrences {

  //tag::solution[]
  public static class WeatherOccurrence {
    public String weather;
    public int occurrences;
    public int startIndex;

    WeatherOccurrence( String weather, int occurrences, int startIndex ) {
      this.weather = weather;
      this.occurrences = occurrences;
      this.startIndex = startIndex;
    }

    @Override public String toString() {
      return "weather='" + weather + '\'' +
             ", occurrences=" + occurrences + ", startIndex=" + startIndex;
    }
  }

  static WeatherOccurrence longestSequenceOfSameWeather( List<String> weather ) {

    int localMaxOccurrences = 1;
    int localStartIndex     = 0;

    int globalMaxOccurrences = localMaxOccurrences;
    int globalStartIndex     = localStartIndex;

    String recurringElement = weather.get( 0 );

    for ( int i = 1; i < weather.size(); i++ ) {
      String currentElement = weather.get( i );

      if ( Objects.equals( currentElement, recurringElement ) ) {
        localMaxOccurrences++;

        if ( localMaxOccurrences > globalMaxOccurrences ) {
          globalMaxOccurrences = localMaxOccurrences;
          globalStartIndex     = localStartIndex;
        }
      }
      else { // currentElement != recurringElement
        localStartIndex = i;
        localMaxOccurrences = 1;
        recurringElement = currentElement;
      }
    }

    return new WeatherOccurrence(
        weather.get( globalStartIndex ), globalMaxOccurrences, globalStartIndex );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println(
        longestSequenceOfSameWeather( Arrays.asList( "1", "2", "3", "4", "5", "5", "2", "2", "2", "1", "1", "0" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1", "2", "3", "4", "5", "5", "2", "2", "2" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1", "1" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1" ) ) );
  }
}
