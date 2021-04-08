package com.tutego.exercise.jdbc;

import java.sql.*;
import java.util.Arrays;

public class BatchInsert {
  public static void main( String[] args ) throws SQLException {
    // CreateTable.main( args );
    //tag::solution[]
    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" ) ) {
      connection.setAutoCommit( false );

      String sqlTemplate = "INSERT INTO Pirate " +
                           "(nickname, email, swordlength, birthdate, description) " +
                           "VALUES (%s)";

      String[] values = {
          "'anygo', 'amiga_anker@cutthroat.adult', 11, DATE '2000-05-21', 'Living the dream'",
          "'SweetSushi', 'muffin@berta.bar', 11, DATE '1952-04-03', 'Where are all the bad boys?'",
          "'Liv Loops', 'whiletrue@deenagavis.camp', 16, DATE '1965-05-11', 'Great guy'" };

      try ( Statement statement = connection.createStatement() ) {
        for ( String value : values )
          statement.addBatch( String.format( sqlTemplate, value ) );

        int[] updateCounts = statement.executeBatch();
        connection.commit();
        System.out.println( Arrays.toString( updateCounts ) );
      }
    }
    //end::solution[]
  }
}