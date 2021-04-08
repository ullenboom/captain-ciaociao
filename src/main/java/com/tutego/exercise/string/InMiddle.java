package com.tutego.exercise.string;

public class InMiddle {

  //tag::solution[]
  public static boolean isStringInMiddle( String string, String middle ) {

    if ( middle.length() > string.length() )
      return false;

    int start = string.length() / 2 - middle.length() / 2;
    return string.regionMatches( start, middle, 0 /* middle offset */, middle.length() );
  }

  public static boolean isCiaoCiaoInMiddle( String string ) {
    return isStringInMiddle( string, "CiaoCiao" );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( isCiaoCiaoInMiddle( "CiaoCiao" ) );
    System.out.println( isCiaoCiaoInMiddle( "!CiaoCiao!" ) );
    System.out.println( isCiaoCiaoInMiddle( "SupaCiaoCiaoCute" ) );
    System.out.println( isCiaoCiaoInMiddle( "x!_CiaoCiaoabc" ) );
    System.out.println( isCiaoCiaoInMiddle( "\t\tCiaoCiao  " ) );
    System.out.println( isCiaoCiaoInMiddle( "BambooCiaoCiaoBlop" ) );
    System.out.println( isCiaoCiaoInMiddle( "BabyTigerChristine" ) );
  }
}
