package com.tutego.exercise.device.bhdavq;

//tag::solution[]
public class ElectronicDevice {

  private int watt;

  public int getWatt() {
    return watt;
  }

  public void setWatt( int watt ) {
    this.watt = watt;
  }

  @Override public String toString() {
    return "ElectronicDevice[watt=" + watt / 1000 + "kW]";
  }
}
//end::solution[]
