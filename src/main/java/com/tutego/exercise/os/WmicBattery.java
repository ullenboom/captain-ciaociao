package com.tutego.exercise.os;

import java.io.*;
import java.util.OptionalInt;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class WmicBattery {

  //tag::solution[]
  static OptionalInt wmicBattery( String name ) {
    try {
      String[] command = { "CMD", "/C", "wmic", "path", "win32_battery", "get", name };
      Process process = new ProcessBuilder( command ).start();
      try ( InputStream is = process.getInputStream();
            Reader isr = new InputStreamReader( is );
            Stream<String> stream = new BufferedReader( isr ).lines() ) {
        return stream.map( String::trim )
                     .filter( s -> s.matches( "\\d+" ) )
                     .mapToInt( Integer::parseInt )
                     .findFirst();
      }
    }
    catch ( IOException e ) {
      Logger.getLogger( WmicBattery.class.getName() ).info( e.toString() );
      return OptionalInt.empty();
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    //tag::example[]
    wmicBattery( "EstimatedChargeRemaining" ).ifPresentOrElse(
        value -> System.out.printf( "Estimated charge remaining: %d %%%n", value ),
        () -> System.out.println( "No instances available." ) );

    wmicBattery( "EstimatedRunTime" ).ifPresentOrElse(
        minutes -> System.out.printf(
            minutes == 0X4444444 ?
            "Charging" :
            "Estimated run time: %d:%02d h (%d minutes)%n", minutes / 60, minutes % 60,minutes ),
        () -> System.out.println( "No instances available." ) );
    //end::example[]
  }
}
