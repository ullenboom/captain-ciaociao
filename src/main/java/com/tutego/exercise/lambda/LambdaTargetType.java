package com.tutego.exercise.lambda;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTargetType {

  public static void main( String[] args ) {
    //tag::solution[]
    Runnable              runnable   = () -> {};
    ActionListener        listener   = event -> {};
    Supplier<String>      supplier   = () -> "";
    Consumer<Point>       consumer   = point -> {};
    Comparator<Rectangle> comparator = (r1, r2) -> 0;
    //end::solution[]
  }
}