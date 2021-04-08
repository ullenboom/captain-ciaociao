package com.tutego.exercise.string;

import java.util.Scanner;

public class OcrNumbers {

  public static void main( String[] args ) {
    String ocr =
        "4  4 77777  11   11    4  4  22\n" +
        "4  4    7  111  111    4  4 2  2\n" +
        "4444   7    11   11    4444   2\n" +
        "   4   7    11   11       4  2\n" +
        "   4   7   11l1 11l1      4 2222";

    int result = parseOcrNumbers( ocr );
    System.out.println( result );
  }

  //tag::solution[]
  private final static String[] searches = {
      "000", "11", "22", "333", "44", "55555", "6", "77777", "888", "9999" };

  private static int parseOcrNumbers( String string ) {
    String line = new Scanner( string ).nextLine().replaceAll( "\\s+", "" );

    for ( int i = 0; i < searches.length; i++ )
      line = line.replaceAll( searches[ i ], "" + i );

    return Integer.parseInt( line );
  }
  //end::solution[]
}
