package com.tutego.exercise.device.vonmxo;

import java.util.Objects;

public class Radio {

  private boolean isOn;
  private int volume;
  private double frequency;

  //tag::solution[]
  private Modulation modulation = Modulation.AM;

  private static final double MIN_AM_FREQUENCY = 148.5 * 1000      /* Hz */;
  private static final double MAX_AM_FREQUENCY =  26.1 * 1_000_000 /* Hz */;
  private static final double MIN_FM_FREQUENCY =  87.5 * 1_000_000 /* Hz */;
  private static final double MAX_FM_FREQUENCY = 108.0 * 1_000_000 /* Hz */;

  private double minFrequency = MIN_AM_FREQUENCY;
  private double maxFrequency = MAX_AM_FREQUENCY;

  public void setModulation( Modulation modulation ) {
    this.modulation = Objects.requireNonNull( modulation );
    minFrequency = modulation == Modulation.AM ? MIN_AM_FREQUENCY : MIN_FM_FREQUENCY;
    maxFrequency = modulation == Modulation.AM ? MAX_AM_FREQUENCY : MAX_FM_FREQUENCY;
  }
  //end::solution[]

// methods for volume, frequency and isOn and toString omitted
}
