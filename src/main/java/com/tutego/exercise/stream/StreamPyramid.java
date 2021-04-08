package com.tutego.exercise.stream;

import java.util.stream.IntStream;

public class StreamPyramid {

  public static void main( String[] args ) {
    //tag::solution[]
    IntStream.rangeClosed( 1, 5 )
             .mapToObj( i -> " ".repeat( 5 - i ) + "/\\".repeat( i ) )
             .forEach( System.out::println );
    //end::solution[]
  }
}
