package com.tutego.exercise.jdbc;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Select {
  public static void main( String... args ) throws SQLException {
    //tag::solution[]
    String sql = "SELECT nickname, swordlength, birthdate FROM Pirate";
    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          Statement  statement  = connection.createStatement();
          ResultSet  resultSet  = statement.executeQuery( sql ) ) {
      while ( resultSet.next() ) {
        String nickname = resultSet.getString( /* nickname column */1 );
        int swordlength = resultSet.getInt( "swordlength" );
        Date birthdate  = resultSet.getDate( "birthdate" );
        System.out.printf( "%-20s%-20s%10d%n",
          nickname,
          birthdate.toLocalDate().format( DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG) ),
          swordlength );
      }
    }
    //end::solution[]
  }
}

