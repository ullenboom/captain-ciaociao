package com.tutego.exercise.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RemovingLetters {

  //tag::solution[]
  private static void removeLetter( String word, Set<String> hashSet ) {
    if ( word.isEmpty() )
      return;
    hashSet.add( word );
    IntStream.range( 0, word.length() )
             .mapToObj( index -> new StringBuilder( word ).deleteCharAt( index ).toString() )
             .forEach( substring -> removeLetter( substring, hashSet ) );
  }

  public static Set<String> removeLetter( String word ) {
    Set<String> words = new HashSet<>();
    removeLetter( word, words );
    return words;
  }
  //end::solution[]

  public static void main( String[] args ) {
//    String objects = "▣▩▨▧◩▢▲";
    String objects = "▨▧";
    System.out.println( removeLetter( objects ) );
  }
}
