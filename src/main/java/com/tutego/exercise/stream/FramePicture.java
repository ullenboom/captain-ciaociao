package com.tutego.exercise.stream;

import java.util.stream.Collectors;

public class FramePicture {

  //tag::solution[]
  private static String frame( String string ) {
    if ( string == null || string.trim().isEmpty() )
      throw new IllegalArgumentException( "String to frame can not be null or empty" );

    final String NEW_LINE = "\n";
    int max = string.lines().mapToInt( String::length ).max().getAsInt();
    String topBottomBorder = '+' + "-".repeat( max + 4 ) + '+' + NEW_LINE;
    String emptyRow = "|  " + " ".repeat( max ) + "  |" + NEW_LINE;

    return string.lines()
                 .map( s -> "|  " + s + " ".repeat( max - s.length() ) + "  |" )
                 .collect( Collectors.joining( NEW_LINE,
                                               topBottomBorder + emptyRow,
                                               NEW_LINE + emptyRow + topBottomBorder ) );
  }
  //end::solution[]

  public static void main( String[] args ) {

    String string = "" +
        "     ______\n" +
        "_.-':::::::`.\n" +
        "\\::::::::::::`.-._\n" +
        " \\:::''   `::::`-.`.\n" +
        "  \\         `:::::`.\\\n" +
        "   \\          `-::::`:\n" +
        "    \\______       `:::`.\n" +
        "    .|_.-'__`._     `:::\\\n" +
        "   ,'`|:::|  )/`.     \\:::\n" +
        "  /. -.`--'  : /.\\     ::|\n" +
        "  `-,-'  _,'/| \\|\\\\    |:|\n" +
        "   ,'`::.    |/>`;'\\   |:|\n" +
        "   (_\\ \\:.:.:`((_));`. ;:|\n" +
        "   \\.:\\ ::_:_:_`-','  `-:|\n" +
        "    `:\\\\|     SSt:\n" +
        "       )`__...---'";

    System.out.println( frame( string ) );
  }
}
