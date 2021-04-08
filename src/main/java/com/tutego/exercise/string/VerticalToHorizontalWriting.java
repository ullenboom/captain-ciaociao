package com.tutego.exercise.string;

public class VerticalToHorizontalWriting {

  //tag::solution[]
  static void printVerticalToHorizontalWriting( String string ) {
    String oneliner   = string.replace( "\n", "" );
    int numberOfLines = string.length() - oneliner.length() + 1;
    for ( int i = 0; i < oneliner.length(); i++ ) {
      char c = oneliner.charAt( (i / numberOfLines) + (i % numberOfLines) * numberOfLines );
      System.out.print( c );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    String s = "s u\n" +
               "ey!\n" +
               "ao ";
    printVerticalToHorizontalWriting( s );
  }
}
