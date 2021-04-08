package com.tutego.exercise.util;

import java.util.*;
import java.util.function.ToIntFunction;

public class ImportantGossip {

  //tag::solution[]
  public static final int LIMIT = 5;

  public static List<String> importantGossip( String... words ) {

    Map<String, Integer> wordOccurrences = new HashMap<>( words.length );
    for ( String word : words )
      wordOccurrences.merge( word, 1, Integer::sum );

    Comparator<Map.Entry<String, Integer>> compareByWordOccurrence =
        Comparator.comparingInt( (ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue )
                  .reversed()
                  .thenComparing( Map.Entry::getKey );

    SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>( compareByWordOccurrence );
    sortedSet.addAll( wordOccurrences.entrySet() );

    List<String> result = new ArrayList<>( LIMIT );
    for ( Map.Entry<String, Integer> element : sortedSet ) {
      result.add( element.getKey() );
      if ( result.size() >= LIMIT )
        break;
    }

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    String[] words = {
        "Baby Shark", "Corona", "Baby Yoda", "Corona", "Baby Yoda", "Tiger King",
        "David Bowie", "Kylie Jenner", "Kardashian", "Love Island", "Bachelorette",
        "Baby Yoda", "Tiger King", "Billie Eilish", "Corona"
    };

    //    WordOccurrence a1 = new WordOccurrence( "a" );
    //    WordOccurrence a2 = new WordOccurrence( "a" );
    //    a2.incrementOccurrence();
    //
    //    WordOccurrence b = new WordOccurrence( "b" );
    //    WordOccurrence c = new WordOccurrence( "c" );
    //
    //    System.out.println( a1.equals( a2 ) );
    //    System.out.println( a1.compareTo( a2 ) );
    //    System.out.println( a1.equals( b ) );
    //    System.out.println( a1.compareTo( b ) );
    //    System.out.println( a2.compareTo( b ) );

    System.out.println( importantGossip( words ) );
    System.out.println( importantGossip( "a" ) );
    System.out.println( importantGossip( "a", "b" ) );
    System.out.println( importantGossip( "a", "a" ) );
    System.out.println( importantGossip( "a", "b", "a" ) );
    System.out.println( importantGossip( "a", "a", "a", "a", "a", "a", "a", "a" ) );
  }
}
