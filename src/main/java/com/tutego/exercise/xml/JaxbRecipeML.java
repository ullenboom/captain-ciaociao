package com.tutego.exercise.xml;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlRootElement;

//tag::solution[]
@XmlRootElement
class Ingredients {
  public Ing[] ing;
}

class Ing {
  public Amt amt;
  public String item;
}

class Amt {
  public int qty;
  public String unit;
}
//end::solution[]

public class JaxbRecipeML {
  public static void main( String[] args ) {
    //tag::example[]
    Ing ing1 = new Ing();
    Amt amt1 = new Amt();
    amt1.qty = 3;
    amt1.unit = "cups";
    ing1.amt = amt1;
    ing1.item = "Strawberries";

    Ing ing2 = new Ing();
    Amt amt2 = new Amt();
    amt2.qty = 3;
    amt2.unit = "cups";
    ing2.amt = amt2;
    ing2.item = "Sugar";

    Ingredients ingredients = new Ingredients();
    ingredients.ing = new Ing[]{ ing1, ing2 };

    JAXB.marshal( ingredients, System.out );
    //end::example[]
  }
}
