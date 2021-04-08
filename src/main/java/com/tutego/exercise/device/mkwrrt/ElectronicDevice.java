package com.tutego.exercise.device.mkwrrt;

public class ElectronicDevice {

  boolean isOn;
  private int watt;

  public int getWatt() {
    return watt;
  }

  public void setWatt( int watt ) {
    this.watt = watt;
  }

  void on() {
    isOn = true;
  }

  void off() {
    isOn = false;
  }

  boolean isOn() {
    return isOn;
  }

  //tag::solution[]
  public static int numberOfElectronicDevicesSwitchedOn( ElectronicDevice... devices ) {
    int result = 0;

    for ( ElectronicDevice device : devices )
      if ( device.isOn )
        result++;
    
    return result;
  }
  //end::solution[]
}
