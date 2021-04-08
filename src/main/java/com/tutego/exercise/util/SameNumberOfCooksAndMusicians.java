package com.tutego.exercise.util;

import java.util.Arrays;
import java.util.List;

public class SameNumberOfCooksAndMusicians {
  static class CrewMember {
    enum Profession { CAPTAIN, NAVIGATOR, CARPENTER, COOK, MUSICIAN, DOCTOR }

    String name;
    Profession profession;

    CrewMember( String name, Profession profession ) {
      this.name = name;
      this.profession = profession;
    }
  }

  //tag::solution-switch[]
  public static boolean areSameNumberOfCooksAndMusicians( List<CrewMember> crewMembers ) {
    int weight = 0;
    for ( CrewMember member : crewMembers ) {
      switch ( member.profession ) {
        case COOK:     weight++; break;
        case MUSICIAN: weight--; break;
      }
    }
    return weight == 0;
  }
  //end::solution-switch[]

  /*
  public static boolean areSameNumberOfCooksAndMusiciansSwitchExpr( List<CrewMember> crewMembers ) {
    int weight = 0;
    //tag::solution-switch-expr[]
    for ( CrewMember member : crewMembers ) {
      weight += switch ( member.profession ) {
        case COOK     -> +1;
        case MUSICIAN -> -1;
        default -> 0;
      };
    }
    //end::solution-switch-expr[]
    return weight == 0;
  }
  */

  public static boolean areSameNumberOfCooksAndMusicians2( List<CrewMember> crewMembers ) {
    //tag::solution-b[]
    int result = 0;
    for ( CrewMember member : crewMembers ) {
      //                                                          CAPTAIN -+
      //                                                      NAVIGATOR -+ |
      //                                                    CARPENTER -+ | |
      //                                                       COOK -+ | | |
      //                                                 MUSICIAN -+ | | | |
      //                                                           v v v v v
      int zeroOrOneOrTwo = ((1 << member.profession.ordinal()) & 0b1_1_0_0_0) / 8;
      int minusOneOrZeroOrPlusOne = (zeroOrOneOrTwo / 2) - (zeroOrOneOrTwo & 1);
      result += minusOneOrZeroOrPlusOne;
    }
    return result == 0;
    //end::solution-b[]
  }

  public static void main( String[] args ) {
    //tag::example[]
    CrewMember captain   = new CrewMember( "CiaoCiao", CrewMember.Profession.CAPTAIN );
    CrewMember cook1     = new CrewMember( "Remy", CrewMember.Profession.COOK );
    CrewMember cook2     = new CrewMember( "The Witch Cook", CrewMember.Profession.COOK );
    CrewMember musician1 = new CrewMember( "Mahna Mahna", CrewMember.Profession.MUSICIAN );
    CrewMember musician2 = new CrewMember( "Rowlf", CrewMember.Profession.MUSICIAN );

    List<CrewMember> crew1 = Arrays.asList( cook1, musician1 );
    System.out.println( areSameNumberOfCooksAndMusicians( crew1 ) ); // true

    List<CrewMember> crew2 = Arrays.asList( cook1, musician1, musician2, captain );
    System.out.println( areSameNumberOfCooksAndMusicians( crew2 ) ); // false

    List<CrewMember> crew3 = Arrays.asList( cook1, musician1, musician2, captain, cook2  );
    System.out.println( areSameNumberOfCooksAndMusicians( crew3 ) ); // true
    //end::example[]

    System.out.println( areSameNumberOfCooksAndMusicians2( crew1 ) ); // true
    System.out.println( areSameNumberOfCooksAndMusicians2( crew2 ) ); // false
    System.out.println( areSameNumberOfCooksAndMusicians2( crew3 ) ); // true
  }
}
