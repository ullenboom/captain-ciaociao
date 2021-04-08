package com.tutego.exercise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {
  public static void main( String[] args ) {
    //tag::solution[]
    String sql = "";
    try ( Scanner scanner =
            new Scanner( CreateTable.class.getResourceAsStream( "create-table.sql" ), "UTF-8" ) ) {
      sql = scanner.useDelimiter( "\\z" ).next();
    }

    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          Statement  statement  = connection.createStatement() ) {
      statement.execute( sql );
    }
    catch ( SQLException e ) { e.printStackTrace(); }
    //end::solution[]
  }
}
