package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class City {
  public final String name;
  public final int population;

  public City( String name, int population ) {
    this.name = name;
    this.population = population;
  }
}

public class CityTourList {

  //tag::solution[]
  public static void main( String[] args ) {

    List<City> cityTour = new ArrayList<>();
    City g = new City( "Gotham (cathedral)", 8_000_000 );
    City m = new City( "Metropolis (pleasure garden)", 1_600_000 );
    City h = new City( "Hogsmeade (Shopping Street)", 1_124 );
    Collections.addAll( cityTour, g, m, h );

    cityTour.removeIf( city -> city.population <= 10_000 );
    cityTour.replaceAll(
        city -> new City( city.name.replaceAll( "\\s*\\(.*\\)$", "" ),
                          city.population )
    );
    cityTour.forEach( CityTourList::printAsCsv );
  }

  private static void printAsCsv( City city ) {
    System.out.printf( "%s,%s%n", city.name, city.population );
  }
  //end::solution[]
}
