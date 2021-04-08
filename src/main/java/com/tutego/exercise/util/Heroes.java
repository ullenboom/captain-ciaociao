package com.tutego.exercise.util;

//tag::heroes[]
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Heroes {

  private Heroes() { }

  public static class Hero {

    public enum Sex { MALE, FEMALE }

    public final String name;
    public final Sex    sex;
    public final int    yearFirstAppearance;

    public Hero( String name, Sex sex, int yearFirstAppearance ) {
      this.name = Objects.requireNonNull( name );
      this.sex  = Objects.requireNonNull( sex );
      this.yearFirstAppearance = yearFirstAppearance;
    }

    @Override public String toString() {
      return String.format( "Hero[name=%s, sex=%s, yearFirstAppearance=%s]",
                            name, sex, yearFirstAppearance );
    }
  }

  public static class Universe {
    private final String name;
    private final List<Hero> heroes;

    public Universe( String name, List<Hero> heroes ) {
      this.name   = Objects.requireNonNull( name );
      this.heroes = Objects.requireNonNull( heroes );
    }

    public String name() { return name; }
    public Stream<Hero> heroes() { return heroes.stream(); }
  }

  // https://github.com/fivethirtyeight/data/tree/master/comic-characters
  private static final Hero DEADPOOL = new Hero( "Deadpool (Wade Wilson)", Hero.Sex.MALE, 1991 );
  private static final Hero LANA_LANG = new Hero( "Lana Lang", Hero.Sex.FEMALE, 1950 );
  private static final Hero THOR = new Hero( "Thor (Thor Odinson)", Hero.Sex.MALE, 1950 );
  private static final Hero IRON_MAN = new Hero( "Iron Man (Anthony 'Tony' Stark)", Hero.Sex.MALE, 1963 );
  private static final Hero SPIDERMAN = new Hero( "Spider-Man (Peter Parker)", Hero.Sex.MALE, 1962 );
  private static final Hero WONDER_WOMAN = new Hero( "Wonder Woman (Diana Prince)", Hero.Sex.FEMALE, 1941 );
  private static final Hero CAPTAIN_AMERICA = new Hero( "Captain America (Steven Rogers)", Hero.Sex.MALE, 1941 );
  private static final Hero SUPERMAN = new Hero( "Superman (Clark Kent)", Hero.Sex.MALE, 1938 );
  private static final Hero BATMAN = new Hero( "Batman (Bruce Wayne)", Hero.Sex.MALE, 1939 );

  public static final List<Hero> DC =
      Collections.unmodifiableList( Arrays.asList( SUPERMAN, LANA_LANG, WONDER_WOMAN, BATMAN ) );

  public static final List<Hero> MARVEL =
      Collections.unmodifiableList( Arrays.asList( DEADPOOL, CAPTAIN_AMERICA, THOR, IRON_MAN, SPIDERMAN ) );

  public static final List<Hero> ALL =
      Collections.unmodifiableList( Stream.concat( DC.stream(), MARVEL.stream() ).collect( Collectors.toList() ) );

  public static final List<Universe> UNIVERSES =
      Collections.unmodifiableList( Arrays.asList(
          new Universe( "DC", DC ), new Universe( "Marvel", MARVEL ) ) );
}
//end::heroes[]
