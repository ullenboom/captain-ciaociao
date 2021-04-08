package com.tutego.exercise.thread;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//tag::solution[]
public class Sleep {

  static long parseSleepArgument( String arg ) {
    Matcher matcher  = Pattern.compile( "(\\d+)(\\D)?" ).matcher( arg );
    boolean anyMatch = matcher.find();

    // Check if any match at all or gibberish
    if ( ! anyMatch ) {
      System.err.printf( "sleep: invalid time interval ‘%s’%n", arg );
      System.exit( 2 );
    }

    // Found at least a number, but maybe too huge to parse
    long seconds = 0;
    try { seconds = Long.parseLong( matcher.group( 1 ) ); }
    catch ( NumberFormatException e ) {
      System.err.printf( "sleep: interval to huge ‘%s’%n", arg );
      System.exit( 3 );
    }

    // Also a unit?
    String unit = matcher.group( 2 );
    if ( unit == null )
      return seconds;

    switch ( unit ) {
      case "s": break;
      case "m": seconds = TimeUnit.MINUTES.toSeconds( seconds ); break;
      case "h": seconds = TimeUnit.HOURS.toSeconds( seconds ); break;
      case "d": seconds = TimeUnit.DAYS.toSeconds( seconds ); break;
      default:
        System.err.printf( "sleep: invalid interval unit ‘%s’%n", arg );
        System.exit( 4 );
    }

    return seconds;
  }

  public static void main( String[] args ) {
    if ( args.length == 0 ) {
      System.err.println( "sleep: missing operand" );
      System.exit( 1 );
    }

    long seconds = 0;
    for ( String arg : args )
      seconds += parseSleepArgument( arg );

    try { TimeUnit.SECONDS.sleep( seconds ); }
    catch ( InterruptedException e ) { /* intentionally empty */ }
  }
}
//end::solution[]

class SleepTest {
  public static void main( String[] args ) {
    //    System.out.println( Sleep.parseSleepArgument( "1222" ) );
    //    System.out.println( Sleep.parseSleepArgument( "1s" ) );
    //    System.out.println( Sleep.parseSleepArgument( "8m46s" ) );
    //    System.out.println( Sleep.parseSleepArgument( "1h" ) );
    //    System.out.println( Sleep.parseSleepArgument( "1d" ) );
    //    System.out.println( Sleep.parseSleepArgument( "122222222222222222222222222222222222222" ) );
    //    System.out.println( Sleep.parseSleepArgument( "x" ) );
    //        System.out.println( Sleep.parseSleepArgument( "12x" ) );
    System.out.println( System.currentTimeMillis() / 1000 );
    Sleep.main( new String[]{ "1", "2s" } );
    System.out.println( System.currentTimeMillis() / 1000 );
  }
}