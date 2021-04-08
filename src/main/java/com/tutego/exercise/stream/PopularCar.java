package com.tutego.exercise.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PopularCar {
  public static void main( String[] args ) {
    String[] cars = {
        "Gurkha RPV", "Mercedes-Benz G 63 AMG", "BMW 750", "Toyota Land Cruiser",
        "Mercedes-Benz G 63 AMG", "Volkswagen T5", "BMW 750", "Gurkha RPV", "Dartz Prombron",
        "Marauder", "Gurkha RPV" };

    //tag::solution-a[]
    Map<String, Long> map1 =
        Arrays.stream( cars )
              .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );

    map1.entrySet().removeIf( stringLongEntry -> stringLongEntry.getValue() < 2 );
    //end::solution-a[]
    System.out.println( map1 );

    //tag::solution-b[]
    Collector<Object, long[], Boolean> collector = Collector.of(
        () -> new long[1],                     // Supplier<A> supplier
        (array, string) -> array[0]++,         // BiConsumer<A,T> accumulator
        (array1, array2 ) -> { array1[0] += array2[0]; return array1; }, // BinaryOperator<A> combiner
        array -> array[0] > 1 );               // Function<A,R> finisher

    Map<String, Boolean> map2 =
        Arrays.stream( cars ).collect( Collectors.groupingBy( Function.identity(), collector ) );
    //end::solution-b[]
    System.out.println( map2 );
  }
}
