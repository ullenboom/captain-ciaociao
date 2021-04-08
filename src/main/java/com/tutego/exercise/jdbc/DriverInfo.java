package com.tutego.exercise.jdbc;

import java.sql.DriverManager;
import java.util.Collections;

public class DriverInfo {
  public static void main( String[] args ) {
    //tag::solution[]
    Collections.list( DriverManager.getDrivers() ).forEach(
        driver -> System.out.println( driver.getClass().getName() )
    );
    //end::solution[]
  }
}