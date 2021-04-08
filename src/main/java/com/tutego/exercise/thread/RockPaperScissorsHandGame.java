package com.tutego.exercise.thread;

import java.util.Queue;
import java.util.concurrent.*;

public class RockPaperScissorsHandGame {

  enum HandSign {
    SCISSORS, ROCK, PAPER;

    static HandSign random() {
      return values()[ ThreadLocalRandom.current().nextInt( 3 ) ];
    }

    int beats( HandSign other ) {
      return (this == other) ? 0 :
             (this == HandSign.ROCK && other == HandSign.SCISSORS
              || this == HandSign.PAPER && other == HandSign.ROCK
              || this == HandSign.SCISSORS && other == HandSign.PAPER) ? +1 : -1;
    }
  }

  public static void main( String[] args ) {
    //tag::solution[]
    Queue<HandSign> handSigns = new ArrayBlockingQueue<>( 2 );

    Runnable determineWinner = () -> {
      HandSign handSign1 = handSigns.poll();
      HandSign handSign2 = handSigns.poll();

      switch ( handSign1.beats( handSign2 ) ) {
        case 0:
          System.out.printf( "Tie, both players choose %s%n", handSign1 );
          break;
        case +1:
          System.out.printf( "Player 1 wins with %s, player 2 loses with %s%n",
                             handSign1, handSign2 );
          break;
        case -1:
          System.out.printf( "Player 2 wins with %s, player 1 loses with %s%n",
                             handSign2, handSign1 );
          break;
      }
    };

    CyclicBarrier barrier = new CyclicBarrier( 2, determineWinner );

    Runnable playScissorsRockPaper = () -> {
      try {
        handSigns.add( HandSign.random() );
        barrier.await();
      }
      catch ( InterruptedException | BrokenBarrierException e ) { /* Ignore */ }
    };

    ScheduledExecutorService executor = Executors.newScheduledThreadPool( 2 );
    executor.scheduleAtFixedRate( () -> {
      System.out.println( "Schnick, Schnack, Schnuck" );
      executor.execute( playScissorsRockPaper );
      executor.execute( playScissorsRockPaper );
    }, 0, 1, TimeUnit.SECONDS );
    //end::solution[]
  }
}

//class HandSignDemo {
//  public static void main( String[] args ) {
//    System.out.println( HandSign.PAPER.beats( HandSign.PAPER ) );
//    System.out.println( HandSign.PAPER.beats( HandSign.ROCK ) );
//    System.out.println( HandSign.ROCK.beats( HandSign.PAPER ) );
//  }
//}