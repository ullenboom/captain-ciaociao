package com.tutego.exercise.device.mkwrrt;

import java.util.ArrayList;

public class Ship {

  private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

  public void load( ElectronicDevice device ) {
    devices.add( device );
  }

  //tag::solution[]
  public void holiday() {
    for ( ElectronicDevice device : devices )
      device.off();
  }
  //end::solution[]
}