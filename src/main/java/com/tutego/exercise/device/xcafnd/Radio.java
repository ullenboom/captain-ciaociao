package com.tutego.exercise.device.xcafnd;

//tag::solution[]
public class Radio {

  boolean isOn;
  int volume;

  void changeVolume( int value ) {
    volume = Math.min( Math.max( volume + value, 0 ), 100 );
  }

  void volumeUp() {
    changeVolume( 1 );
  }

  void volumeDown() {
    changeVolume( -1 );
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

  public String toString() {
    return "Radio[volume=" + volume + ", is " + (isOn ? "on" : "off") + "]";
  }
}
//end::solution[]
