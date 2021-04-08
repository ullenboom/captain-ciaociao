package com.tutego.exercise.util;

import java.util.*;

//tag::preparation[]
enum Planet {

  JUPITER( "Jupiter", 139_822 ), SATURN( "Saturn", 116_464 ),
  URANUS( "Uranus", 50_724 ), NEPTUNE( "Neptune", 49_248 ),
  EARTH( "Earth", 12_756 ), VENUS( "Venus,", 12_104 ),
  MARS( "Mars", 6_780 ), MERCURY( "Mercury", 4_780 ),
  PLUTO( "Pluto", 2_400 );

  public final String name;
  public final int    diameter; // km

  Planet( String name, int diameter ) {
    this.name     = name;
    this.diameter = diameter;
  }
}
//end::preparation[]

public class PlanetQuiz {
  public static void main( String[] args ) {
    //tag::solution[]
    List<Planet> shuffledPlanets = new ArrayList<>( Arrays.asList( Planet.values() ) );
    Collections.shuffle( shuffledPlanets );

    for ( Planet question : shuffledPlanets ) {
      System.out.printf( "What is the diameter of planet %s (in km)?%n", question.name );

      List<Planet> misleadingPlanets = new ArrayList<>( Arrays.asList( Planet.values() ) );
      misleadingPlanets.remove( question );
      Collections.shuffle( misleadingPlanets );

      List<Planet> choicePlanets = misleadingPlanets.subList( 0, 3 );
      choicePlanets.add( question );
      Collections.shuffle( choicePlanets );
      choicePlanets.forEach( planet -> System.out.println( planet.diameter + " km" ) );

      if ( new Scanner( System.in ).nextInt() != question.diameter )
        System.out.printf( "Wrong! The diameter of %s is %d km.%n%n",
                           question.name, question.diameter );
      else
        System.out.printf( "Correct!%n%n" );
    }
    //end::solution[]
  }
}
