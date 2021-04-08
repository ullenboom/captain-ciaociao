package com.tutego.exercise.device.hthiin;

class ElectronicDevice {
  void on() { System.out.println( "on" ); }

  void off() { System.out.println( "off" ); }
}

//tag::solution[]
public class Firebox extends ElectronicDevice {
  public Firebox() {
    on();
  }
  @Override void off() {
    System.out.println( "A firebox is always on, you can't switch it off" );
  }
}
//end::solution[]
