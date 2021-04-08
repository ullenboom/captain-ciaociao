package com.tutego.exercise.device.jkvzow;

//tag::solution[]
class ElectronicDevice {

  private boolean isOn;

  public void on() {
    isOn = true;
  }

  public void off() {
    isOn = false;
  }

  boolean isOn() {
    return isOn;
  }

  public String toString() {
    return "ElectronicDevice[is " + (isOn ? "on" : "off") + "]";
  }
}

class IceMachine extends ElectronicDevice {
}

class Radio extends ElectronicDevice {
  int volume;
}
//end::solution[]

public class ElectronicDevices {
  public static void main( String[] args ) {
    Radio radio = new Radio();
    radio.on();
    System.out.println( radio );
    IceMachine cullen = new IceMachine();
    cullen .on();
  }
}
