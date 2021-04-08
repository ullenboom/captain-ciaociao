package com.tutego.exercise.oop;

//tag::solution[]
class DistanceImplementation implements Distance {

  private final int value;

  DistanceImplementation( int value ) {
    this.value = value;
  }

  @Override public int meter() {
    return value;
  }
}

public interface Distance {
  static Distance ofMeter( int value ) {
    return new DistanceImplementation( value );
  }

  static Distance ofKilometer( int value ) {
    return new DistanceImplementation( value * 1000 );
  }

  int meter();

  default int kilometer() {
    return meter() / 1000;
  }
}
//end::solution[]

class DistanceDemo {
  public static void main( String[] args ) {
    Distance oneKm = Distance.ofKilometer( 1 );
    System.out.printf( "1 km = %d km, %d m%n", oneKm.kilometer(), oneKm.meter() );

    Distance moreMeter = Distance.ofMeter( 12345 );
    System.out.printf( "12345 m = %d km, %d m", moreMeter.kilometer(), moreMeter.meter() );
  }
}
