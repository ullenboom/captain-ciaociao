package com.tutego.exercise.lang;

import java.util.Optional;

public class RandomCandy {
  //tag::solution[]
  enum CandyType {
    CARAMELS,
    CHOCOLATE,
    GUMMIES,
    LICORICE,
    LOLLIPOPS,
    CHEWING_GUMS,
    COTTON_CANDY;

    public static Optional<CandyType> fromName( String input ) {
      try {
        input = input.trim().toUpperCase().replace( ' ', '_' );
        return Optional.of( valueOf( input ) );
      }
      catch ( IllegalArgumentException e ) {
        return Optional.empty();
      }
    }

    public static CandyType random() {
      return values()[ (int) (Math.random() * values().length) ];
    }

    //    private static CandyType[] VALUES = values();
    //    public static CandyType random() {
    //      return VALUES[ (int) (Math.random() * VALUES.length) ];
    //    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    //    String input = JOptionPane.showInputDialog( null, "Name of a candy" );
    //    if ( input != null )
    //      System.out.println( CandyType.fromName( input ) );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
  }
}