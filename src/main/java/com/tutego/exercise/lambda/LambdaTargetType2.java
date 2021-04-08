package com.tutego.exercise.lambda;

import java.util.function.DoubleSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.UnaryOperator;

public class LambdaTargetType2 {

  public static void main( String[] args ) {
    //tag::solution[]
    DoubleSupplier        ds   = () -> Math.random();
    LongToDoubleFunction  ltdf = value -> value * Math.random();
    UnaryOperator<String> up   = s -> s.trim();
    //end::solution[]
  }
}