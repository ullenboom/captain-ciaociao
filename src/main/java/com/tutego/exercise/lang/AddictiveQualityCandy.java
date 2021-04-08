package com.tutego.exercise.lang;

// import java.util.function.Supplier;

public class AddictiveQualityCandy {
  //tag::solution[]
  enum CandyType {
    CARAMELS    ( 9 ),
    CHOCOLATE   ( 5 ),
    GUMMIES     ( 4 ),
    LICORICE    ( 3 ),
    LOLLIPOPS   ( 2 ),
    CHEWING_GUMS( 3 ),
    COTTON_CANDY( 1 );

    private final int addictiveQuality;

    CandyType( int addictiveQuality ) {
      this.addictiveQuality = addictiveQuality;
    }

    public int addictiveQuality() {
      return addictiveQuality;
    }

    public CandyType next() {
      switch ( this ) {
        case GUMMIES: return CHOCOLATE;
        case LOLLIPOPS: return Math.random() > 0.5 ? LICORICE : CHEWING_GUMS;
        case COTTON_CANDY: return LOLLIPOPS;
        case LICORICE:
        case CHEWING_GUMS: return GUMMIES;
        case CHOCOLATE:
        default: return CARAMELS;
      }
    }
    //end::solution[]

    /*
    //tag::solution2[]
    private static CandyType[] NEXT = {
      // CARAMELS, CHOCOLATE, GUMMIES,   LICORICE, LOLLIPOPS, CHEWING_GUMS, COTTON_CANDY
      CARAMELS,    CARAMELS,  CHOCOLATE, GUMMIES,  null,      GUMMIES,      LOLLIPOPS
    };

    public CandyType next() {
      if ( this == LOLLIPOPS )
        return Math.random() > 0.5 ? LICORICE : CHEWING_GUMS;
      return NEXT[ ordinal() ];
    }
    //end::solution2[]
    */

    /*
    //tag::solution3[]
    interface CandyTypeSupplier extends Supplier<CandyType> {}

    private static CandyTypeSupplier[] NEXT = {
      () -> CARAMELS, () -> CARAMELS, () -> CHOCOLATE, () -> GUMMIES,
      () -> Math.random() > 0.5 ? LICORICE : CHEWING_GUMS, () -> GUMMIES, () -> LOLLIPOPS
    };

    public CandyType next() {
      return NEXT[ ordinal() ].get();
    }
    //end::solution3[]
    */
  }

  public static void main( String[] args ) {
    System.out.println( CandyType.GUMMIES.next() );
    System.out.println( CandyType.LOLLIPOPS.next() );
    System.out.println( CandyType.LOLLIPOPS.next().addictiveQuality() );
  }
}