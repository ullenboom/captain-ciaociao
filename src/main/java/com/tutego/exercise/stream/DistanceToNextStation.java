package com.tutego.exercise.stream;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistanceToNextStation {
  public static void main( String[] args ) {
    Point.Double[] targets = { // Latitude, Longitude
                               new Point.Double( 44.7226698, 1.6716612 ),
                               new Point.Double( 50.4677807, -1.5833018 ),
                               new Point.Double( 44.7226698, 1.6716612 )
    };

    //tag::solution-a[]
    Function<Point.Double, Integer> distanceToCaptain =
        coordinate -> distance( coordinate.x, coordinate.y, 40.2390577, 3.7138939 );

    Map<Point.Double, Integer> map =
        Arrays.stream( targets )
              .distinct()
              .collect( Collectors.toMap( Function.identity(), distanceToCaptain ) );
    //end::solution-a[]
    System.out.println( map );

    //tag::solution-b[]
    map = Arrays.stream( targets )
                .collect( Collectors.toMap( Function.identity(), distanceToCaptain, (d,__) -> d ) );
    //end::solution-b[]
    System.out.println( map );
  }

  // Haversine formula
  private static int distance( double lat1, double lng1, double lat2, double lng2 ) {
    double earthRadius = 6371; // km
    double dLat = Math.toRadians( lat2 - lat1 );
    double dLng = Math.toRadians( lng2 - lng1 );
    double a = Math.sin( dLat / 2 ) * Math.sin( dLat / 2 ) +
        Math.cos( Math.toRadians( lat1 ) ) * Math.cos( Math.toRadians( lat2 ) ) *
            Math.sin( dLng / 2 ) * Math.sin( dLng / 2 );
    double d = 2 * Math.atan2( Math.sqrt( a ), Math.sqrt( 1 - a ) );
    return (int) (earthRadius * d);
  }
}
