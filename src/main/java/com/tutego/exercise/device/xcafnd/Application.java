package com.tutego.exercise.device.xcafnd;

public class Application {
  public static void main( String[] args ) {
    //tag::main[]
    Radio grandmasOldRadio = new Radio();
    System.out.println( grandmasOldRadio.isOn() );     // false
    grandmasOldRadio.on();
    System.out.println( grandmasOldRadio.isOn() );     // true
    System.out.println( grandmasOldRadio.volume );     // 0
    grandmasOldRadio.volumeUp();
    grandmasOldRadio.volumeUp();
    grandmasOldRadio.volumeDown();
    grandmasOldRadio.volumeUp();
    System.out.println( grandmasOldRadio.volume );     // 2
    System.out.println( grandmasOldRadio.toString() ); // Radio[volume=2, is on]
    System.out.println( grandmasOldRadio );            // Radio[volume=2, is on]
    grandmasOldRadio.off();
    //end::main[]
  }
}