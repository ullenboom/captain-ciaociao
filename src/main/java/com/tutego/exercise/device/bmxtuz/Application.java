package com.tutego.exercise.device.bmxtuz;

//tag::solution[]
public class Application {

  public static void main( String[] args ) {
    Radio grandmasOldRadio = new Radio();

    grandmasOldRadio.isOn = true;
    grandmasOldRadio.volume = 12;

    System.out.println( "Current volume: " + grandmasOldRadio.volume );
  }
}
//end::solution[]
