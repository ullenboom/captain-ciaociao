package com.tutego.exercise.jdbc;

import java.sql.*;

public class InsertData {

  public static void main( String[] args ) throws SQLException {
    CreateTable.main( args );
    //tag::solution[]
    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          Statement  statement  = connection.createStatement() ) {

      String sql1 =
          "INSERT INTO Pirate " +
          "(nickname, email, swordlength, birthdate, description) " +
          "VALUES ('CiaoCiao', 'captain@goldenpirate.faith', 18, DATE '1955-11-07', 'Great guy')";
      statement.executeUpdate( sql1 );

      String sql2 =
          "INSERT INTO Pirate " +
          "(nickname, email, swordlength, birthdate, description) " +
          "VALUES ('lolalilith', 'fixme@bumblebee.space', 12, DATE '1973-07-20', 'I’m 99% perfect')";
      int rowCount = statement.executeUpdate( sql2, Statement.RETURN_GENERATED_KEYS );
      if ( rowCount != 1 )
        throw new IllegalStateException( "INSERT didn't return a row count of 1" );

      ResultSet generatedKeys = statement.getGeneratedKeys();
      if ( generatedKeys.next() )
        System.out.println( generatedKeys.getLong( 1 ) );
    }
    //end::solution[]
  }
}
