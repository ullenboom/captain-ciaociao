package com.tutego.exercise.util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueArrayElements {
  //tag::solution[]
  public static double[] unique( double... values ) {

    if ( values.length < 2 )
      return values;

    Set<Double> valuesSet = new LinkedHashSet<>( values.length / 4 );

    for ( double value : values )
      valuesSet.add( value );

    if ( valuesSet.size() == values.length )
      return values;

    double[] result = new double[ valuesSet.size() ];
    int i = 0;
    for ( Double value : valuesSet )
      result[ i++ ] = value;

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    //tag::example[]
    System.out.println( Arrays.toString( unique() ) ); //                                    []
    System.out.println( Arrays.toString( unique( 1, 2 ) ) ); //                      [1.0, 2.0]
    System.out.println( Arrays.toString( unique( 1, 1 ) ) ); //                           [1.0]
    System.out.println( Arrays.toString( unique( 1, 2, 1 ) ) ); //                   [1.0, 2.0]
    System.out.println( Arrays.toString( unique( 1, 2, 1, Double.NaN ) ) ); //  [1.0, 2.0, NaN]
    System.out.println( Arrays.toString( unique( 1, Double.NaN, Double.NaN ) ) ); // [1.0, NaN]
    System.out.println( Arrays.toString( unique( -0, 0 ) ) ); //                [1.0, 2.0, NaN]
    //end::example[]
  }
}
