package com.tutego.exercise.device.sgxrwy;

public class Radio {

  //tag::solution[]
  private boolean isOn;
  private int volume;
  private double frequency;

  public void setFrequency( double frequency ) {
    this.frequency = frequency;
  }

  public double getFrequency() {
    return frequency;
  }

  public int getVolume() {
    return volume;
  }

  public String toString() {
    return "Radio[volume=" + volume + ", isOn=" + isOn + ", frequency=" + frequency + ']';
  }
  //end::solution[]

  void volumeUp() {}

  void volumeDown() {}

  void on() {
    isOn = true;
  }

  void off() {
    isOn = false;
  }

  boolean isOn() {
    return isOn;
  }
}
