package com.tutego.exercise.lang;

public class FairShare {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Number of bottles in total?" );
    int bottles = new java.util.Scanner( System.in ).nextInt();

    int captainsBottles = bottles / 2;
    int crewsBottles    = bottles - captainsBottles;

    System.out.println( "Bottles for the captain: " + captainsBottles );
    System.out.println( "Bottles for all crew members: " + crewsBottles );

    System.out.println( "Number of crew members?" );
    int crewMembers = new java.util.Scanner( System.in ).nextInt();
    System.out.println( "Fair share without remainder? " + (crewsBottles % crewMembers == 0) );
    //end::solution[]
  }
}
