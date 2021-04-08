package com.tutego.exercise.string;

import java.util.Scanner;

public class RelationChecker {

  //tag::solution[]
  private static boolean checkRelation( int number1, String relationalOperator, int number2 ) {
    switch ( relationalOperator ) {
      case ">": return number1 > number2;
      case "<": return number1 < number2;
      case "=": return number1 == number2;
      default:  return false;
    }
  }

  public static boolean checkRelation( String string ) {
    Scanner scanner = new Scanner( string );
    int number1 = scanner.nextInt();

    while ( scanner.hasNext() ) {
      String relationalOperator = scanner.next();
      int number2 = scanner.nextInt();
      if ( checkRelation( number1, relationalOperator, number2 ) )
        number1 = number2;
      else
        return false;
    }

    return true;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( checkRelation( "1 < 2 > 1 < 10 = 10 > 2" ) );
  }
}
