package com.tutego.exercise.device.luyyrl;

import java.util.ArrayList;

//tag::solution[]
class Ship {
  private final ArrayList<Radio> radios = new ArrayList<>();

  public void load( Radio radio ) {
    radios.add( radio );
  }

  public int numberOfRadiosSwitchedOn() {
    int result = 0;

    for ( Radio radio : radios )
      if ( radio.isOn )
        result++;

    return result;
  }

  public String toString() {
    return "Ship[" + radios + "]";
  }
}
//end::solution[]

class Radio {
  boolean isOn;
}

public class Application {

  public static void main( String[] args ) {
    Ship h1 = new Ship();
    Radio radio1 = new Radio();
    radio1.isOn = true;
    Radio radio2 = new Radio();
    radio2.isOn = true;
    Radio radio3 = new Radio();
    h1.load( radio1 );
    h1.load( radio2 );
    h1.load( radio3 );
    System.out.println( h1 );
    System.out.println( h1.numberOfRadiosSwitchedOn() ); // 2
  }
}
