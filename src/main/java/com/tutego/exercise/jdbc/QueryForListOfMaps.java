package com.tutego.exercise.jdbc;

import java.sql.*;
import java.util.*;

public class QueryForListOfMaps {

  //tag::solution[]
  public static List<Map<String, Object>> findAllPirates() throws SQLException {
    try ( Connection connection = DriverManager.getConnection( "jdbc:h2:./pirates-dating" );
          Statement  statement  = connection.createStatement();
          ResultSet  resultSet  = statement.executeQuery( "SELECT * FROM Pirate" ) ) {
      ResultSetMetaData metaData = resultSet.getMetaData();

      List<Map<String, Object>> result = new ArrayList<>();
      while ( resultSet.next() ) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        for ( int col = 1, columns = metaData.getColumnCount(); col <= columns; col++ ) {
          String columnName = metaData.getColumnName( col );
          map.put( columnName, resultSet.getObject( col ) );
        }
        result.add( map );
      }
      return result;
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws SQLException {
    System.out.println( findAllPirates() );
  }
}
