package com.tutego.exercise.device.biwdxj;

public class Radio {

  public enum Modulation {
    AM, FM
  }

  private boolean isOn;
  private int volume;
  private double frequency;
  private Modulation modulation = Modulation.AM;

  //tag::solution[]
  public Radio() {
  }

  public Radio( double frequency ) {
    setFrequency( frequency );
  }

  public Radio( String station ) {
    this( stationNameToFrequency( station ) );
  }
  //end::solution[]

  private static double stationNameToFrequency( String station ) {
    return 0;
  }

  public void setModulation( Modulation modulation ) {
    this.modulation = modulation;
  }

  public Modulation getModulation() {
    return modulation;
  }

  void setFrequency( double frequency ) {
    this.frequency = frequency;
  }

  // other methods omitted
}