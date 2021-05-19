package com.tutego.exercise.thread;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;

public class GiftsInTheOrphanage {

  public static void main( String[] args ) throws InterruptedException {
    //tag::solution[]
    class DistributeGift implements Runnable {
      private final String gift;

      public DistributeGift( String gift ) { this.gift = gift; }

      @Override public void run() {
        try {
          System.out.println( Thread.currentThread().getName()
                              + " gives " + gift );
          Thread.sleep( ThreadLocalRandom.current().nextInt( 1000, 4000 ) );
        }
        catch ( InterruptedException e ) { /* Ignore */ }
      }
    }

    Iterator<String> names =
        Arrays.asList( "Polly Zist", "Jo Ghurt", "Lisa Bonn" ).iterator();

    ExecutorService crew = Executors.newCachedThreadPool( runnable -> {
      ThreadFactory threadFactory = Executors.defaultThreadFactory();
      Thread thread = threadFactory.newThread( runnable );
      thread.setName( names.next() );
      return thread;
    } );

    String[] gifs = {
        "Dragon", "Pomsies", "Coat", "Tablet", "Doll", "Art Station",
        "Bike", "Card Game", "Slime", "Nerf Blaster" };
    for ( String gift : gifs ) {
      Thread.sleep( ThreadLocalRandom.current().nextInt( 1000, 2000 ) );
      crew.submit( new DistributeGift( gift ) );
    }
  }
  //end::solution[]
}
