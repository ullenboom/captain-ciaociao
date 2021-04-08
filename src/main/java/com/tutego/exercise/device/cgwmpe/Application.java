package com.tutego.exercise.device.cgwmpe;

import java.util.Comparator;

//tag::solution[]
public class Application {
  static class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {
    @Override public int compare( ElectronicDevice ea1, ElectronicDevice ea2 ) {
      return Double.compare( ea1.getWatt(), ea2.getWatt() );
    }
  }

  public static void main( String[] args ) {

    class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {
      @Override public int compare( ElectronicDevice ea1, ElectronicDevice ea2 ) {
        return Double.compare( ea1.getWatt(), ea2.getWatt() );
      }
    }

    Comparator<ElectronicDevice> wattComparator = new Comparator<>() {
      @Override public int compare( ElectronicDevice ea1, ElectronicDevice ea2 ) {
        return Double.compare( ea1.getWatt(), ea2.getWatt() );
      }
    };
  }
}
//end::solution[]
