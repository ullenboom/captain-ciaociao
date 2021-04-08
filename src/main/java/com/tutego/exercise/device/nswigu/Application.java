package com.tutego.exercise.device.nswigu;

public class Application {
  public static void main( String[] args ) {
    //tag::solution[]
    ElectronicDevice gameGirl = new ElectronicDevice();
    try {
      gameGirl.setWatt( 0 );
    }
    catch ( IllegalWattException e ) {
      e.printStackTrace();
    }
    //end::solution[]
  }
}