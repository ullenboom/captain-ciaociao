package com.tutego.exercise.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Banquet {

  public static void main( String[] args ) {
    //tag::solution[]
    Semaphore seats = new Semaphore( 6 - 2 );

    class Guest implements Runnable {
      private final String name;
      public Guest( String name ) { this.name = name; }

      @Override
      public void run() {
        try {
          System.out.printf( "%s is waiting for a free place%n", name );
          seats.acquire();
          System.out.printf( "%s has a seat at the table%n", name );
          Thread.sleep( ThreadLocalRandom.current().nextInt( 2000, 5000 ) );
        }
        catch ( InterruptedException e ) { /* Ignore */ }
        finally {
          System.out.printf( "%s leaves the table%n", name );
          seats.release();
        }
      }
    }

    List<String> names = new ArrayList<>( Arrays.asList(
        "Balronoe", "Xidrora", "Zobetera", "Kuecarro", "Bendover", "Bane", "Cody", "Djarin", "Enfy"
    ) );
    for ( int i = 0, len = names.size(); i < len; i++ )
      Collections.addAll( names, "Admiral " + names.get( i ), "Commander " + names.get( i ) );

    ExecutorService executors = Executors.newCachedThreadPool();

    for ( String name : names )
      executors.execute( new Guest( name ) );

    executors.shutdown();
  }
  //end::solution[]
}
