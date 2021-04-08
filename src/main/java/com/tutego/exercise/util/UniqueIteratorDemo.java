package com.tutego.exercise.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//tag::solution[]
class UniqueIterator<E> implements Iterator<E> {

  private final Iterator<? extends E> iterator;
  private final Set<E> hasSeenSet = new HashSet<>();
  private E next;

  public UniqueIterator( Iterator<? extends E> iterator ) {
    this.iterator = iterator;
    next = lookahead();
  }

  private E lookahead() {
    while ( iterator.hasNext() ) {
      E next = iterator.next();
      if ( ! hasSeenSet.contains( next ) )
        return next;
    }
    return null;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public E next() {
    E result = next;
    hasSeenSet.add( result );
    next = lookahead();
    return result;
  }
}
//end::solution[]

public class UniqueIteratorDemo {

  public static void main( String[] args ) {
    Iterator<String> iterator = List.of( "1", "2", "1", "3" ).iterator();
    UniqueIterator<String> ui = new UniqueIterator<>( iterator );
    while ( ui.hasNext() )
      System.out.println( ui.next() );
  }
}
