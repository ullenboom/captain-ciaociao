package com.tutego.exercise.lang;

public class Blackjack {
  public static void main( String[] args ) {
    //tag::solution[]
    int dealer = new java.util.Scanner( System.in ).nextInt();
    int player = new java.util.Scanner( System.in ).nextInt();

    if ( player < 2 || dealer < 2 )
      return;

    final int MAX_SCORE = 21;

    // Both > 21 -> 0
    if ( dealer > MAX_SCORE && player > MAX_SCORE )
      System.out.println( 0 );
    // One party > 21 -> the other wins
    else if ( player > MAX_SCORE )
      System.out.println( dealer );
    else if ( dealer > MAX_SCORE )
      System.out.println( player );
    // Both are <= 21 -> Max is best
    else
      System.out.println( Math.max( player, dealer ) );
    //end::solution[]
  }
}
