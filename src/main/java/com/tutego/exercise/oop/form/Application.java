package com.tutego.exercise.oop.form;

public class Application {

  public static void main( String[] args ) {
    Rectangle r = new Rectangle( 0, 0, 4, 5 );
    Circle c = new Circle( 0, 0, 5 );

    System.out.println( c );
    System.out.println( r );

    Group g = new Group();
    g.add( c );
    g.add( r );

    System.out.printf( "Sum of all areas: %f%n", g.area() );

    FormSizeComparator comparator = new FormSizeComparator();
    System.out.println( comparator.compare( r, c ) );

    System.out.println( g.maximum() );
  }
}
