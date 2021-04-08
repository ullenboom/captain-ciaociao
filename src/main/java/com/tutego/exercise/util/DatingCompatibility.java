package com.tutego.exercise.util;

import java.util.*;

public class DatingCompatibility {

  public static void main( String[] args ) {
    //tag::solution[]
    Set<String> he = new HashSet<>();
    Collections.addAll( he, "Candy making", "Camping", "Billiards", "Fishkeeping", "Eating",
                        "Action figures", "Birdwatching", "Axe throwing" );
    Set<String> she = new HashSet<>();
    Collections.addAll( she, "Axe throwing", "Candy making", "Camping",
                        "Action figures", "Casemodding", "Skiing", "Satellite watching" );

    Set<String> smallerSet, largerSet;
    if ( he.size() < she.size() ) {
      smallerSet = he; largerSet = she;
    } else {
      smallerSet = she; largerSet = he;
    }

    Set<String> intersection = new HashSet<>( smallerSet );
    intersection.retainAll( largerSet );
    System.out.println( intersection );

    System.out.printf( "Liste 'he' stimmt zu %d %% mit der Liste 'she' überein.%n",
                       (intersection.size() * 100) / he.size() );
    System.out.printf( "Liste 'she' stimmt zu %d %% mit der Liste 'he' überein.%n",
                       (intersection.size() * 100) / she.size() );

    //end::solution[]
  }
}
