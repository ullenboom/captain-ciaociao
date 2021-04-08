package com.tutego.exercise.io;

import java.io.*;

public class CountedInputStream extends FilterInputStream {

  private int bytesRead;

  public CountedInputStream( InputStream in ) {
    super( in );
  }

  @Override
  public int read() throws IOException {
    int b = in.read();
    bytesRead++;
    return b;
  }

  @Override
  public int read( byte[] b ) throws IOException {
    return read( b, 0, b.length );
  }

  @Override
  public int read( byte[] b, int offset, int len ) throws IOException {
    int readCount = in.read( b, 0, b.length );
    bytesRead += readCount;
    return readCount;

  }

  @Override
  public long skip( long n ) throws IOException {
    long skipCount = in.skip( n );
    bytesRead += (int) skipCount;
    return skipCount;
  }

  public int getBytesRead() {
    return bytesRead;
  }
}