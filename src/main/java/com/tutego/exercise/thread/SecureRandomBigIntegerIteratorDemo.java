package com.tutego.exercise.thread;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SynchronousQueue;

//tag::solution[]
class SecureRandomBigIntegerIterator implements Iterator<BigInteger> {

  private final SynchronousQueue<BigInteger> channel = new SynchronousQueue<>();

  public SecureRandomBigIntegerIterator() {
    Runnable bigIntegerPutter = () -> {
      try {
        while ( true ) {
          BigInteger bigInteger = internalNext();
          System.out.printf( "> About to put number %s... into the queue%n",
                             bigInteger.toString().subSequence( 0, 20 ) );
          channel.put( bigInteger );
          System.out.println( "> Number was taken" );
        }
      }
      catch ( InterruptedException e ) { throw new IllegalStateException(e); }
    };
    ForkJoinPool.commonPool().submit( bigIntegerPutter );
  }

  private BigInteger internalNext() {
    return new BigInteger( 1024, new SecureRandom() );
  }

  @Override public boolean hasNext() {
    return true;
  }

  @Override public BigInteger next() {
    try {
      System.out.println( "< About to take a number" );
      BigInteger bigInteger = channel.take();
      System.out.println( "< Took a number out" );
      return bigInteger;
    }
    catch ( InterruptedException e ) { throw new IllegalStateException(e); }
  }
}
//end::solution[]

public class SecureRandomBigIntegerIteratorDemo {

  public static void main( String[] args ) throws InterruptedException {
    SecureRandomBigIntegerIterator rbi = new SecureRandomBigIntegerIterator();
    System.out.println( "Hurray its a " + rbi.next() );
    System.out.println( "Hurray its a " + rbi.next() );
    System.out.println( "Hurray its a " + rbi.next() );

    Thread.sleep( 100 );
  }
}