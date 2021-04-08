package com.tutego.exercise.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class WordSequence {

  //tag::read-words[]
  private static final String WORD_LIST_URL =
      "https://raw.githubusercontent.com/creativecouple/all-the-german-words/master/corpus/de.txt";
      // "https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt";

  private static Collection<String> readWords() throws IOException {
    URL url = new URL( WORD_LIST_URL ); //    370.000 words
    Collection<String> words = new HashSet<>( 500_000 );
    try ( InputStream is = url.openStream() ) {
      new Scanner( is ).forEachRemaining( s -> words.add( s.toLowerCase() ) );
    }
    return words;
  }
  //end::read-words[]

  //tag::solution[]
  private static final int MIN_WORD_LENGTH = 3;

  private static Collection<String> substrings( String string ) {
    Collection<String> result = new ArrayList<>(
        (int)(string.length() * (string.length() - 3L) / 2 + 1) );

    for ( int startIndex = 0; startIndex < string.length(); startIndex++ )
      for ( int len = MIN_WORD_LENGTH; len <= string.length() - startIndex; len++ )
        result.add( string.substring( startIndex, startIndex + len ) );

    return result;
  }

  public static Collection<String> wordList( String string, Collection<String> words ) {
    Collection<String> result = new ArrayList<>();

    for ( String substring : substrings( string.toLowerCase() ) )
      if ( words.contains( substring ) )
        result.add( substring );

    return result;
  }
  //end::solution[]

  /*
  //tag::solution2[]
  static class WordSplitter implements Iterator<String> {
    private final String string;
    int start, len = 3;

    public WordSplitter( String string ) {
      this.string = string;
    }

    @Override public boolean hasNext() {
      return start < string.length() && len <= string.length() - start;
    }

    @Override public String next() {
      String result = string.substring( start, start + len );
      len++;
      if ( len > string.length() - start ) {
        len = 3;
        start++;
      }
      return result;
    }
  }

  static List<String> wordList( String string, Set<String> words ) {
    List<String> result = new ArrayList<>();
    Iterator<String> splitter = new WordSplitter( string );
    while ( splitter.hasNext() ) {
      String word = splitter.next();
      if ( words.contains( word ) )
        result.add( word );
    }
    return result;
  }
  //end::solution2[]
  */

  public static void main( String[] args ) throws IOException {
    Collection<String> words = readWords();
    System.out.println( wordList( "Rhabarbermarmelade", words ) );
    System.out.println( wordList( "wristwatches", words ) );
    System.out.println( wordList( "abibliophobia", words ) );
  }
}
