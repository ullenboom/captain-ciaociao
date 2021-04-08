package com.tutego.exercise.device.bhdavq;

//tag::solution[]
import java.util.Comparator;

public class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {

  @Override
  public int compare( ElectronicDevice ea1, ElectronicDevice ea2 ) {
    System.out.println( ea1 + " is compared with " + ea2 );
    return Double.compare( ea1.getWatt(), ea2.getWatt() );
  }
}
//end::solution[]
