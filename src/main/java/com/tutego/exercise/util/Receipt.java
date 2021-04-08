package com.tutego.exercise.util;

import java.text.NumberFormat;
import java.util.*;

//tag::solution[]
public class Receipt {
  public static class Item {
    public final String name;
    public final int centPrice;
    public final int occurrence;

    public Item( String name, int centPrice, int occurrence ) {
      if ( centPrice <= 0 ) throw new IllegalArgumentException( "Price can not be <= 0" );
      if ( occurrence <= 0 ) throw new IllegalArgumentException( "Occurrence can not be <= 0" );
      this.name = Objects.requireNonNull( name );
      this.centPrice = centPrice;
      this.occurrence = occurrence;
    }

    public Item( String name, int centPrice ) {
      this( name, centPrice, 1 );
    }

    public Item incrementOccurrence() {
      return new Item( name, centPrice, occurrence + 1 );
    }

    @Override public boolean equals( Object other ) {
      if ( other == null || getClass() != other.getClass() )
        return false;

      return centPrice == ((Item) other).centPrice && name.equals( ((Item) other).name );
    }

    @Override public int hashCode() {
      return name.hashCode() * 31 + centPrice;
    }
  }

  private final List<Item> items = new ArrayList<>();

  public void addItem( Item item ) {
    int maybeIndex = items.indexOf( item );

    if ( maybeIndex >=0 )
      items.set( maybeIndex, items.get( maybeIndex ).incrementOccurrence() );
    else
      items.add( item );
  }

  @Override public String toString() {
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance( Locale.GERMANY );
    StringBuilder result = new StringBuilder( 512 );
    int sum = 0;

    for ( Item item : items ) {
      int itemPriceTotal = item.centPrice * item.occurrence;
      String line = String.format( "%dx  %-20s%10s%10s%n",
                                   item.occurrence, item.name,
                                   currencyFormatter.format( item.centPrice / 100. ),
                                   currencyFormatter.format( itemPriceTotal / 100. ) );
      result.append( line );
      sum += itemPriceTotal;
    }

    result.append( "\nSum: " )
          .append( currencyFormatter.format( sum / 100. ) )
          .append( "\n" );

    return result.toString();
  }
}
//end::solution[]

class ReceiptDemo {
  public static void main( String[] args ) {
    //tag::example[]
    Receipt receipt = new Receipt();
    receipt.addItem( new Receipt.Item( "Peanuts", 222 ) );
    receipt.addItem( new Receipt.Item( "Lightsaber", 19999 ) );
    receipt.addItem( new Receipt.Item( "Peanuts", 222 ) );
    receipt.addItem( new Receipt.Item( "Log book", 1000 ) );
    receipt.addItem( new Receipt.Item( "Peanuts", 222 ) );
    System.out.println( receipt );
    //end::example[]
  }
}