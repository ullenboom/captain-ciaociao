package com.tutego.exercise.device;

//tag::solution[]
public class TreasureChest {

  public final int goldDoubloonWeight;
  public final int gemstoneWeight;

  private TreasureChest( int goldDoubloonWeight, int gemstoneWeight ) {
    if ( goldDoubloonWeight < 0 || gemstoneWeight < 0 )
      throw new IllegalArgumentException( "Weight can't be negative" );
    this.goldDoubloonWeight = goldDoubloonWeight;
    this.gemstoneWeight     = gemstoneWeight;
  }

  public static TreasureChest newInstance() {
    return new TreasureChest( 0, 0 );
  }

  public static TreasureChest newInstanceWithGoldDoubloonWeight( int weight ) {
    return new TreasureChest( weight, 0 );
  }

  public static TreasureChest newInstanceWithGemstonesWeight( int weight ) {
    return new TreasureChest( 0, weight );
  }

  public static TreasureChest newInstanceWithGoldDoubloonAndGemstonesWeight( int goldDoubloonWeight,
                                                                             int gemstonesWeight ) {
    return new TreasureChest( goldDoubloonWeight, gemstonesWeight );
  }
}
//end::solution[]
