import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Domino {

  private final String value;

  Domino( String value ) {this.value = value;}

  Domino rotate() {
    return new Domino( new StringBuilder( value ).reverse().toString() );
  }

  boolean matches( Domino maybe ) {
    return value.charAt( 1 ) == maybe.value.charAt( 0 );
  }

  @Override public boolean equals( Object other ) {
    return value.equals( ((Domino) other).value );
  }

  @Override public int hashCode() {
    return value.hashCode();
  }

  @Override public String toString() {
    return "" + value;
  }
}

public class Dominoes {

  private static List<Domino> remove( Domino element, List<Domino> list ) {
    List<Domino> newList = new ArrayList<>( list );
    newList.remove( element );
    return newList;
  }

  private static List<Domino> insert( Domino element, List<Domino> list ) {
    List<Domino> newList = new ArrayList<>( list );
    newList.add( element );
    return newList;
  }

  private static boolean validNext( List<Domino> solution, Domino maybe ) {
    if ( solution.isEmpty() )
      return true;
    Domino last = solution.get( solution.size() - 1 );
    return last.matches( maybe );
  }

  static boolean solve( List<Domino> solution, List<Domino> remaining ) {
    System.out.println( solution + "  " + remaining );

    if ( remaining.isEmpty() )
      return true;

    for ( Domino candidate : remaining ) {
      for ( Domino rotated : List.of( candidate, candidate.rotate() ) )
        if (    validNext( solution, rotated )
             && solve( insert( rotated, solution ), remove( candidate, remaining ) ) )
          return true; // this candidate was a match, finish this round
    }
    return false;      // none of the remaining dominoes matches
  }

  public static void main( String[] args ) {
    List<Domino> solution = List.of();
    List<Domino> remaining = List.of(
        new Domino( "AC" ), new Domino( "BB" ), new Domino( "AB" ),
        new Domino( "BB" ), new Domino( "CC" ) );
    System.out.println( solve( solution, remaining ) );
  }
}