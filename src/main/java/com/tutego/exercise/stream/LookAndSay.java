package com.tutego.exercise.stream;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LookAndSay {

  public static void main( String[] args ) {
    //tag::solution[]
    Pattern sameSymbolsPattern = Pattern.compile( "(.)\\1*" );
    Function<MatchResult, String> lengthAndSymbol =
        match -> match.group().length() + match.group( 1 );

    Stream.iterate( "1", s -> sameSymbolsPattern.matcher( s ).replaceAll( lengthAndSymbol ) )
          .limit( 20 )
          .forEach( System.out::println );
    //end::solution[]
  }
}
