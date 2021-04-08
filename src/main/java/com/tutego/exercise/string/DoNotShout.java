package com.tutego.exercise.string;

import java.util.regex.Pattern;

public class DoNotShout {

  //tag::solution[]
  public static String silentShoutingWords( String string ) {
    return Pattern.compile( "\\p{javaUpperCase}{3,}" )
                  .matcher( string )
                  .replaceAll( matchResult -> matchResult.group().toLowerCase() );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( silentShoutingWords( "AY Captain! Smutje MUSS WEG!" ) );
  }
}
