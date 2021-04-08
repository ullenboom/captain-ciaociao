package com.tutego.exercise.stream;

import com.tutego.exercise.util.Heroes;
import com.tutego.exercise.util.Heroes.Hero;
import com.tutego.exercise.util.Heroes.Hero.Sex;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaHeroes {

  public static void main( String[] args ) {
    List<Hero> heroes = Heroes.ALL;

    // 1.1. Output all information about heroes in CSV format on the screen.
    //tag::solution-1a[]
    Consumer<Hero> csvPrinter =
        hero -> System.out.printf( "%s,%s,%s%n", hero.name, hero.sex, hero.yearFirstAppearance );
    heroes.stream().forEach( csvPrinter );
    //end::solution-1a[]

    // 1.2. Check if all heroes were introduced after 1900.
    //tag::solution-1b[]
    Predicate<Hero> isAppearanceAfter1900 = hero -> hero.yearFirstAppearance >= 1900;
    System.out.println( heroes.stream().allMatch( isAppearanceAfter1900 ) );
    //end::solution-1b[]

    // 1.3. Check if any female hero was introduced after 1950 (inclusive).
    //tag::solution-1c[]
    Predicate<Hero> isFemale = hero -> hero.sex == Sex.FEMALE;
    Predicate<Hero> isAppearanceAfter1950 = hero -> hero.yearFirstAppearance >= 1950;
    System.out.println( heroes.stream().anyMatch( isFemale.and( isAppearanceAfter1950 ) ) );
    //end::solution-1c[]

    // 1.4. Which hero shows up first?
    //tag::solution-1d[]
    Comparator<Hero> firstAppearanceComparator =
        Comparator.comparingInt( h -> h.yearFirstAppearance );
    System.out.println( heroes.stream().min( firstAppearanceComparator ) );
    //end::solution-1d[]

    // 1.5. Which hero first appeared around 1960?
    //tag::solution-1e[]
    System.out.println( heroes.stream().reduce( ( hero1, hero2 ) -> {
      int diff1 = Math.abs( 1960 - hero1.yearFirstAppearance );
      int diff2 = Math.abs( 1960 - hero2.yearFirstAppearance );
      return (diff1 < diff2) ? hero1 : hero2;
    } ) );
    //end::solution-1e[]

    // 1.6. A StringBuilder should be created, which contains all years separated by commas.
    //tag::solution-1f[]
    StringBuilder collectedYears =
        heroes.stream().collect(
            StringBuilder::new,
            ( sb, hero ) -> sb.append( sb.isEmpty() ? "" : "," )
                              .append( hero.yearFirstAppearance ),
            ( sb1, sb2 ) -> sb1.append( sb2.isEmpty() ? "" : "," + sb2 ) );
    System.out.println( collectedYears );
    //end::solution-1f[]

    // 1.7. Divide the male and female heroes into two groups.
    //tag::solution-1g[]
    Map<Sex, List<Hero>> sexListMap =
        heroes.stream().collect( Collectors.groupingBy( hero -> hero.sex ) );
    System.out.println( sexListMap );
    //end::solution-1g[]

    // 1.8. Make two partitions with heroes introduced before and after 1970.
    //tag::solution-1h[]
    Predicate<Hero> isAppearanceAfter1970 = hero -> hero.yearFirstAppearance >= 1970;
    Map<Boolean, List<Hero>> beforeAndAfter1970Partition =
        heroes.stream().collect( Collectors.partitioningBy( isAppearanceAfter1970 ) );
    System.out.println( beforeAndAfter1970Partition );
    //end::solution-1h[]

    // 2.1. How many female heroes are there in total?
    //tag::solution-2a[]
    System.out.println( Heroes.ALL.stream()
                              .filter( hero -> hero.sex == Sex.FEMALE )
                              .count() );
    //end::solution-2a[]

    // 2.2. Sort all heroes by their release date and then output all heroes.
    //tag::solution-2b[]
    Heroes.ALL.stream()
          .sorted( Comparator.comparingInt( hero -> hero.yearFirstAppearance ) )
          .forEach( System.out::println );
    //end::solution-2b[]

    // 2.3. a) Create a comma separated string with the names of all female heroes.
    //tag::solution-2c[]
    String femaleNames = Heroes.ALL.stream()
                               .filter( hero -> hero.sex == Sex.FEMALE )
                               .map( hero -> hero.name )
                               .collect( Collectors.joining( ", " ) );
    System.out.println( femaleNames );
    //end::solution-2c[]

    // 2.3. b) Convert the heroes into anonymous heroes.
    //tag::solution-2d[]
    Function<Hero, Hero> nameAnonymizer = hero ->
        new Hero( hero.name.replaceAll( "\\s*\\(.*\\)$", "" ),
                  hero.sex, hero.yearFirstAppearance );
    System.out.println( Heroes.ALL.stream().map( nameAnonymizer ).collect( Collectors.toList() ) );
    //end::solution-2d[]

    // 2.3. c) Create a distinct int[] with all years in which heroes were introduced.
    //tag::solution-2e[]
    int[] years = Heroes.ALL.stream()
        .mapToInt( hero -> hero.yearFirstAppearance )
        .distinct()
        .toArray();
    System.out.println( Arrays.toString( years ) );
    //end::solution-2e[]

    // 2.4. Go over UNIVERSES and not ALL to display the names of all heroes.
    //tag::solution-2f[]
    Heroes.UNIVERSES.stream()
          .flatMap( Heroes.Universe::heroes )
          .map( hero -> hero.name )
          .forEach( System.out::println );
    //end::solution-2f[]
  }
}
