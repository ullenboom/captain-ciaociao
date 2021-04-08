package com.tutego.exercise.util;

import java.util.Optional;
import java.util.Properties;

class IniParser {
  public static void main( String[] args ) {
    String string = "date=9.6.2020\n" +
        "garbage\n" +
        "[personal]\n" +
        "name=CiaoCiao\n" +
        "rank=Captain\n" +
        "# Some details\n" +
        "[professional.detail]\n" +
        "job=pirate\n" +
        "tough_cookie=\n" +
        "garbage\n";
    Properties properties = parseIni( string );
    properties.list( System.out );
  }

  //tag::solution[]
  public static Properties parseIni( String string ) {
    Properties properties = new Properties();
    Optional<String> section = Optional.empty();

    for ( String line : string.split( "\n" ) ) {
      line = line.trim();
      if ( isComment( line ) )
        continue;
      if ( isStartOfSegment( line ) )
        section = Optional.of( line.substring( 1, line.length() - 1 ) );
      else {
        if ( ! containsAssignment( line ) ) {
          System.err.printf( "Line '%s' without a assignment in '%s' section %n",
                             line, section.orElse( "global" ) );
          continue;
        }
        addAssignmentToProperties( section, line, properties );
      }
    }
    return properties;
  }

  private static boolean isComment( String line ) {
    return line.isEmpty() || line.startsWith( ";" ) || line.startsWith( "#" );
  }

  private static boolean isStartOfSegment( String line ) {
    return line.startsWith( "[" ) && line.endsWith( "]" );
  }

  private static boolean containsAssignment( String line ) {
    return line.indexOf( '=' ) >= 0;
  }

  private static void addAssignmentToProperties( Optional<String> section, String line,
                                                 Properties target ) {
    String[] tokens = line.split( "\\s*=\\s*", 2 );
    String key   = section.map( s -> s + "." ).orElse( "" ) + tokens[ 0 ];
    String value = tokens.length == 1 ? "" : tokens[ 1 ];
    Object old   = target.setProperty( key, value );
    if ( old != null )
      System.err.printf( "Duplicated key '%s' in section '%s'%n", tokens[ 0 ], section );
  }
  //end::solution[]
}