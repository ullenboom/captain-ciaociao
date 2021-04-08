package com.tutego.exercise.lang;

public class NumberOfDigits {

  public static void main( String[] args ) {

    int n = Integer.MAX_VALUE;

    {
      //tag::solution1[]
      int digits = 1;
      for ( int number = n / 10; number != 0; number /= 10 )
        digits++;
      System.out.println( digits );
      //end::solution1[]
    }

    {
      //tag::solution2[]
      int digits = 1;
      for ( long powersOfTen = 10; powersOfTen <= n; powersOfTen *= 10 )
        digits++;
      System.out.println( digits );
      //end::solution2[]
    }

    //tag::solution3[]
    if ( n >= 10_000 ) {
      if ( n >= 10_000_000 ) {
        if ( n >= 100_000_000 ) {
          if ( n >= 1_000_000_000 )
            System.out.println( 10 );
          else
            System.out.println( 9 );
        }
        else
          System.out.println( 8 );
      }
      else if ( n >= 10_0000 ) {
        if ( n >= 1_000_000 )
          System.out.println( 7 );
        else
          System.out.println( 6 );
      }
      else
        System.out.println( 5 );
    }
    else if ( n >= 100 ) {
      if ( n >= 1000 )
        System.out.println( 4 );
      else
        System.out.println( 3 );
    }
    else if ( n >= 10 )
      System.out.println( 2 );
    else
      System.out.println( 1 );
    //end::solution3[]

    {
      //tag::solution4[]
      int digits = n < 10 ? 1 :
                   n < 100 ? 2 :
                   n < 1000 ? 3 :
                   n < 10000 ? 4 :
                   n < 100_000 ? 5 :
                   n < 1_000_000 ? 6 :
                   n < 10_000_000 ? 7 :
                   n < 100_000_000 ? 8 :
                   n < 1_000_000_000 ? 9 :
                   10;
      System.out.println( digits );
      //end::solution4[]
    }

    {
      //tag::solution5[]
      int digits = n == 0 ? 1 : (int) Math.log10( n ) + 1;
      System.out.println( digits );
    }
    //end::solution5[]
  }
}
