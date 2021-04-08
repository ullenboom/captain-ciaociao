package com.tutego.exercise.net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class CoronaData {
  //tag::solution[]
    private static final String URL_TEMPLATE =
        "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/%s.csv";
    public static String findByDateAndSearchTerm( LocalDate date, String search ) {
      String url = String.format( URL_TEMPLATE,
                                  date.format( DateTimeFormatter.ofPattern( "MM-dd-yyyy" ) ) );

    try ( InputStream    is  = new URL( url ).openStream();
          Reader         isr = new InputStreamReader( is, StandardCharsets.UTF_8 );
          BufferedReader br  = new BufferedReader( isr ) ) {
      return br.lines()
               .filter( line -> line.contains( search ) )
               .collect( Collectors.joining( "\n" ) );
    }
    catch ( MalformedURLException e ) {
      System.err.println( "Malformed URL format of " + url );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    return "";
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( findByDateAndSearchTerm( LocalDate.now().minusDays( 1 ), "Miguel" ) );
  }
}
