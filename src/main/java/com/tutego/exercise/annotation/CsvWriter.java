package com.tutego.exercise.annotation;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//tag::solution[]
public class CsvWriter<T> implements AutoCloseable {

  private final List<Field> fields;
  private final Class<?> clazz;
  private final Writer writer;
  private char delimiter = ';';

  public CsvWriter( Class<T> clazz, Writer writer ) {
    if ( ! clazz.isAnnotationPresent( Csv.class ) )
      throw new IllegalArgumentException(
          "Given class is not annotated with @Csv" );

    fields = Arrays.stream( clazz.getDeclaredFields() )
                   .filter( field -> field.isAnnotationPresent( CsvColumn.class ) )
                   .collect( Collectors.toList() );

    if ( fields.isEmpty() )
      throw new IllegalArgumentException(
          "Class does not contain any @CsvColumn" );

    this.clazz = clazz;
    this.writer = Objects.requireNonNull( writer );
  }

  public CsvWriter<T> delimiter( char delimiter ) {
    this.delimiter = delimiter;
    return this;
  }

  public void write( Iterable<? extends T> iterable ) {
    iterable.forEach( this::writeObject );
  }

  public void writeObject( T object ) {

    if ( ! clazz.isInstance( object ) )
      throw new IllegalArgumentException(
            "Argument is of type " + object.getClass().getSimpleName()
          + " but must be of type " + clazz.getSimpleName() );

    String line = fields.stream()
                        .map( field -> getFieldValue( object, field ) )
                        .collect( Collectors.joining( Character.toString( delimiter ),
                                                      "", "\n" ) );
    try {
      writer.write( line );
    }
    catch ( IOException e ) {
      throw new UncheckedIOException( e );
    }
  }

  private String getFieldValue( Object object, Field field ) {
    try {
      Object fieldValue = field.get( object );

      if ( fieldValue == null )
        return "";

      String format = field.getAnnotation( CsvColumn.class ).format();
      if ( format.trim().isEmpty() )
        return Objects.toString( fieldValue );

      if ( isNumericType( fieldValue ) )
        return new DecimalFormat( format ).format( fieldValue );

      throw new IllegalStateException( "Only numeric types can be formatted, but type was "
                                         + fieldValue.getClass().getSimpleName() );
    }
    catch ( IllegalAccessException e ) {
      throw new RuntimeException( e );
    }
  }

  private static boolean isNumericType( Object value ) {
    return Stream.of( Integer.class, Long.class, Double.class,
                      BigInteger.class, BigDecimal.class )
                 .anyMatch( clazz -> clazz.isInstance( value ) );
  }

  @Override public void close() {
    try {
      writer.close();
    }
    catch ( IOException e ) {
      throw new UncheckedIOException( e );
    }
  }
}
//end::solution[]
