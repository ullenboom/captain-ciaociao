package com.tutego.exercise.os;

//tag::solution[]
public enum OS {
  WINDOWS,
  MACOS,
  UNIX,
  UNKNOWN;

  public static OS current() {
    String osName = System.getProperty( "os.name" );
    if ( osName == null ) return UNKNOWN;
    osName = osName.toLowerCase();
    return osName.contains( "windows" ) ? OS.WINDOWS :
           osName.contains( "mac" ) ? OS.MACOS :
           osName.contains( "nix" ) || osName.contains( "nux" ) ? OS.UNIX :
           UNKNOWN;
  }
}
//end::solution[]
