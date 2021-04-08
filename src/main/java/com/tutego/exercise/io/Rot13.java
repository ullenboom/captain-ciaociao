package com.tutego.exercise.io;

import java.io.*;

public class Rot13 {

  static void rot( InputStream in ) throws IOException {
    for ( int b = 0; (b = in.read()) >= 0; ) {
      int cap = b & 32;
      b &= ~cap;
      b = ((b >= 'A') && (b <= 'Z') ? ((b - 'A' + 13) % 26 + 'A') : b) | cap;

      System.out.print( String.valueOf( (char) b ) );
    }
  }

  public static void main( String args[] ) throws IOException {
    rot( System.in );
    System.out.flush();
  }
}
