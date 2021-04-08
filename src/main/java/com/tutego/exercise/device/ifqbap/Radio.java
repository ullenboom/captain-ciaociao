package com.tutego.exercise.device.ifqbap;

public class Radio {

  public enum Modulation {
    AM, FM
  }

  private boolean isOn;
  private int volume;
  private double frequency;
  private Modulation modulation = Modulation.AM;

  public Radio() {
  }

  public Radio( double frequency ) {
    setFrequency( frequency );
  }

  public Radio( String station ) {
    this( stationNameToFrequency( station ) );
  }

  //tag::solution[]
  public Radio( Radio other ) {
    setFrequency( other.frequency );
    setModulation( other.getModulation() );
    if ( other.isOn() ) on(); else off();
    this.volume = other.volume;
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

  public void on() {
    isOn = true;
  }

  public void off() {
    isOn = false;
  }

  public boolean isOn() {
    return isOn;
  }
}