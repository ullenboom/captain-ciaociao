package com.tutego.exercise.stream;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveAllEqualPairs {
  public static void main( String[] args ) {
    //tag::solution[]
    String lines =
        "Balancar\nErbium\n" +
        "Benecia\nYttrium\n" +
        "Luria\nThulium\n" +  // <-
        "Kelva\nNeodym\n" +
        "Mudd\nEuropium\n" +
        "Tamaal\nErbium\n" +
        "Varala\nGadolinium\n" +
        "Luria\nThulium\n";   // <-

    // "(?m)(^.*$\n?){2}
    Pattern pattern = Pattern.compile( "(^.*$\n)" + // A line
                                       "{2}",        // two lines
                                       Pattern.MULTILINE );
    String s = new Scanner( lines )
        .findAll( pattern )
        .map( MatchResult::group )
        .distinct()
        .collect( Collectors.joining() );
    System.out.println( s );
    //end::solution[]
  }
}
