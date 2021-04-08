package com.tutego.exercise.device.bhdavq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class Ship {

  private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

  public void load( ElectronicDevice device ) {
    devices.add( device );
  }

  //tag::solution1[]
  public ElectronicDevice findMostPowerConsumingElectronicDevice() {
    if ( devices.isEmpty() )
      throw new IllegalStateException( "Ship has no devices, there can't be a maximum in an empty collection" );
    return Collections.max( devices, new ElectronicDeviceWattComparator() );
  }
  //end::solution1[]

  //tag::solution2[]
  private final static int MAXIMUM_POWER_CONSUMPTION = 1000;

  public void removePowerConsumingElectronicDevices() {
    class IsPowerConsumingElectronicDevice implements Predicate<ElectronicDevice> {
      @Override public boolean test( ElectronicDevice electronicDevice ) {
        return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
      }
    }
    devices.removeIf( new IsPowerConsumingElectronicDevice() );
  }
  //end::solution2[]
}