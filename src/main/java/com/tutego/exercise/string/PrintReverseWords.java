package com.tutego.exercise.string;

public class PrintReverseWords {

  //tag::solution[]
  public static void printAllWords( String string ) {
    String[] words = string.split( "(\\p{Punct}|\\s)+" );
    for ( String word : words )
      System.out.printf( "%s ", new StringBuilder( word ).reverse() );
  }
  //end::solution[]

  public static void main( String[] args ) {
    printAllWords( "erehW did eht etarip esahcrup sih kooh? tA eht dnah-dnoces pohs!" );
  }
}