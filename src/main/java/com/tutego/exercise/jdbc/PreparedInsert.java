package com.tutego.exercise.jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class PreparedInsert {
  public static void main( String[] args ) throws SQLException {
    // CreateTable.main( args );
    //tag::solution[]
    String preparedSql = "INSERT INTO Pirate " +
                         "(nickname, email, swordlength, birthdate, description) " +
                         "VALUES (?, ?, ?, ?, ?)";

    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          PreparedStatement preparedStatement = connection.prepareStatement( preparedSql ) ) {

      connection.setAutoCommit( false );

      List<String[]> data = Arrays.asList(
          new String[]{ "jacky overflow", "bullet@jennyblackbeard.red", "17", "1976-12-17",
                        "If love a crime" },
          new String[]{ "IvyIcon", "array.field@graceobool.cool", "12", "1980-06-12", "U&I" },
          new String[]{ "Lulu De Sea", "arielle@dirtyanne.fail", "13", "1983-11-24",
                        "You can be my prince" }
      );

      for ( String[] elements : data ) {
        preparedStatement.setString( /* nickname    */ 1, elements[ 0 ] );
        preparedStatement.setString( /* email       */ 2, elements[ 1 ] );
        preparedStatement.setInt(    /* swordlength */ 3, Integer.parseInt( elements[ 2 ] ) );
        preparedStatement.setDate(   /* birthdate   */ 4, Date.valueOf( elements[ 3 ] ) );
        preparedStatement.setObject( /* description */ 5, elements[ 4 ] );
        preparedStatement.executeUpdate();
      }

      connection.commit();
    }
    //end::solution[]
  }
}