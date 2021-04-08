package com.tutego.exercise.lang.exception;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaughingMyArseOff {

  public static void main( String[] args ) {
    String filename = "alf-lach.wav";
    play( filename );
  }

  //tag::solution[]
  static void play( String filename ) {
    try {
      Clip clip = AudioSystem.getClip();
      clip.open( AudioSystem.getAudioInputStream( new File( filename ) ) );
      clip.start();
      TimeUnit.MICROSECONDS.sleep( clip.getMicrosecondLength() + 50 );
      clip.close();
    }
    catch ( LineUnavailableException e ) {
      System.err.println( "Line cannot be opened because it is unavailable" );
    }
    catch ( IOException e ) {
      System.err.println( "An I/O exception of some sort has occurred" );
    }
    catch ( UnsupportedAudioFileException e ) {
      System.err.printf(
          "File %s did not contain valid data of a recognized file type and format%n", filename );
    }
    catch ( InterruptedException e ) {
      // No-op
    }
    catch ( RuntimeException e ) {
      Logger.getLogger( LaughingMyArseOff.class.getSimpleName() )
            .log( Level.SEVERE, e.getMessage(), e );
    }
  }
  //end::solution[]
}