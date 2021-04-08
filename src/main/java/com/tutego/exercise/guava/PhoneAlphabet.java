package com.tutego.exercise.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;

import java.util.List;
import java.util.Set;

public class PhoneAlphabet {
  //tag::solution[]
  static final Multimap<Integer, String> SYMBOLS =
      new ImmutableMultimap.Builder<Integer, String>()
          .put( 0, "0" )
          .put( 1, "1" )
          .putAll( 2, "A", "B", "C" )
          .putAll( 3, "D", "E", "F" )
          .putAll( 4, "G", "H", "I" )
          .putAll( 5, "J", "K", "L" )
          .putAll( 6, "N", "M", "O" )
          .putAll( 7, "P", "Q", "R", "S" )
          .putAll( 8, "T", "U", "V" )
          .putAll( 9, "T", "U", "V" )
          .build();

  private static char symbolToDigit( char symbol ) {
    for ( int digit = 0; digit <= 9; digit++ )
      if ( SYMBOLS.get( digit ).contains( "" + symbol ) )
        return Character.forDigit( digit, 10 );
    return symbol;
  }

  static String wordToNumber( String word ) {
    return FluentIterable.from( Lists.charactersOf( word ) )
                         .transform( PhoneAlphabet::symbolToDigit )
                         .join( Joiner.on( "" ) );
  }

  static List<String> numberToWords( String number ) {
    Preconditions.checkArgument( number.matches( "\\d+" ),
                                 "%s is not a number with digits 0 to 9", number );

    List<ImmutableSet<String>> symbolsForDigit =
        FluentIterable.from( Lists.charactersOf( number ) )
                      .transform( digit -> Character.getNumericValue( digit ) )
                      .transform( ascii -> SYMBOLS.get( ascii ) )
                      .transform( symbols -> ImmutableSet.copyOf( symbols ) )
                      .toList();

    Set<List<String>> permutations = Sets.cartesianProduct( symbolsForDigit );

    return FluentIterable.from( permutations )
                         .transform( permutation -> String.join( "", permutation ) )
                         .toList();
  }
  //end::solution[]

  public static void main( String[] args ) {
    String number = "624";
    List<String> words = numberToWords( number );
    words.forEach( word -> System.out.println( word + " -> " + wordToNumber( word ) ) );
  }
}
