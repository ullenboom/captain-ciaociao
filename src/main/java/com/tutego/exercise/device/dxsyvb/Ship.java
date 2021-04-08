package com.tutego.exercise.device.dxsyvb;

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

    if ( device instanceof Radio ) {
      if ( ((Radio) device).getVolume() == 0 )
        return;
      System.out.println( "Radio wurde hinzugefügt, schon GEZahlt?" );
    }

    devices.add( device );
  }
}
//end::solution[]
