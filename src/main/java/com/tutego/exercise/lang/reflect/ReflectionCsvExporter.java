package com.tutego.exercise.lang.reflect;

import java.awt.Point;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionCsvExporter {

  public static void main( String[] args ) throws IOException {
    Point p = new Point( 1, 2 );
    Point q = new Point( 3, 4 );
    List<?> list = Arrays.asList( p, q );
    Writer out = new StringWriter();
    writeAsCsv( list, out );
    System.out.println( out );
  }

  //tag::solution[]
  public static void writeAsCsv( List<?> objects, Appendable out ) throws IOException {
    for ( Object object : objects ) {
      String line =
          Arrays.stream( object.getClass().getFields() )
                .filter( f -> ! Modifier.isTransient( f.getModifiers() ) )
                .map( f -> accessField( f, object ) )
                .collect( Collectors.joining( ";" ) );
      out.append( line ).append( "\n" );
    }
  }

  private static String accessField( Field field, Object object ) {
    try {
      return field.get( object ).toString();
    }
    catch ( IllegalAccessException e ) {
      throw new RuntimeException( e );
    }
  }
  //end::solution[]
}
