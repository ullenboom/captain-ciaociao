package com.tutego.exercise.device.bhdavq;

public class Application {

  public static void main( String[] args ) {
    //tag::example[]
    Radio grannysRadio = new Radio();
    grannysRadio.volumeUp();
    grannysRadio.setWatt( 12_000 );

    TV grandpasTv = new TV();
    grandpasTv.setWatt( 1000 );

    Ship ship = new Ship();
    ship.load( grannysRadio );
    ship.load( grandpasTv );
    System.out.println( ship.findMostPowerConsumingElectronicDevice().getWatt() );
    //end::example[]
  }
}
