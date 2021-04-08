package com.tutego.exercise.lang;

public class MoreThanAMillion {

  public static void main( String[] args ) {
    //tag::solution[]
    double monetaryAmountCosimo    = new java.util.Scanner( System.in ).nextDouble();
    double monetaryAmountLucia     = new java.util.Scanner( System.in ).nextDouble();
    double monetaryAmountSlickFoot = new java.util.Scanner( System.in ).nextDouble();

    double sum = monetaryAmountCosimo + monetaryAmountLucia + monetaryAmountSlickFoot;
    boolean canPay = sum > 1_000_000;
    System.out.println( canPay );
    //end::solution[]
  }
}
