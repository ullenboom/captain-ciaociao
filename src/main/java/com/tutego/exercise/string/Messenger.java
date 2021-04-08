package com.tutego.exercise.string;

public class Messenger {

  //tag::solution[]
  private static String charAtOrEmpty( String string, int index ) {
    return index < string.length() ? string.substring( index, index + 1 ) : "";
  }

  private static String joinSplitMessages( String... parts ) {
    int maxStringLength = 0;

    for ( String part : parts )
      maxStringLength = Math.max( maxStringLength, part.length() );

    StringBuilder result = new StringBuilder();
    for ( int index = 0; index < maxStringLength; index++ )
      for ( String part : parts )
        result.append( charAtOrEmpty( part, index ) );

    return result.toString();
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( joinSplitMessages( "Hoy", "ok" ) ); // Hooky
    System.out.println( joinSplitMessages( "Hooky" ) ); // Hooky
    System.out.println( joinSplitMessages( "Hk", "oy", "o" ) ); // Hooky
    System.out.println( joinSplitMessages( "H", "", "ooky" ) ); // Hooky
  }
}
