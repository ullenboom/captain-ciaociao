package com.tutego.exercise.io;

import java.io.*;

public class WriteInEBCDIC {
  public static void main( String[] args ) {
    try ( OutputStream fos = new FileOutputStream( "streams.txt" );
          OutputStreamWriter osw = new OutputStreamWriter( fos, "Cp500" );
          PrintWriter out = new PrintWriter( osw ) ) {
      out.print( "Hallo" );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}