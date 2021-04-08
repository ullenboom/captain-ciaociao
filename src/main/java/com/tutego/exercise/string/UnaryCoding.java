package com.tutego.exercise.string;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class UnaryCoding {

  //tag::solution-a[]
  private static int ensurePositive( int value ) {
    if ( value < 0 )
      throw new IllegalArgumentException( "value is negative, but must be positive" );
    return value;
  }

  static String encode( int... values ) {
    StringBuilder codes = new StringBuilder( values.length );
    for ( int value : values ) {
      for ( int i = 0, len = ensurePositive( value ); i < len; i++ )
        codes.append( "1" );
      codes.append( "0" );
    }
    return codes.toString();
  }
  //end::solution-a[]

  //tag::solution-b[]
  static int[] decode( String string ) {
    if ( string.isEmpty() )
      return new int[0];

    if ( ! string.endsWith( "0" ) )
      throw new IllegalArgumentException(
          "string must end with 0 but did end with " + string.charAt( string.length() - 1 ) );

    int arrayLength = 0;

    for ( int i = 0; i < string.length(); i++ ) {
      if ( string.charAt( i ) == '0' )
        arrayLength++;
      else if ( string.charAt( i ) != '1' )
        throw new IllegalArgumentException(
            "string can only contain 0 or 1 but found " + string.charAt( i ) );
    }

    int[] result = new int[ arrayLength ];
    int resultIndex = 0;

    int count = 0;
    for ( int i = 0; i < string.length(); i++ ) {
      if ( string.charAt( i ) == '1' )
        count++;
      else {
        result[ resultIndex++ ] = count;
        count = 0;
      }
    }

    return result;
  }
  //end::solution-b[]

  private static String toString( byte[] bytes ) {
    StringBuilder sb = new StringBuilder( bytes.length * 9 );
    for ( byte b : bytes )
      sb.append( Integer.toBinaryString( (b & 0xFF) + 0x100 ).substring( 1 ) ).append( ' ' );
    return sb.toString();
  }

  private static byte[] getBytes( String s ) {
    ByteBuffer byteBuffer = ByteBuffer.allocate( s.length() / 8 + 1 );
    for ( int i = 0; i < s.length(); i += 8 ) {
      String eightBits = s.substring( i, i + Math.min( 8, s.length() - i ) );
      byteBuffer.put( (byte) Integer.parseUnsignedInt( eightBits, 2 ) );
    }
    return byteBuffer.array();
  }

  public static void main( String[] args ) {
    String unaryCode = encode( 0, 1, 2, 3, 0, 1 );
    System.out.println( unaryCode );
    System.out.println( unaryCode.length() );
    System.out.println( Arrays.toString( decode( "0101101110010" ) ) );
    // System.out.println( Arrays.toString( decode( "1" ) ) );

    // String s = "0101010101010101000100101011110000011111000001111010100010001001010";
    byte[] array = getBytes( unaryCode );
    System.out.println( toString( array ) );
  }
}
