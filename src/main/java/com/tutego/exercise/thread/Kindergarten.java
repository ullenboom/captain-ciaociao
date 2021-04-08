package com.tutego.exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//tag::solution-a[]
class Paintbox {

  private int freeNumberOfPens;
  private final Lock lock = new ReentrantLock();
  private final Condition condition = lock.newCondition();

  public Paintbox( int maximumNumberOfPens ) {
    freeNumberOfPens = maximumNumberOfPens;
    System.out.printf( "Paintbox equipped with %s pens%n", freeNumberOfPens );
  }

  public void acquirePens( int numberOfPens ) {
    try {
      lock.lock();

      while ( freeNumberOfPens < numberOfPens ) {
        System.out.printf( "%d pens from paintbox requested, available only %d, someone has to wait :(%n",
                           numberOfPens, freeNumberOfPens );
        condition.await();
      }

      freeNumberOfPens -= numberOfPens;
    }
    catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
    finally {
      lock.unlock();
    }
  }

  public void releasePens( int numberOfPens ) {
    try {
      lock.lock();
      freeNumberOfPens += numberOfPens;
      condition.signalAll();
    }
    finally {
      lock.unlock();
    }
  }
}
//end::solution-a[]

//tag::solution-b[]
class Child implements Runnable {
  private final String   name;
  private final Paintbox paintbox;

  public Child( String name, Paintbox paintbox ) {
    this.name     = name;
    this.paintbox = paintbox;
  }

  @Override
  public void run() {
    while ( ! Thread.currentThread().isInterrupted() ) {
      int requiredPens = ThreadLocalRandom.current().nextInt( 1, 10 + 1 );
      paintbox.acquirePens( requiredPens );
      System.out.printf( "%s got %d pens%n", name, requiredPens );

      try {
        TimeUnit.MILLISECONDS.sleep( ThreadLocalRandom.current().nextInt( 1000, 3000 ) );
      }
      catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }

      paintbox.releasePens( requiredPens );
      System.out.printf( "%s returned %d pens%n", name, requiredPens );

      try {
        TimeUnit.SECONDS.sleep( ThreadLocalRandom.current().nextInt( 1, 5 + 1 ) );
      }
      catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
    }
  }
}
//end::solution-b[]

public class Kindergarten {

  public static void main( String[] args ) {
    Paintbox paintbox = new Paintbox( 12 );
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.submit( new Child( "Mirjam", paintbox ) );
    executor.submit( new Child( "Susanne", paintbox ) );
    executor.submit( new Child( "Serena", paintbox ) );
    executor.submit( new Child( "Elm", paintbox ) );
  }
}
