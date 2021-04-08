package com.tutego.exercise.lang;

public class DistanceImplementations {

  interface Distance {
    double distance( double x1, double y1, double x2, double y2 );
    double distance( double x1, double y1, double z1, double x2, double y2, double z2 );
  }

  static class DistanceImplementation1 {
    //tag::solution1[]
    enum Distances implements Distance {
      EUCLIDEAN;

      @Override
      public double distance( double x1, double y1, double x2, double y2 ) {
        return Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) );
      }
      @Override
      public double distance( double x1, double y1, double z1, double x2, double y2, double z2 ) {
        return Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2) );
      }
    }
    //end::solution1[]
  }

  static class DistanceImplementation2 {
    //tag::solution2[]
    enum Distances implements Distance {
      EUCLIDEAN {
        @Override
        public double distance( double x1, double y1, double x2, double y2 ) {
          return Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) );
        }

        @Override
        public double distance( double x1, double y1, double z1, double x2, double y2, double z2 ) {
          return Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2) );
        }
      },
      MANHATTAN {
        @Override
        public double distance( double x1, double y1, double x2, double y2 ) {
          return Math.abs( x1 - x2 ) + Math.abs( y1 - y2 );
        }

        @Override
        public double distance( double x1, double y1, double z1, double x2, double y2, double z2 ) {
          return Math.abs( x1 - x2 ) + Math.abs( y1 - y2 ) + Math.abs( z1 - z2 );
        }
      }
    }
    //end::solution2[]
  }
}
