package com.tutego.exercise.thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class CrashingDatastructure {

  //tag::solution[]
  public static void main( String[] args ) throws InterruptedException {

    List<Supplier<Map<Integer, Integer>>> mapSuppliers = Arrays.asList(
        HashMap::new,
        () -> Collections.synchronizedMap( new HashMap<>() ),
        ConcurrentHashMap::new,
        Hashtable::new
    );

    ExecutorService executor = Executors.newCachedThreadPool();

    for ( Supplier<Map<Integer, Integer>> supplier : mapSuppliers ) {
      Map<Integer, Integer> map = supplier.get();
      AtomicInteger counter = new AtomicInteger();

      Callable<Object> run = Executors.callable( () -> {
        for ( int i = 0; i < 1000; i++ )
          map.put( counter.getAndIncrement(), i );
      } );

      List<Future<Object>> futures = executor.invokeAll( Arrays.asList( run, run, run ) );
      futures.forEach( o -> { try { o.get(); } catch ( Exception e ) { /* Ignore */ } } );

      System.out.printf( "Expected 3000 elements and the %s contains %d%n",
                         map.getClass().getSimpleName(), map.size() );
    }

    executor.shutdown();
  }
  //end::solution[]
}