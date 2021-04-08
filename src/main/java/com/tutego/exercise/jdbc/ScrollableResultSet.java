package com.tutego.exercise.jdbc;

import java.sql.*;
import java.util.Scanner;

public class ScrollableResultSet {
  public static void main( String[] args ) throws SQLException {
    //tag::solution[]
    int NICKNAME_COLUMN = 2;
    String sql = "SELECT * FROM Pirate ORDER BY nickname";
    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          Statement  statement  = connection.createStatement(
                                   ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY );
          ResultSet srs = statement.executeQuery( sql ) ) {

      if ( srs.last() )
        System.out.printf( "%d rows%n", srs.getRow() );

      srs.absolute( 1 );
      System.out.println( srs.getString( NICKNAME_COLUMN ) );

      for ( String input; !(input = new Scanner( System.in ).next()).equals( "q" ); ) {
        switch ( input.toLowerCase() ) {
          case "u": case "p":
            if ( srs.isFirst() ) System.out.println( "Already first" );
            else srs.previous();
            break;
          case "d": case "n":
            if ( srs.isLast() ) System.out.println( "Already last" );
            else srs.next();
            break;
        }
        System.out.println( srs.getString( NICKNAME_COLUMN ) );
      }
    }
    //end::solution[]
  }
}