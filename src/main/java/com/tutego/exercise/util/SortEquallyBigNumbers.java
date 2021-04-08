package com.tutego.exercise.util;

import java.math.BigDecimal;
import java.util.*;

public class SortEquallyBigNumbers {

  public static void main( String[] args ) {
    //tag::solution[]
    Comparator<String> comparator =
        Comparator.comparing( (String s) -> new BigDecimal( s ) )
                  .thenComparing( Comparator.naturalOrder() );

    SortedSet<String> sortedNumbers = new TreeSet<>( comparator );
    Collections.addAll( sortedNumbers,
                        "-13.123", "0", "0", "10101010", "10101010.0", "0.0", "-0.0" );

    System.out.println( sortedNumbers );
    //end::solution[]
  }
}
