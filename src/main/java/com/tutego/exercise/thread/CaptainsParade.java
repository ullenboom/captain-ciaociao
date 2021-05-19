package com.tutego.exercise.thread;

public class CaptainsParade {

  public static void main( String[] args ) {
    //tag::solution[]
    class Wink implements Runnable {
      @Override public void run() {
        for ( int i = 0; i < 50; i++ )
          System.out.printf( "Wink; %s%n", Thread.currentThread() );
      }
    }

    Runnable winker = new Wink();
    Runnable flagWaver = () -> {
      for ( int i = 0; i < 50; i++ )
        System.out.printf( "Wave flag; %s%n", Thread.currentThread() );
    };

    Thread winkerThread = new Thread( winker );
    Thread flagWaverThread = new Thread( flagWaver, "flag waver" );

    winkerThread.start();
    flagWaverThread.start();
    //end::solution[]
  }
}