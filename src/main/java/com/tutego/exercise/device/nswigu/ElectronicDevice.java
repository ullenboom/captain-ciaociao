package com.tutego.exercise.device.nswigu;

public class ElectronicDevice {

  private int watt;

  //tag::solution[]
  public void setWatt( int watt ) {
    if ( watt <= 0 )
      throw new IllegalWattException( "Watt cannot be 0 or negative, but was %f", watt );
    this.watt = watt;
  }
  //end::solution[]
}
