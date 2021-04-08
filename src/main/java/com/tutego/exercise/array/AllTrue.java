package com.tutego.exercise.array;

public class AllTrue {

  //tag::solution[]
  private static boolean allTrue( boolean first, boolean... remaining ) {

    for ( boolean b : remaining )
      if ( b == false )
        return false;

    return first;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( allTrue( true, true, true ) );
    System.out.println( allTrue( true ) );
    System.out.println( allTrue( true, false ) );
    System.out.println( allTrue( true, null ) );
  }
}
