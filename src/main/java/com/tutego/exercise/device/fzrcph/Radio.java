//tag::solution[]
package com.tutego.exercise.device.fzrcph;

public class Radio {

  public enum Modulation {
    AM, FM
  }

  private Modulation modulation = Modulation.AM;

  public void setModulation( Modulation modulation ) {
    this.modulation = modulation;
  }

  // remaining fields and methods omitted
}
//end::solution[]
