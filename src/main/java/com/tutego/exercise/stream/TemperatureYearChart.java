package com.tutego.exercise.stream;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.time.Month.*;
import static java.util.Locale.ENGLISH;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class TemperatureYearChart {

  //tag::solution-a[]
  private static int[] randomTemperaturesForYear( Year year ) {
    int daysInYear = year.length();
    return IntStream.range( 0, daysInYear )
        .mapToDouble( value -> sin( value * PI / daysInYear ) ) // 0..1
        .map( value -> value * 20 ) // 0..20
        .map( value -> value + 10 ) // 10..30
        .mapToInt( value -> (int) (value + 3 * (random() - 0.5)) )
        .toArray();
  }

  private static SortedMap<Year, int[]> createRandomTemperatureMap() {
    return Stream.iterate( Year.now(), year -> year.minusYears( 1 ) )
                 .limit( 5 )
                 .collect( toMap( identity(),
                                  TemperatureYearChart::randomTemperaturesForYear,
                                  (y1,y2) -> { throw new RuntimeException( "Duplicates" ); },
                                  TreeMap::new ) );
  }
  //end::solution-a[]

  //tag::solution-b[]
  private static void printTemperatureTable( SortedMap<Year, int[]> yearToTemperatures ) {
    yearToTemperatures.forEach( (year, temperatures) -> {
      String temperatureCells =
          Arrays.stream( temperatures )
                .mapToObj( temperature -> String.format( "%2d", temperature ) )
                .collect( Collectors.joining( " | ", "| ", " | " ) );
      System.out.println( "| " + year + " " + temperatureCells );
    } );
  }
  //end::solution-b[]

  //tag::solution-d1[]
  private static IntSummaryStatistics getStatistics( YearMonth yearMonth, int... temperatures ) {
    int start = yearMonth.atDay( 1 ).getDayOfYear();
    int end   = yearMonth.atEndOfMonth().getDayOfYear();
    return Arrays.stream( temperatures, start - 1, end ).summaryStatistics();
  }
  //end::solution-d1[]

  //tag::solution-e1[]
  private static void writeTemperatureHtmlFile( Year year, Map<Year, int[]> yearToTemperatures,
                                                Path path ) throws IOException {
    String template =
      "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<body>\n" +
      "<canvas id=\"chart\" width=\"500\" height=\"200\"></canvas>\n" +
      "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js\"></script>\n" +
      "<script>\n" +
      "const cfg = {\n" +
      "    type: 'bar',\n" +
      "    data: {\n" +
      "        labels: [\"Jan\", \"Feb\", \"Mrz\", \"Apr\", \"Mai\", \"Jun\", " +
      "                 \"Jul\", \"Aug\", \"Sep\", \"Okt\", \"Nov\", \"Dez\"],\n" +
      "        datasets: [ {\n" +
      "            label: \"Average values\", fill: false,\n" +
      "            data: [%s],\n" +
      "        } ]\n" +
      "    },\n" +
      "    options: {\n" +
      "        responsive: true,\n" +
      "        title: { display:true, text:'Temperature curve' },\n" +
      "        tooltips: { mode: 'index', intersect: false },\n" +
      "        hover: { mode: 'nearest', intersect: true },\n" +
      "        scales: {\n" +
      "            xAxes: [ { display: true, scaleLabel: { display: true, labelString: 'Month' } } ],\n" +
      "            yAxes: [ { display: true, scaleLabel: { display: true, labelString: 'Temperature' } } ]\n" +
      "        }\n" +
      "    }\n" +
      "};\n" +
      "window.onload = () => new Chart(document.getElementById(\"chart\").getContext(\"2d\"), cfg);\n" +
      "</script>\n" +
      "</body>\n" +
      "</html>";

    String formattedTemperatures =
        IntStream.rangeClosed( JANUARY.getValue(), DECEMBER.getValue() )
          .mapToObj( Month::of )
          .map( month -> year.atMonth( month ) )
          .map( yearMonth -> getStatistics( yearMonth, yearToTemperatures.get( year ) ) )
          .map( IntSummaryStatistics::getAverage )
          .map( avgTemperature -> String.format( ENGLISH, "%.1f", avgTemperature ) )
          .collect( Collectors.joining( "," ) );
    String html = String.format( template, formattedTemperatures );

    Files.write( path, Collections.singleton( html ) );
  }
  //end::solution-e1[]

  public static void main( String[] args ) {

    SortedMap<Year, int[]> yearToTemperatures = createRandomTemperatureMap();

    printTemperatureTable( yearToTemperatures );

    //tag::solution-c[]
    IntSummaryStatistics yearStatistics =
        Arrays.stream( yearToTemperatures.get( Year.now() ) ).summaryStatistics();
    System.out.printf( "max: %d, min: %d%n",
                       yearStatistics.getMax(), yearStatistics.getMin() );
    //end::solution-c[]

    //tag::solution-d2[]
    IntSummaryStatistics monthStatistics =
        getStatistics( YearMonth.of( 2020, SEPTEMBER ), yearToTemperatures.get( Year.now() ) );
    System.out.printf( "max: %d, min: %d, average: %.2f%n", monthStatistics.getMax(),
                       monthStatistics.getMin(), monthStatistics.getAverage() );
    //end::solution-d2[]

    //tag::solution-e2[]
    try {
      Path tempFile = Files.createTempFile( "temperatures", ".html" );
      writeTemperatureHtmlFile( Year.now(), yearToTemperatures, tempFile );
      Desktop.getDesktop().browse( tempFile.toUri() );
    }
    catch ( IOException e ) { e.printStackTrace(); }
    //end::solution-e2[]
  }
}
