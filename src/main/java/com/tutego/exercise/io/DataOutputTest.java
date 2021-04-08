package com.tutego.exercise.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataOutputTest {

  public static void main( String[] args ) {
    //tag::solution[]
    try ( OutputStream     fos = Files.newOutputStream( Paths.get("test.txt") );
          DataOutputStream dos = new DataOutputStream( fos ) ) {
      dos.writeChars( "There cannot be a crisis next week. My schedule is already full." );
      dos.writeChar( 'H' );
      dos.writeUTF( "enry Alfred Kissinger" );
      dos.writeByte( 27 );
      dos.writeShort( 5 );
      dos.writeInt( 1923 );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    //end::solution[]
  }
}