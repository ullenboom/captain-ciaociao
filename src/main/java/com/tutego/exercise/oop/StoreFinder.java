package com.tutego.exercise.oop;

import java.awt.Point;
import java.util.*;

//tag::solution[]
class Store {
  String name;
  Point location;

  Store( String name, int x, int y ) {
    this.name = name;
    this.location = new Point( x, y );
  }

  @Override
  public String toString() {
    return String.format( "Store [name=%s, location=%s]", name, location );
  }
}

public class StoreFinder {

  static List<Store> findStoresAround( Collection<Store> stores, Point center ) {
    List<Store> result = new ArrayList<>( stores );

    class StoreDistanceComparator implements Comparator<Store> {
      @Override
      public int compare( Store s1, Store s2 ) {
        double dist1ToCenter = s1.location.distance( center );
        double dist2ToCenter = s2.location.distance( center );
        return Double.compare( dist1ToCenter, dist2ToCenter );
      }
    }

    result.sort( new StoreDistanceComparator() );
    return result;
  }

  public static void main( String[] args ) {
    Store s1 = new Store( "ALDI", 10, 10 );
    Store s2 = new Store( "LIDL", 90, 80 );
    Store s3 = new Store( "REWE", 51, 51 );
    List<Store> list = Arrays.asList( s1, s2, s3 );
    System.out.println( list );
    List<Store> around = findStoresAround( list, new Point( 50, 50 ) );
    System.out.println( around );
  }
}
//end::solution[]
