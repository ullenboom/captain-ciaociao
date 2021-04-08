package com.tutego.exercise.device.ewslfg;

import java.util.Objects;

public class Radio {

  private boolean isOn;
  private int volume;
  private double frequency;

  //tag::solution[]
  private Modulation modulation = Modulation.AM;

  public void setModulation( Modulation modulation ) {
    this.modulation = Objects.requireNonNull( modulation );
  }

  public Modulation getModulation() {
    return modulation;
  }
  //end::solution[]

  // methods for volume, frequency and isOn and toString omitted
}
