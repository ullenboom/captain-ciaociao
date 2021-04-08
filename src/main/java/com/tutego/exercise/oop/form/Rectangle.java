package com.tutego.exercise.oop.form;

public class Rectangle extends Form {

  private double width, height;

  public Rectangle( double x, double y, double width, double height ) {
    setX( x );
    setY( y );
    setWidth( width );
    setHeight( height );
  }

  public void setHeight( double height ) {
    this.height = height;
  }

  public void setWidth( double width ) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  @Override
  public double area() {
    return width * height;
  }

  @Override public String toString() {
    return "Rectangle[" + "width=" + width + ", height=" + height + ", x=" + x + ", y=" + y + ']';
  }
}