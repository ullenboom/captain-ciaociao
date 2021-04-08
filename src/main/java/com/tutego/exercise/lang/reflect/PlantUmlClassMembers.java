package com.tutego.exercise.lang.reflect;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlantUmlClassMembers {
  public static void main( String[] args ) {
    System.out.println( plantUml( Dimension.class ) );
    System.out.println( plantUml( Point.class ) );
    System.out.println( plantUml( ArrayList.class ) );
  }

  //tag::solution[]
  private static String plantUml( Class<?> clazz ) {

    StringWriter result = new StringWriter( 1024 );
    PrintWriter body = new PrintWriter( result );
    body.printf( "@startuml%nclass %s {%n", clazz.getSimpleName() );

    for ( Field field : clazz.getDeclaredFields() ) {
      String visibility = formatUmlVisibility( field );
      String type = field.getType().getSimpleName();
      body.printf( "   %s %s: %s%n", visibility, field.getName(), type );
    }

    for ( Constructor<?> method : clazz.getConstructors() ) {
      String visibility = formatUmlVisibility( method );
      String parameters = formatParameters( method.getParameters() );
      body.printf( "   %s %s(%s)%n", visibility, clazz.getSimpleName(), parameters );
    }

    for ( Method method : clazz.getDeclaredMethods() ) {
      String visibility = formatUmlVisibility( method );
      String parameters = formatParameters( method.getParameters() );
      String returnType = method.getReturnType().getSimpleName();
      body.printf( "   %s %s(%s): %s%n",
                   visibility, method.getName(), parameters, returnType );
    }

    body.println( "}\n@enduml" );
    return result.toString();
  }

  private static String formatParameters( Parameter[] parameters ) {
    return Arrays.stream( parameters )
                 .map( p -> p.getName() + ": " + p.getType().getSimpleName() )
                 .collect( Collectors.joining( ", " ) );
  }

  private static String formatUmlVisibility( Member field ) {
    return Modifier.isPrivate( field.getModifiers() )   ? "-" :
           Modifier.isPublic( field.getModifiers() )    ? "+" :
           Modifier.isProtected( field.getModifiers() ) ? "#" :
           "~";
  }
  //end::solution[]
}
