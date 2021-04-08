package com.tutego.exercise.util;

import java.util.*;

public class FriendsSittingTogether {

  //tag::solution[]
  public static class Guest {
    public boolean likesToShoot;
    public boolean likesToGamble;
    public boolean likesBlackmail;

    public Guest( boolean likesToShoot, boolean likesToGamble, boolean likesBlackmail ) {
      this.likesToShoot   = likesToShoot;
      this.likesToGamble  = likesToGamble;
      this.likesBlackmail = likesBlackmail;
    }

    public boolean hasDissimilarInterests( Guest other ) {
      return !(likesToShoot   == other.likesToShoot ||
               likesToGamble  == other.likesToGamble ||
               likesBlackmail == other.likesBlackmail);
    }
  }

  public static int allGuestsHaveSimilarInterests( List<Guest> guests ) {
    for ( int index = 0; index < guests.size(); index++ ) {
      Guest guest = guests.get( index );
      Guest rightNeighbor = guests.get( (index + 1) % guests.size() );
      if ( guest.hasDissimilarInterests( rightNeighbor ) )
        return index;
    }
    return -1;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( allGuestsHaveSimilarInterests( Arrays.asList( new Guest( true, true, true ),
                                                                      new Guest( true, false, false ) ) ) );
  }
}
