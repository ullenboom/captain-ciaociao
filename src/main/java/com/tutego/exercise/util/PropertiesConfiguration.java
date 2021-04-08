package com.tutego.exercise.util;

import java.math.BigInteger;
import java.util.*;

//tag::solution[]
public class PropertiesConfiguration {
  private final Properties properties;

  public PropertiesConfiguration( Properties properties ) {
    this.properties = properties;
  }

  public Optional<String> getString( String key ) {
    return Optional.ofNullable( properties.getProperty( key ) );
  }

  public Optional<Boolean> getBoolean( String key ) {
    try { return getString( key ).map( Boolean::valueOf ); }
    catch ( Exception e ) { return Optional.empty(); }
  }

  public Optional<BigInteger> getBigInteger( String key ) {
    try { return getString( key ).map( BigInteger::new ); }
    catch ( Exception e ) { return Optional.empty(); }
  }

  public OptionalDouble getDouble( String key ) {
    try { return OptionalDouble.of( Double.parseDouble( properties.getProperty( key ) ) ); }
    catch ( Exception e ) { return OptionalDouble.empty(); }
  }

  public OptionalLong getLong( String key ) {
    try { return OptionalLong.of( Long.parseLong( properties.getProperty( key ) ) ); }
    catch ( Exception e ) { return OptionalLong.empty(); }
  }

  public List<String> getList( String key ) {
    List<String> result = getString( key )
                              .map( s -> s.split( "\\s*(?<!\\\\),\\s*" ) )
                              .map( Arrays::asList )
                              .orElse( Collections.emptyList() );
    result.replaceAll( string -> string.replace( "\\,", "," ) );
    return result;
  }

  public void putBinary( String key, byte[] bytes ) {
    String base64 = Base64.getEncoder().encodeToString( bytes );
    properties.setProperty( key, base64 );
  }

  public Optional<byte[]> getBinary( String key ) {
    return getString( key ).map( base64 -> Base64.getDecoder().decode( base64 ) );
  }
}
//end::solution[]

class PropertiesConfigurationDemo {
  public static void main( String[] args ) {
    Properties root = new Properties();
    root.setProperty( "likes-rum", "true" );
    root.setProperty( "age", "55" );
    root.setProperty( "income", "123456789012" );
    root.setProperty( "hobbies", "drinking, gambling\\, games, swearing competitions" );
    root.setProperty( "weakness_of_character", "" );

    PropertiesConfiguration conf = new PropertiesConfiguration( root );
    Optional<Boolean> maybeLikesRum = conf.getBoolean( "likes-rum" );
    OptionalLong maybeAge = conf.getLong( "age" );
    Optional<BigInteger> maybeIncome = conf.getBigInteger( "income" );
    List<String> hobbies = conf.getList( "hobbies" );
    List<String> weaknessOfCharacter = conf.getList( "weakness_of_character" );

    System.out.println( maybeLikesRum );       // Optional[true]
    System.out.println( maybeAge );            // OptionalLong[55]
    System.out.println( maybeIncome );         // Optional[123456789012]
    System.out.println( hobbies );             // [drinking, gambling, games, swearing competitions]
    System.out.println( hobbies.size() );      // 3
    System.out.println( weaknessOfCharacter ); // []
    System.out.println( conf.getString( "is_idiot" ).orElse( "false" ) );

    conf.putBinary( "binary", new byte[]{ 0, 1, 127, (byte) 254, (byte) 255 } );
    System.out.println( conf.getString( "binary" ) ); // Optional[AAF//v8=]
    byte[] binary = conf.getBinary( "binary" ).get();
    System.out.printf( "%d %d %d %d %d", binary[0], binary[1], binary[2], binary[3], binary[4] );
  }
}