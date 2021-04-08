package com.tutego.exercise.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

//tag::solution-a[]
class Message {

  public final String message;
  public final long   timestamp;

  Message( String message ) {
    this.message   = Objects.requireNonNull( message );
    this.timestamp = System.nanoTime();
  }

  @Override public boolean equals( Object other ) {
    if ( other == null || getClass() != other.getClass() ) return false;
    return message.equals( ((Message) other).message ) &&
           ((Message) other).timestamp == timestamp;
  }

  @Override public int hashCode() {
    return Objects.hash( message, timestamp );
  }

  @Override public String toString() {
    return "'" + message + '\'' + ", " + timestamp % 100_000;
  }
}
//end::solution-a[]

public class UrgentMessagesFirst {

  public static void main( String[] args ) {

    //tag::solution-b[]
    String KEYWORD = "Kanönchen";

    Comparator<Message> keywordComparator = ( msg1, msg2 ) -> {
      boolean msg1HasKeyword = msg1.message.contains( KEYWORD );
      boolean msg2HasKeyword = msg2.message.contains( KEYWORD );
      boolean bothMessagesHaveKeywordOrNot = msg1HasKeyword == msg2HasKeyword;
      return bothMessagesHaveKeywordOrNot ? 0 : msg1HasKeyword ? -1 : +1;
    };

    Comparator<Message> messageComparator =
        keywordComparator.thenComparingLong( message -> message.timestamp );
    PriorityQueue<Message> tasks = new PriorityQueue<>( messageComparator );
    //end::solution-b[]

    tasks.add( new Message( "Treasure Hunt" ) );
    System.out.println( tasks );

    tasks.add( new Message( "Kanönchen, Family Movie Night!" ) );
    System.out.println( tasks );

    tasks.add( new Message( "Build a pirate ship" ) );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );

    tasks.add( new Message( "Capture the Flag" ) );
    System.out.println( tasks );

    tasks.add( new Message( "Bury the treasure, Kanönchen" ) );
    System.out.println( tasks );

    tasks.add( new Message( "Kanönchen, make a treasure map" ) );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );

    System.out.println( tasks.remove() );
    System.out.println( tasks );
  }
}