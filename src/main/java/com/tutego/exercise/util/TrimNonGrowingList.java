package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrimNonGrowingList {
  //tag::solution[]
  static void trimNonGrowingNumbers( List<Double> numbers ) {

    if ( numbers.size() < 2 )
      return;

    double previous = numbers.get( 0 );
    for ( int i = 1; i < numbers.size(); i++ ) {
      double current = numbers.get( i );
      if ( current <= previous ) {
        numbers.subList( i, numbers.size() ).clear();
        break;
      }
      previous = current;
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    ArrayList<Double> numbers = new ArrayList<>( Arrays.asList( 1., 2., 3., 2., 1. ) );
    trimNonGrowingNumbers( numbers );
    System.out.println( numbers );
  }
}
