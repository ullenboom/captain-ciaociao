package com.tutego.exercise.util;

import java.io.InputStream;
import java.util.*;

public class FamilyNamesByLength {

  public static void main( String[] args ) {
    //tag::solution[]
    SortedMap<Integer, List<String>> namesByLength = new TreeMap<>();

    InputStream resource = FamilyNamesByLength.class.getResourceAsStream( "family-names.txt" );
    try ( Scanner scanner = new Scanner( resource ) ) {
      while ( scanner.hasNextLine() ) {
        String name = scanner.nextLine();
        namesByLength.computeIfAbsent( name.length(), __ -> new ArrayList<>() )
                     .add( name );
      }
    }

    namesByLength.forEach( (len, names) -> System.out.println( len + " " + names ) );

    for ( int len; (len = new Scanner( System.in ).nextInt()) > 0; ) {
      int finalLen = len;
      Optional.ofNullable( namesByLength.get( len ) )
              .ifPresentOrElse(
                  System.out::println,
                  () -> System.out.printf( "No words of length %d%n", finalLen ) );
    }
    //end::solution[]
  }
}