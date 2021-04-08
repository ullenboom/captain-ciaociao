package com.tutego.exercise.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MuggedVictims {
  public static void main( String[] args ) {
    //tag::solution[]
    String[] muggedBefore = { "Thomas Geldregen", "Rainer Reichtum",
                              "Heinz Goldsocken", "Gisela von Prunk",
                              "Herbert Gönnemeyer", "Linda Edel", "Florian Silber" };

    BloomFilter<String> mugged = BloomFilter.create( Funnels.stringFunnel( StandardCharsets.UTF_8 ),
                                                     muggedBefore.length * 2 );

    for ( String victim : muggedBefore )
      mugged.put( victim );

    System.out.println( "What is the name of the next victim?" );
    String input = new Scanner( System.in ).nextLine();

    boolean maybeMuggedBefore = mugged.mightContain( input );

    if ( ! maybeMuggedBefore )
      System.out.printf( "%s wurde noch *nicht* überfallen.%n", input );
    else {
      System.out.printf( "%s was *maybe* already mugged.%n", input );
      System.out.printf( "The probability that '%s' is assumed to be in the" +
                         "data structure, although the name was not added before, " +
                         "is %.2f %%.%n", input, mugged.expectedFpp() * 100 );
    }
    //end::solution[]
  }
}
