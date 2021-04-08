package com.tutego.exercise.device.oxujap;

//tag::solution[]
class RadioStations {
  public static final String SEA_101_STATION_NAME = "sea 101";
  public static final double SEA_101_FREQUENCY = 101.0;
}

class Radio {
  public static double stationNameToFrequency( String station ) {

    if ( station == null )
      return 0.0;

    switch ( station.trim().toLowerCase() ) {
      case "walking the plank":
        return 98.3;

      case RadioStations.SEA_101_STATION_NAME:
        return RadioStations.SEA_101_FREQUENCY;

      default:
        return 0.0;
    }
  }

  // other methods omitted
}
//end::solution[]
