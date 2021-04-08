package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeroComparators {

  @SuppressWarnings( "unused" )
  public static void main( String[] args ) {
    //tag::solution[]
    // local class
    class YearFirstAppearanceComparator implements Comparator<Heroes.Hero> {
      @Override public int compare( Heroes.Hero h1, Heroes.Hero h2 ) {
        return Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      }
    }

    // inner anonymous class
    Comparator<Heroes.Hero> innerClassComparator = new Comparator<>() {
      @Override public int compare( Heroes.Hero h1, Heroes.Hero h2 ) {
        return Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      }
    };

    // Lambda expression
    Comparator<Heroes.Hero> lambdaComparator =
        (h1, h2) -> Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );

    // Comparator with 2 criteria
    Comparator<Heroes.Hero> combinedComparator = ( h1, h2 ) -> {
      int yearComparison = Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      return (yearComparison != 0) ? yearComparison : h1.name.compareTo( h2.name );
    };

    List<Heroes.Hero> allHeroes = new ArrayList<>( Heroes.ALL );
    allHeroes.sort( new YearFirstAppearanceComparator() );
    allHeroes.sort( innerClassComparator );
    allHeroes.sort( lambdaComparator );
    allHeroes.sort( combinedComparator );
    //end::solution[]
  }
}
