package com.tutego.exercise.util;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UPN {
  public static void main( String[] args ) {
    //tag::solution[]
    String input = "160 50 30 + /";
    Queue<Integer> stack = Collections.asLifoQueue( new ArrayDeque<>() );

    for ( String token : input.split( "\\s+" ) ) {
      Pattern p = Pattern.compile( "[+*/-]" );
      Matcher m = p.matcher( token );
      Pattern p1 = Pattern.compile( "\\d+" );
      Matcher m1 = p1.matcher( token );
      if ( m1.matches() )
        stack.add( Integer.parseInt( token ) );
      else if ( m.matches() ) {
        int operand2 = stack.remove();
        int operand1 = stack.remove();
        switch ( token ) {
          case "+": stack.add( operand1 + operand2 ); break;
          case "-": stack.add( operand1 - operand2 ); break;
          case "*": stack.add( operand1 * operand2 ); break;
          case "/": stack.add( operand1 / operand2 ); break;
        }
      }
      else
        System.out.println( "Unknown type!" );
    }
    System.out.printf( "Result: %d", stack.remove() );
    //end::solution[]
  }
}