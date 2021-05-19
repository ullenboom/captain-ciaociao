package com.tutego.exercise.thread;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class CaptainsParadeIsInterrupted {

  public static void main( String[] args ) {
    // tag::solution[]
    Runnable winker = () -> {
      while ( ! Thread.currentThread().isInterrupted() ) {
        System.out.printf( "Wink; %s%n", Thread.currentThread() );
        try { TimeUnit.SECONDS.sleep( 2 ); }
        catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
      }
    };

    Runnable flagWaver = () -> {
      while ( ! Thread.currentThread().isInterrupted() ) {
        System.out.printf( "Wave flag; %s%n", Thread.currentThread() );
        try { TimeUnit.SECONDS.sleep( 2 ); }
        catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
      }
    };

    Thread winkerThread    = new Thread( winker );
    Thread flagWaverThread = new Thread( flagWaver );

    winkerThread.start();
    flagWaverThread.start();

    String message = "Submit 'endw' or 'endf' to end the threads or cancel to end main thread";
    for ( String input;
          (input = JOptionPane.showInputDialog( message )) != null; ) {
      if ( input.equalsIgnoreCase( "endw" ) )
        winkerThread.interrupt();
      else if ( input.equalsIgnoreCase( "endf" ) )
        flagWaverThread.interrupt();
    }
    // end::solution[]
  }
}