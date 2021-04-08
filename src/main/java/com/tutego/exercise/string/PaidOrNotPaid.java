package com.tutego.exercise.string;

public class PaidOrNotPaid {

  //tag::solution[]
  public static void printList( String[] names, boolean[] paid ) {

    if ( names.length != paid.length )
      throw new IllegalArgumentException( "Number of names and paid entries are not the same, but "
                                         + names.length + " and " + paid.length );

    int maxColumnLength = 0;
    for ( String name : names )
      maxColumnLength = Math.max( maxColumnLength, name.length() );

    String format = "%-" + maxColumnLength + "s    %spaid%n";

    for ( int i = 0; i < names.length; i++ ) {
      System.out.printf( format, names[ i ], paid[ i ] ? "" : "not " );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    String[] names = { "Dory Dab", "Bob Banjo", "Cod Buri", "Bugsy" };
    boolean[] paid = { true, true, true, false };
    printList( names, paid );
  }
}
