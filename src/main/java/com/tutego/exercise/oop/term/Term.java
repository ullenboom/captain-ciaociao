package com.tutego.exercise.oop.term;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.tutego.exercise.oop.term.Literal.of;
import static com.tutego.exercise.oop.term.Operator.MULTIPLY;
import static com.tutego.exercise.oop.term.Operator.PLUS;

//tag::solution[]
public class Term {

  public static void main( String[] args ) {
    Subterm row1 = Row.of( of( "a" ), PLUS, of( "b" ) );
    Subterm row2 = Row.of( of( "c" ), MULTIPLY, of( "d" ) );
    Subterm frac = Fraction.of( row1, row2 );
    Subterm sqrt = Sqrt.of( frac );
    System.out.println( sqrt );
  }
}

interface Subterm {
}

class Row implements Subterm {
  public static Subterm of( List<Subterm> subterms ) {
    return new Row( subterms );
  }

  public static Subterm of( Subterm... subterms ) {
    return of( Arrays.asList( subterms ) );
  }

  private final List<Subterm> subterms;

  private Row( List<Subterm> subterms ) {
    this.subterms = subterms;
  }

  @Override
  public String toString() {
    return subterms.stream().map( Object::toString ).collect( Collectors.joining() );
  }
}

class Literal implements Subterm {
  public static Subterm of( String variable ) {
    return new Literal( variable );
  }

  private final String variable;

  private Literal( String variable ) {
    this.variable = variable;
  }

  @Override
  public String toString() {
    return variable;
  }
}

enum Operator implements Subterm {
  PLUS, MINUS, MULTIPLY, DIVISION, PLUS_MINUS, MINUS_PLUS, EQUAL, NOT_EQUAL;

  public String toString() {
    switch ( this ) {
      case PLUS:
        return "+";
      case MINUS:
        return "-";
      case MULTIPLY:
        return "*";
      case DIVISION:
        return "/";
      case PLUS_MINUS:
        return "±";
      case MINUS_PLUS:
        return "∓";
      case EQUAL:
        return "=";
      case NOT_EQUAL:
        return "≠";

      default:
        throw new UnsupportedOperationException( "Unknown operator" );
    }
  }
}

class Parentheses implements Subterm {

  public static Subterm of( Subterm subterm ) {
    return new Parentheses( subterm );
  }

  private final Subterm subterm;

  private Parentheses( Subterm subterm ) {
    this.subterm = subterm;
  }

  @Override
  public String toString() {
    return "(" + subterm + ")";
  }
}

class Fraction implements Subterm {

  public static Subterm of( Subterm subterm1, Subterm subterm2 ) {
    return new Fraction( subterm1, subterm2 );
  }

  private final Subterm subterm1;
  private final Subterm subterm2;

  private Fraction( Subterm subterm1, Subterm subterm2 ) {
    this.subterm1 = subterm1;
    this.subterm2 = subterm2;
  }

  @Override
  public String toString() {
    return subterm1 + " / " + subterm2;
  }
}

class Power implements Subterm {

  public static Subterm of( Subterm subterm1, Subterm subterm2 ) {
    return new Power( subterm1, subterm2 );
  }

  private final Subterm subterm1;
  private final Subterm subterm2;

  private Power( Subterm subterm1, Subterm subterm2 ) {
    this.subterm1 = subterm1;
    this.subterm2 = subterm2;
  }

  @Override
  public String toString() {
    return subterm1 + " ^ " + subterm2;
  }
}

class Sqrt implements Subterm {

  public static Subterm of( Subterm index, Subterm radicand ) {
    return new Sqrt( index, radicand );
  }

  public static Subterm of( Subterm radicand ) {
    return new Sqrt( radicand );
  }

  private Subterm index;
  private final Subterm radicand;

  private Sqrt( Subterm index, Subterm radicand ) {
    this.index = index;
    this.radicand = radicand;
  }

  private Sqrt( Subterm radicand ) {
    this.radicand = radicand;
  }

  @Override
  public String toString() {
    return ((index != null) ? index : "") + "√( " + radicand + ")";
  }
}
//end::solution[]
