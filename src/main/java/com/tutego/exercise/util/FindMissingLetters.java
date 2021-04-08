package com.tutego.exercise.util;

import java.util.*;
import java.util.function.Consumer;

public class FindMissingLetters {

  public static void main( String[] args ) {
    //tag::solution-a[]
    List<String> words = Arrays.asList( "haus", "maus", "elefant", "klein", "groß" );

    Map<String, List<String>> map = new HashMap<>();

    // Initialize the map
    for ( String word : words ) {
      for ( int index = 0; index < word.length(); index++ )
        map.computeIfAbsent( index + "-" + word.charAt( index ),
                             __ -> new ArrayList<>() ).add( word );
    }
    //end::solution-a[]

    //tag::solution-b[]
    // Query the data structure
    Consumer<String> letterFinder = word -> {
      Set<String> matches = null;
      for ( int index = 0; index < word.length(); index++ ) {
        // Skip unknown chars
        if ( word.charAt( index ) == '_' )
          continue;
        List<String> wordCandidates = map.get( index + "-" + word.charAt( index ) );
        // Exit loop if no known entry
        if ( wordCandidates == null ) {
          // Remove possible previous matches for correct console output
          matches = null;
          break;
        }
        // Build a copy and remove words that don't match with the length
        wordCandidates = new ArrayList<>( wordCandidates );
        wordCandidates.removeIf( s -> s.length() != word.length() );
        // Join matches from all known letters
        if ( matches == null )
          matches = new HashSet<>( wordCandidates );
        else
          matches.retainAll( wordCandidates );
      }
      System.out.println( word + " -> " +
                          (matches == null || matches.isEmpty() ? "No results" : matches) );
    };

    List<String> missingLettersWords = Arrays.asList( "ha__", "el__a_t", "x", "hi__", "___s", "___s____" );
    missingLettersWords.forEach( letterFinder );
    //end::solution-b[]
  }
}
