package com.tutego.exercise.util;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomInEveryLocalePrinter {

  public static void main( String[] args ) {
    //tag::solution[]
    double random = ThreadLocalRandom.current().nextDouble( 10_000, 12_000 );
    Locale[] locales = Locale.getAvailableLocales();
    for ( Locale locale : locales )
      System.out.printf( locale, "%,.2f (%s)%n", random, locale.getDisplayName() );
    //end::solution[]
  }
}