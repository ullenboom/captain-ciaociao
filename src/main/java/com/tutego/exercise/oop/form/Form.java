package com.tutego.exercise.oop.form;

public abstract class Form {

  protected double x, y;

  public void setX( double x ) {
    this.x = x;
  }

  public void setY( double y ) {
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public abstract double area();
}
