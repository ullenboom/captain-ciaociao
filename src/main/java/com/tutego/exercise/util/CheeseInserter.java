package com.tutego.exercise.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheeseInserter {
  //tag::solution[]
  public static void insertCheeseAroundVegetable( List<String> ingredients ) {
    final String VEGETABLE = "Zucchini|Paprikas?|Zwiebeln?|Tomaten?";
    for ( ListIterator<String> iterator = ingredients.listIterator(); iterator.hasNext(); ) {
      String ingredient = iterator.next();
      Pattern p = Pattern.compile( VEGETABLE );
      Matcher m = p.matcher( ingredient );
      if ( m.matches() )
        // The new element is inserted before the implicit cursor
        iterator.add( "Käse" );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    List<String> ingredients = new ArrayList<>();
    Collections.addAll( ingredients, "Gnocchi", "Zucchini", "Paprika", "Sahne",
                        "Brühe", "Milch", "Butter", "Zwiebeln", "Tomate", "Salz", "Pfeffer" );
    insertCheeseAroundVegetable( ingredients );
    System.out.println( ingredients );
  }
}
