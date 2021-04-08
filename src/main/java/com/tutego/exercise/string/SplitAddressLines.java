package com.tutego.exercise.string;

import java.util.StringTokenizer;

public class SplitAddressLines {

  public static void main( String[] args ) {
    //tag::solution[]
//    String address = "Boots and Bootles\n21 Pickle Street\r\n424242 Douglas\rArendelle";
    String address = "Doofenshmirtz Evil Inc.\nStrudelkuschel 4427\nGimmelshtump";
    StringTokenizer lines = new StringTokenizer( address, "\n\r" );
    String name = lines.nextToken();
    String street = lines.nextToken();
    String city = lines.nextToken();
    final String DEFAULT_COUNTRY = "Drusselstein";
    String country = lines.hasMoreTokens() ? lines.nextToken() : DEFAULT_COUNTRY;

    System.out.println( name + ";" + street + ";" + city + ";" + country );
    //end::solution[]
  }
}
