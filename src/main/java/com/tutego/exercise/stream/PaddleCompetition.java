package com.tutego.exercise.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {
  String name;
  double time;

  Result( String name, double time ) {
    this.name = name;
    this.time = time;
  }
}

public class PaddleCompetition {

  public static void main1() {
    Stream<Result> stream =
        Stream.of( new Result( "Bareil Antos", 124.123 ), new Result( "Kimara Cretak", 434.22 ),
                   new Result( "Keyla Detmer", 321.34 ), new Result( "Amanda Grayson", 143.99 ),
                   new Result( "Mora Pol", 122.22 ), new Result( "Gen Rhys", 377.23 ) );

    //tag::solution-a[]
    DoubleSummaryStatistics statistics =
        stream.mapToDouble( result -> result.time ).summaryStatistics();

    System.out.printf( "count:   %d%n", statistics.getCount() );
    System.out.printf( "min:     %.2f%n", statistics.getMin() );
    System.out.printf( "max:     %.2f%n", statistics.getMax() );
    System.out.printf( "average: %.2f%n", statistics.getAverage() );
    //end::solution-a[]
  }

  public static void main2() {
    Stream<Result> stream =
        Stream.of( new Result( "Bareil Antos", 124.123 ), new Result( "Kimara Cretak", 434.22 ),
                   new Result( "Keyla Detmer", 321.34 ), new Result( "Amanda Grayson", 143.99 ),
                   new Result( "Mora Pol", 122.22 ), new Result( "Gen Rhys", 377.23 ) );
    //tag::solution-b[]
    DoubleSummaryStatistics statistics =
        stream.collect( Collectors.summarizingDouble( result -> result.time ) );
    //end::solution-b[]
    System.out.printf( "count:   %d%n", statistics.getCount() );
    System.out.printf( "min:     %.2f%n", statistics.getMin() );
    System.out.printf( "max:     %.2f%n", statistics.getMax() );
    System.out.printf( "average: %.2f%n", statistics.getAverage() );
  }

  public static void main( String[] args ) {
    main1();
    main2();
  }
}
