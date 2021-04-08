package com.tutego.exercise.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmPmToMilitaryTime {

  //tag::solution[]
  private static final Pattern AM_PM_PATTERN =
      Pattern.compile( "(?<hours>\\d\\d?)" +        // hours
                           "(?::(?<minutes>\\d\\d))?" + // minutes
                           "\\s?" +                     // optional whitespace
                           "(?<ampm>[ap])[.]?m[.]?",    // AM/PM
                       Pattern.CASE_INSENSITIVE );

  public static String convertToMilitaryTime( String string ) {
    StringBuffer result = new StringBuffer( string.length() );
    Matcher matcher = AM_PM_PATTERN.matcher( string );

    while ( matcher.find() ) {
      int hours = Integer.parseInt( matcher.group( "hours" ) );
      int minutes = matcher.group( "minutes" ) == null ?
                    0 :
                    Integer.parseInt( matcher.group( "minutes" ) );
      boolean isTimeInPm = "pP".contains( matcher.group( "ampm" ) );
      if ( isTimeInPm && hours < 12 ) hours += 12;
      else if ( !isTimeInPm && hours == 12 ) hours -= 12;
      matcher.appendReplacement( result, String.format( "%02d%02d Uhr", hours, minutes ) );
    }

    matcher.appendTail( result );
    return result.toString();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( convertToMilitaryTime( "Hafen: 11:00 PM, Amüsiermeile: 1:30 a.m.!" ) );
    System.out.println( convertToMilitaryTime( "Aufstehen: 12:00AM, Kuchen backen: 12 PM." ) );
  }
}
