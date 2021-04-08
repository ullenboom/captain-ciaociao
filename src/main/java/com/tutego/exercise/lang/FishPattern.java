package com.tutego.exercise.lang;

class FishPattern {


  public static void main( String[] args ) {
    //tag::solution[]
    int repetitions = 1;

    final String RIGHT_FISH = "><>";
    final String LEFT_FISH  = "<><";
    final String DISTANCE   = "   ";

    for ( int fish = 0; fish < repetitions; fish++ ) {
      for ( int i = 0; i < repetitions; i++ )
        System.out.print( RIGHT_FISH + DISTANCE);
      for ( int i = 0; i < repetitions; i++ )
        System.out.print( LEFT_FISH + DISTANCE );
      System.out.println();
    }
    //end::solution[]
  }
}
