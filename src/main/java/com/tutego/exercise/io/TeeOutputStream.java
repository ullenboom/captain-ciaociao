package com.tutego.exercise.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

//tag::solution[]
public class TeeOutputStream extends OutputStream {

  private final OutputStream branch1;
  private final OutputStream branch2;

  public TeeOutputStream( OutputStream branch1, OutputStream branch2 ) {
    this.branch1 = branch1;
    this.branch2 = branch2;
  }

  @Override
  public void write( byte[] bytes ) throws IOException {
    try { branch1.write( bytes ); }
    finally { branch2.write( bytes ); }
  }

  @Override
  public void write( byte[] bytes, int off, int len ) throws IOException {
    try { branch1.write( bytes, off, len ); }
    finally { branch2.write( bytes, off, len ); }
  }

  @Override
  public void write( int b ) throws IOException {
    IOException e1 = null, e2 = null;
    try { branch1.write( b ); }
    catch ( IOException e ) { e1 = e; }
    finally {
      try { branch2.write( b ); }
      catch ( IOException e ) { e2 = e; }
      if ( e1 == null && e2 == null ) return;
      if ( e1 != null && e2 == null ) throw e1;
      if ( e1 == null && e2 != null ) throw e2;
      e1.addSuppressed( e2 );
      throw e1;
    }
  }

  @Override
  public void flush() throws IOException {
    try { branch1.flush(); }
    finally { branch2.flush(); }
  }

  @Override
  public void close() throws IOException {
    try { branch1.close(); }
    finally { branch2.close(); }
  }
}
//end::solution[]

class TeeOutputStreamDemo {
  public static void main( String[] args ) throws IOException {
    //tag::example[]
    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();

    try ( OutputStream tos = new TeeOutputStream( baos1, baos2 );
          Writer ost = new OutputStreamWriter( tos, StandardCharsets.UTF_8 );
          PrintWriter pw = new PrintWriter( ost ) ) {
      pw.print( "Hey" );
      pw.write( '\n' );
      pw.printf( "%d times %d equals %d", 2, 3, 4 );
    }

    System.out.println( baos1.toString( StandardCharsets.UTF_8 ) );
    System.out.println( baos2.toString( StandardCharsets.UTF_8 ) );
    //end::example[]
  }
}