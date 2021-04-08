package com.tutego.exercise.io;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
  public static void main( String[] args ) throws IOException {
    String text = "3.14% of sailors are Pi Rates.\n";
    try ( Reader stringReader = new StringReader( text );
          Reader frequencyReader = new CharacterFrequencyReader( stringReader );
          BufferedReader bufferedReader = new BufferedReader( frequencyReader ) ) {
      bufferedReader.transferTo( Writer.nullWriter() );
      // bufferedReader.lines().forEach( System.out::println );
      System.out.println( frequencyReader );
    }
  }
}

//tag::solution[]
class CharacterFrequencyReader extends FilterReader {

  private static class SortedBag extends TreeMap<Integer, Integer> {
    int add( int c ) {
      return merge( c, 1, Integer::sum );
    }
  }

  private final SortedBag frequencies = new SortedBag();

  public CharacterFrequencyReader( Reader in ) {
    super( in );
  }

  @Override public int read( char[] chars, int off, int len ) throws IOException {
    int read = super.read( chars, off, len );
    for ( int i = 0; i < read; i++ )
      frequencies.add( chars[ i + off ] );
    return read;
  }

  @Override public String toString() {
    double sum = frequencies.values().stream().mapToInt( i -> i ).sum();
    Function<Map.Entry<Integer, Integer>, String> entryToStrings =
        entry -> String.format( "%5s | %3d | %.2f%n",
                                Character.isISOControl( entry.getKey() ) ?
                                String.format( "(%02X)", entry.getKey() ) :
                                Character.toString( entry.getKey() ),
                                entry.getValue(), entry.getValue() / sum * 100 );
    return frequencies.entrySet().stream().map( entryToStrings ).collect( Collectors.joining() );
  }
}
//end::solution[]
