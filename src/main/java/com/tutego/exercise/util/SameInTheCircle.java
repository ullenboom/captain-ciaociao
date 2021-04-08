package com.tutego.exercise.util;

import java.util.*;

public class SameInTheCircle {

  public static void main( String[] args ) {
    //tag::solution1[]
    List<String> names1 = Arrays.asList( "Alexandre", "Charles", "Anne", "Henry" );
    List<String> names2 = Arrays.asList( "Anne", "Henry", "Alexandre", "Charles" );

    ArrayList<String> duplicatedList = new ArrayList<>( names1 );
    duplicatedList.addAll( names1 );
    System.out.println( Collections.indexOfSubList( duplicatedList, names2 ) >= 0 );
    //end::solution1[]

    boolean b = isSameCircle( names1, names2 );
    System.out.println( b );
  }

  //tag::solution2[]
  private static <T> boolean isSameCircle( List<T> list1, List<T> list2 ) {

    if ( list1.size() != list2.size() )
      return false;

    AbstractList<Object> list1Duplicated = new AbstractList<>() {
      @Override public int size() {
        return list1.size() * 2;
      }

      @Override public Object get( int index ) {
        return list1.get( index % list1.size() );
      }
    };
    return Collections.indexOfSubList( list1Duplicated, list2 ) >= 0;
  }
  //end::solution2[]
}
