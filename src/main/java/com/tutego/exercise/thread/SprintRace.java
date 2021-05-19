package com.tutego.exercise.thread;

import java.util.concurrent.*;

public class SprintRace {

  public static void main( String[] args ) throws InterruptedException {
    //tag::solution[]
    final int NUMBER_OF_ATHLETES = 10;
    CountDownLatch startLatch = new CountDownLatch( 1 );
    CountDownLatch endLatch   = new CountDownLatch( NUMBER_OF_ATHLETES );

    ConcurrentNavigableMap<Integer, String> records =
        new ConcurrentSkipListMap<>();

    Runnable athlete = () -> {
      try {
        startLatch.await();
        int time = ThreadLocalRandom.current().nextInt( 1_000, 2_000 );
        TimeUnit.MILLISECONDS.sleep( time );
        records.put( time, Thread.currentThread().getName() );
        endLatch.countDown();
      }
      catch ( InterruptedException e ) { /* Ignore */ }
    };

    for ( int i = 0; i < NUMBER_OF_ATHLETES; i++ )
      new Thread( athlete, "athlete-" + (i + 1) ).start();

    // Start the race
    startLatch.countDown();

    // Wait for race to end
    endLatch.await();

    records.forEach(
      (time, name) -> System.out.printf( "%s in %d ms%n", name, time )
    );
    //end::solution[]
  }
}