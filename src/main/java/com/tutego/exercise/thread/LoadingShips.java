package com.tutego.exercise.thread;

import java.util.UUID;
import java.util.concurrent.*;

public class LoadingShips {

  public static void main( String[] args ) {
    //tag::solution-a[]
    final ThreadLocalRandom random = ThreadLocalRandom.current();
    class Loader implements Runnable {
      private final BlockingQueue<String> ramp;

      Loader( BlockingQueue<String> ramp ) {
        this.ramp = ramp;
      }

      @Override
      public void run() {
        while ( ! Thread.currentThread().isInterrupted() ) {
          try {
            String[] products = { "Rum", "wine", "salami", "beer", "cheese", "comics" };
            String product =   products[ random.nextInt( products.length ) ]
                             + ":" + UUID.randomUUID().toString();
            ramp.put( product );
            System.out.printf( "Product with ID %s placed on the ramp%n", product );
            TimeUnit.MILLISECONDS.sleep( random.nextInt( 1000, 2000 ) );
          }
          catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
        }
      }
    }
    //end::solution-a[]

    //tag::solution-b[]
    class Unloader implements Runnable {
      private final BlockingQueue<String> ramp;

      Unloader( BlockingQueue<String> ramp ) {
        this.ramp = ramp;
      }

      @Override
      public void run() {
        while ( ! Thread.currentThread().isInterrupted() ) {
          try {
            String product = ramp.take();
            System.out.printf( "Product with ID %s taken off the ramp%n", product );
            TimeUnit.MILLISECONDS.sleep( random.nextInt( 1000, 2000 ) );
          }
          catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
        }
      }
    }
    //end::solution-b[]

    //tag::solution-c[]
    int RAMP_CAPACITY = 10;
    BlockingQueue<String> ramp = new ArrayBlockingQueue<>( RAMP_CAPACITY );
    ExecutorService executors = Executors.newCachedThreadPool();

    for ( int i = 0; i < 5; i++ )  executors.execute( new Unloader( ramp ) );
    for ( int i = 0; i < 10; i++ ) executors.execute( new Loader( ramp ) );
    //end::solution-c[]
    // executors.shutdown();
  }
}
