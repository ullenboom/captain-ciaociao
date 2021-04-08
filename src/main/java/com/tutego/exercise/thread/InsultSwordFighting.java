package com.tutego.exercise.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsultSwordFighting {
  public static void main( String[] args ) {
    //tag::solution[]
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    class Insulter implements Runnable {
      private final String[] insults;

      public Insulter( String[] insults ) {
        this.insults = insults;
      }

      @Override public void run() {
        while ( Thread.currentThread().isInterrupted() ) {
          try {
            lock.lock();
            Thread.sleep( ThreadLocalRandom.current().nextInt( 1000 ) );
            String name = Thread.currentThread().getName();
            int rndInsult = ThreadLocalRandom.current().nextInt( insults.length );
            System.out.println( name + ": " + insults[ rndInsult ] + '!' );
            condition.signal();
            condition.await();
          }
          catch ( InterruptedException e ) { Thread.currentThread().interrupt(); }
          finally {
            lock.unlock();
          }
        }
      }
    }

    String[] insults1 = {
        "Trollop", "You have the manners of a trump",
        "You fight like a cow cocky", "Prat",
        "Your face makes onions cry",
        "You are so full of s**t, the toilet’s jealous"
    };
    String[] insults2 = {
        "Wazzock", "I've spoken with rats more polite than you",
        "Chuffer", "You make me want to spew",
        "Check your lipstick before you come for me",
        "You are more disappointing than an unsalted pretzel"
    };

    new Thread( new Insulter( insults1 ), "pirate-1" ).start();
    new Thread( new Insulter( insults2 ), "pirate-2" ).start();
    //end::solution[]
  }
}