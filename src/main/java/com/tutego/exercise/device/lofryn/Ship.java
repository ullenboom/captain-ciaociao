package com.tutego.exercise.device.lofryn;

import java.util.ArrayList;
import java.util.Objects;

class ElectronicDevice {
}

class Radio extends ElectronicDevice {

  public double getVolume() {
    return 11;
  }
}

//tag::solution[]
public class Ship {

  private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

  public void load( ElectronicDevice device ) {
    Objects.requireNonNull( device );
    devices.add( device );
  }
}
//end::solution[]
