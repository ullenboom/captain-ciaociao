package com.tutego.exercise.oop.lazy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pirate {

  private List<Pirate> friends;

  public void addFriend( Pirate friend ) {
    if ( friends == null )
      friends = new ArrayList<>();
    friends.add( friend );
  }

  public List<Pirate> friends() {
    if ( friends == null )
      return Collections.emptyList();

    return Collections.unmodifiableList( friends );
  }
}
