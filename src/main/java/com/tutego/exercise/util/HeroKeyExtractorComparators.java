package com.tutego.exercise.util;

import java.util.Comparator;

public class HeroKeyExtractorComparators {

  public static void main( String[] args ) {
    //tag::solution[]
    Comparator<Heroes.Hero> nameComparator =
        Comparator.comparing( h -> h.name );

    Comparator<Heroes.Hero> yearComparator =
        Comparator.comparingInt( h -> h.yearFirstAppearance );

    Comparator<Heroes.Hero> combinedComparator1 =
        yearComparator.thenComparing( nameComparator );

    Comparator<Heroes.Hero> combinedComparator2 =
        nameComparator.thenComparingInt( h -> h.yearFirstAppearance );

    Comparator<Heroes.Hero> insensitiveNameComparator =
        Comparator.comparing( h -> h.name, String.CASE_INSENSITIVE_ORDER );
    //end::solution[]
  }
}
