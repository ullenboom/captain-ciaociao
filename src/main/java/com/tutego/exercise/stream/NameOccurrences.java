package com.tutego.exercise.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class NameOccurrences {

  public static void main( String[] args ) {
    //tag::solution[]
    String[] names = {
        "Anne", "Captain CiaoCiao", "Balico", "Charles", "Anne", "CiaoCiao",
        "CiaoCiao", "Drake", "Anne", "Balico", "CiaoCiao" };
    Map<String, Long> nameOccurrences =
        Arrays.stream( names )
              .map( s -> "CiaoCiao".equalsIgnoreCase( s ) ? "Captain CiaoCiao" : s )
              .collect( Collectors.groupingBy( String::toLowerCase, Collectors.counting() ) );
    System.out.println( nameOccurrences );
    //end::solution[]
  }
}
