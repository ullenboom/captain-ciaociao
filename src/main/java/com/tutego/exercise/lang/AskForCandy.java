package com.tutego.exercise.lang;

import java.util.Optional;
import java.util.Scanner;

public class AskForCandy {

  //tag::solution[]
  enum CandyType {
    CARAMELS,
    CHOCOLATE,
    GUMMIES,
    LICORICE,
    LOLLIPOPS,
    CHEWING_GUMS,
    COTTON_CANDY
  }

  static Optional<CandyType> fromName( String input ) {
    try {
      input = input.trim().toUpperCase().replace( ' ', '_' );
      return Optional.of( CandyType.valueOf( input ) );
    }
    catch ( IllegalArgumentException e ) {
      return Optional.empty();
    }
  }

  public static void main( String[] args ) {
    System.out.println( "Name a candy" );
    String input = new Scanner( System.in ).nextLine();
    fromName( input ).ifPresentOrElse( System.out::println, () -> System.out.println("Unknown") );
  }
  //end::solution[]
}