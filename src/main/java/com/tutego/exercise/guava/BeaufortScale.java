package com.tutego.exercise.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.util.Arrays;
import java.util.List;

//tag::solution[]
public class BeaufortScale {

  private final RangeMap<Integer, Integer> bftRanges = TreeRangeMap.create();

  BeaufortScale() {
    List<Range<Integer>> ranges = Arrays.asList(
        Range.closed( 0, 1 ), Range.closed( 1, 5 ), Range.closed( 6, 11 ), Range.closed( 12, 19 ),
        Range.closed( 20, 28 ), Range.closed( 29, 38 ), Range.closed( 39, 49 ), Range.closed( 50, 61 ),
        Range.closed( 62, 74 ), Range.closed( 75, 88 ), Range.closed( 89, 102 ),
        Range.closed( 103, 117 ), Range.greaterThan( 117 ) );
    for ( int bft = 0; bft < ranges.size(); bft++ )
      bftRanges.put( ranges.get( bft ), bft );
  }

  public int convertWindSpeedToBft( int windSpeed ) {
    if ( windSpeed < 0 )
      throw new IllegalArgumentException( "wind speed has to be 0 or positive but was " + windSpeed );
    return bftRanges.get( windSpeed );
  }
}
//end::solution[]

class BeaufortScaleDemo {
  public static void main( String[] args ) {
    System.out.println( new BeaufortScale().convertWindSpeedToBft( 0 ) );
    System.out.println( new BeaufortScale().convertWindSpeedToBft( 1 ) );
    System.out.println( new BeaufortScale().convertWindSpeedToBft( 12 ) );
    System.out.println( new BeaufortScale().convertWindSpeedToBft( 140 ) );
    System.out.println( new BeaufortScale().convertWindSpeedToBft( -1 ) );
  }
}