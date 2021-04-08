package com.tutego.exercise.lang;

public class HasCommonDigits {

  public static void main( String[] args ) {

    //tag::solution[]
    System.out.println( "Enter two numbers between 0 and 99:" );
    int number1 = new java.util.Scanner( System.in ).nextInt() % 100;
    int number2 = new java.util.Scanner( System.in ).nextInt() % 100;

    int number1digit1 = number1 / 10;
    int number1digit2 = number1 % 10;
    int number2digit1 = number2 / 10;
    int number2digit2 = number2 % 10;

    boolean hasCommonDigits =    number1digit1 == number2digit1
                              || number1digit1 == number2digit2
                              || number1digit2 == number2digit1
                              || number1digit2 == number2digit2;
    System.out.println( hasCommonDigits );
    //end::solution[]
  }
}
