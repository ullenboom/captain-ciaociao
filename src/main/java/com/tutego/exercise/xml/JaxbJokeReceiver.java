package com.tutego.exercise.xml;

import com.tutego.exercise.xml.joke.Data;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;
import java.net.MalformedURLException;
import java.net.URL;

public class JaxbJokeReceiver {
  public static void main( String[] args ) {
    //tag::solution[]
    try {
      URL url = new URL( "https://sv443.net/jokeapi/v2/joke/Any?format=xml" );
      Data data = JAXB.unmarshal( url, Data.class );
      System.out.println( data.getSetup() );
      System.out.println( data.getDelivery() );
      System.out.printf( "Not Safe for Work? %s%n", data.getFlags().isNsfw() );
      System.out.printf( "Religious? %s%n", data.getFlags().isReligious() );
      System.out.printf( "Political? %s%n", data.getFlags().isPolitical() );
      System.out.printf( "Racist? %s%n", data.getFlags().isRacist() );
      System.out.printf( "Sexist? %s%n", data.getFlags().isSexist() );
    }
    catch ( MalformedURLException e ) {
      System.err.println( "malformed URL has occurred" );
      e.printStackTrace();
    }
    catch ( DataBindingException e ) {
      System.err.println( "failure in a JAXB operation" );
      e.printStackTrace();
    }
    //end::solution[]
  }
}
