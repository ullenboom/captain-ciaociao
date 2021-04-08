package com.tutego.exercise.jdbc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;

public class Blob {
  public static void main( String[] args ) throws Exception {
    //tag::solution[]
    try ( Connection con = DriverManager.getConnection( "jdbc:h2:./pirates-dating" ) ) {
      try ( Statement stmt = con.createStatement() ) {
        stmt.executeUpdate( "DROP TABLE IF EXISTS Images" );
      }

      try ( Statement stmt = con.createStatement() ) {
        String createTableString = "CREATE TABLE Images (name TEXT, img BLOB);";
        stmt.executeUpdate( createTableString );
      }

      InputStream bais = new ByteArrayInputStream(
          "The story of a young opossum growing up in the forest.".getBytes() );
      try ( PreparedStatement pstmt = con
          .prepareStatement( "INSERT INTO Images VALUES (?, ?)" ) ) {
        pstmt.setString( 1, "Didel" );
        pstmt.setBinaryStream( 2, bais, bais.available() );
        pstmt.executeUpdate();
      }

      try ( Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Images" ) ) {
        if ( rs.next() ) {
          byte[] bytes = rs.getBytes( "img" );
          System.out.println( new String( bytes ) );
        }
      }
    }
    //end::solution[]
  }
}