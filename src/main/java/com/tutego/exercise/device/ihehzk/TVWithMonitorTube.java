package com.tutego.exercise.device.ihehzk;

//tag::solution[]
class MonitorTube {

  private final TV tv;

  public MonitorTube( TV tv ) {
    this.tv = tv;
  }

  public TV getTv() {
    return tv;
  }
  
  public void on() {
    System.out.println( "Tube is on." );
  }

  public void off() {
    System.out.println( "Tube is off." );
  }
}

class TV {

  private boolean isOn;
  private final MonitorTube tube = new MonitorTube( this );

  public void on() {
    isOn = true;
    System.out.println( "TV is on." );
    tube.on();
  }

  public void off() {
    isOn = false;
    System.out.println( "TV is off." );
    tube.off();
  }

  public String toString() {
    return String.format( "TV[on?=%s]", isOn );
  }
}
//end::solution[]

public class TVWithMonitorTube {

  public static void main( String[] args ) {
    TV tv = new TV();
    tv.on();
    tv.off();
  }
}