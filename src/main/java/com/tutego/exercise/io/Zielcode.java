package com.tutego.exercise.io;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;

public class Zielcode {

  //tag::solution[]
  private static final String[] ZIELCODE = {
      "||||",     // 0000 = 0
      "||| ",     // 0001 = 1
      "|| |",     // 0010 = 2
      "||  ",     // 0011 = 3
      "| ||",     // 0100 = 4
      "| | ",     // 0101 = 5
      "|  |",     // 0110 = 6
      " | |",     // not 0111 = 7 but 1010 = 10
      " |||",     // 1000 = 8
      " || " };   // 1001 = 9

  public static void writeZielcode( String string, Writer writer ) throws IOException {
    for ( int i = 0; i < string.length(); i++ ) {
      int value = Character.getNumericValue( string.charAt( i ) );
      if ( value >= 0 && value <= 9 ) {
        writer.write( ZIELCODE[ value ] );
        if ( i != string.length() - 1 )
          writer.write( "  " );
      }
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    StringWriter writer1 = new StringWriter();
    writeZielcode( "0123456789", writer1 );
    System.out.println( writer1 );

    StringWriter writer2 = new StringWriter();
    writeZielcode( "௦ ௧ ௨ ௩ ௪ ௫ ௬ ௭ ௮ ௯ ௰", writer2 );
    System.out.println( writer2 );

    //tag::solution2[]
    String string = "0123456789";
    for ( int i = 0; i < string.length(); i++ ) {
      BigInteger v = new BigInteger(
          string.charAt( i ) == '7' ? "10" : string.substring( i, i + 1 ) );
      System.out.print( v.testBit( 3 ) ? ' ' : '|' );
      System.out.print( v.testBit( 2 ) ? ' ' : '|' );
      System.out.print( v.testBit( 1 ) ? ' ' : '|' );
      System.out.print( v.testBit( 0 ) ? ' ' : '|' );
      System.out.print( "  " );
    }
    //end::solution2[]
  }
}
