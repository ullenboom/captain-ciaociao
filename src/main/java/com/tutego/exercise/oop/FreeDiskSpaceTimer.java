package com.tutego.exercise.oop;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

//tag::solution[]
public class FreeDiskSpaceTimer {
  public static void main( String[] args ) {
    final int REPETITION_PERIOD = 2000 /* ms */;
    new Timer().schedule( new FreeDiskSpaceTimerTask(), 0, REPETITION_PERIOD );
  }
}

class FreeDiskSpaceTimerTask extends TimerTask {
  private static final long MIN_CAPACITY = 100_000_000_000L;
  private final File root = File.listRoots()[ 0 ];

  @Override public void run() {
    long freeDiskSpace = root.getFreeSpace();
    if ( freeDiskSpace < MIN_CAPACITY )
      System.out.printf(
          "Device %s has less than %,d byte available, currently %,d byte%n",
          root, MIN_CAPACITY, freeDiskSpace );
  }
}
//end::solution[]
