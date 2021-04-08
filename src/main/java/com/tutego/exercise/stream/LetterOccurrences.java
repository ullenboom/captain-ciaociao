package com.tutego.exercise.stream;

import java.util.stream.Collectors;

public class LetterOccurrences {

  public static void main( String[] args ) {
    //tag::solution[]
    String input  = "eclectic";
    String output =
        input.chars()
            .mapToObj( c -> (char) c  + "" + input.chars().filter(d -> d == c).count() )
            .collect( Collectors.joining( "/" ) );
    System.out.println( output ); // e2/c3/l1/e2/c3/t1/i1/c3
    //end::solution[]
  }
}
