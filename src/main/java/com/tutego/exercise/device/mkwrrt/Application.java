package com.tutego.exercise.device.mkwrrt;

public class Application {
  public static void main( String[] args ) {
    //tag::example[]
    Radio bedroomRadio = new Radio();
    bedroomRadio.volumeUp();
    Radio cabooseRadio = new Radio();
    cabooseRadio.volumeUp();
    TV mainTv = new TV();
    Radio crRadio = new Radio();
    Firebox alarm = new Firebox();
    Ship ship = new Ship();
    ship.load( bedroomRadio );
    ship.load( cabooseRadio );
    ship.load( mainTv );
    ship.load( crRadio );
    ship.load( alarm );
    ship.holiday();
    //end::example[]
  }
}
