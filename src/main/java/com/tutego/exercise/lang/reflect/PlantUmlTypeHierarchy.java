package com.tutego.exercise.lang.reflect;

public class PlantUmlTypeHierarchy {

  //tag::solution[]
  public static void visitType( Class<?> clazz ) {

    if ( clazz.getSuperclass() != null ) {
      System.out.printf( "%s <|-- %s%n",
                         clazz.getSuperclass().getSimpleName(),
                         clazz.getSimpleName() );
      visitType( clazz.getSuperclass() );
    }

    for ( Class<?> interfaze : clazz.getInterfaces() ) {
      System.out.printf( "%s <|.. %s%n",
                         interfaze.getSimpleName(),
                         clazz.getSimpleName() );
      visitType( interfaze );
    }
  }

  public static void main( String[] args ) throws ClassNotFoundException {
//    Class<?> clazz = Class.forName( "javax.swing.JButton" );
    Class<?> clazz = Class.forName( "java.awt.Point" );
    visitType( clazz );
    System.out.println( "hide members" );
  }
  //end::solution[]
}
