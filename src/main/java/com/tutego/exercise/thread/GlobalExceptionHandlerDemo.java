package com.tutego.exercise.thread;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

//tag::solution[]
enum GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
  INSTANCE;

  @Override public void uncaughtException( Thread thread, Throwable uncaughtException ) {
    Logger logger = Logger.getLogger( getClass().getSimpleName() );
    logger.log( Level.SEVERE, uncaughtException.getMessage() + " from thread " + thread, thread );
  }
}

public class GlobalExceptionHandlerDemo {
  public static void main( String[] args ) throws Exception {
    Thread.setDefaultUncaughtExceptionHandler( GlobalExceptionHandler.INSTANCE );

    Thread zeroDivisor = new Thread( () -> System.out.println( 1 / 0 ) );
    zeroDivisor.start();

    Thread indexOutOfBound = new Thread( () -> System.out.println( (new int[0])[1] ) );
    indexOutOfBound.setUncaughtExceptionHandler( ( t, e ) -> {} );
    indexOutOfBound.start();

    new URL( "captain" );
  }
}
//end::solution[]
