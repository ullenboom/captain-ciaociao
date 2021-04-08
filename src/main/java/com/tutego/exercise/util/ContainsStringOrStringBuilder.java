package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Collection;

public class ContainsStringOrStringBuilder {
  public static void main( String[] args ) {
    //tag::solution[]
    Collection<String> islands1 = new ArrayList<>();
    islands1.add( "Galápagos" );
    islands1.add( "Revillagigedo" );
    islands1.add( "Clipperton" );
    System.out.println( islands1.contains( "Clipperton" ) );

    Collection<StringBuilder> islands2 = new ArrayList<>();
    islands2.add( new StringBuilder( "Galápagos" ) );
    islands2.add( new StringBuilder( "Revillagigedo" ) );
    islands2.add( new StringBuilder( "Clipperton" ) );
    System.out.println( islands2.contains( new StringBuilder( "Clipperton" ) ) );
    //end::solution[]
  }
}
