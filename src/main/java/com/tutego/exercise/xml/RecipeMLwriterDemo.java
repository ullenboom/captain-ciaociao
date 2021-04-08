package com.tutego.exercise.xml;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

//tag::solution-a[]
class Recipe {
  String head$title;
  List<String> head$categories;
  String head$yield;
  List<Ingredient> ingredients;
  List<String> directions;

  Recipe( String head$title, List<String> head$categories, String head$yield,
          List<Ingredient> ingredients, List<String> directions ) {
    this.head$title = head$title;
    this.head$categories = head$categories;
    this.head$yield = head$yield;
    this.ingredients = ingredients;
    this.directions = directions;
  }

  static class Ingredient {
    String ing$amt$qty;
    String ing$amt$unit;
    String ing$item;

    Ingredient( String ing$amt$qty, String ing$amt$unit, String ing$item ) {
      this.ing$amt$qty = ing$amt$qty;
      this.ing$amt$unit = ing$amt$unit;
      this.ing$item = ing$item;
    }
  }
}
//end::solution-a[]

public class RecipeMLwriterDemo {

  //tag::solution-b[]
  static Recipe generateRandomRecipe() {
    Recipe.Ingredient ingredient1 = new Recipe.Ingredient( "30", "cups", "fat" );
    Recipe.Ingredient ingredient2 = new Recipe.Ingredient( "1", "kg", "sugar" );
    return new Recipe( "Fat Jam", Arrays.asList( "Canning", "Preserves" ), "8",
                       Arrays.asList( ingredient1, ingredient2 ),
                       Arrays.asList( "Start", "End" ) );
  }
  //end::solution-b[]

  public static void main( String[] args ) throws XMLStreamException {
    Recipe recipe = generateRandomRecipe();
    RecipeMLwriter.writeRecipeAsXml( System.out, recipe );
  }
}

//tag::solution-c[]
class RecipeMLwriter {
  public static void writeRecipeAsXml( OutputStream outputStream, Recipe recipe )
      throws XMLStreamException {
    XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
    XMLStreamWriter writer = outputFactory.createXMLStreamWriter( outputStream,
                                                                  StandardCharsets.UTF_8.name() );
    writeRecipeElements( writer, recipe );
    writer.close();   // This does not close the underlying output stream
  }

  private static void writeCharacters( XMLStreamWriter writer, String name, String string )
      throws XMLStreamException {
    writer.writeStartElement( name );
    writer.writeCharacters( string );
    writer.writeEndElement();
  }

  private static void writeRecipeElements( XMLStreamWriter writer, Recipe recipe )
      throws XMLStreamException {
    writer.writeStartDocument( "utf-8", "1.0" );
    writer.writeComment( "Recipe" );

    writer.writeStartElement( "recipe" );

    writer.writeStartElement( "head" );

    writeCharacters( writer, "title", recipe.head$title );

    writer.writeStartElement( "categories" );
    for ( String cat : recipe.head$categories )
      writeCharacters( writer, "cat", cat );
    writer.writeEndElement(); // </categories>

    writeCharacters( writer, "yield", recipe.head$yield );

    writer.writeEndElement(); // </head>

    writer.writeStartElement( "ingredients" );
    for ( Recipe.Ingredient ingredient : recipe.ingredients )
      writeIngredientElements( writer, ingredient );
    writer.writeEndElement(); // </ingredients>

    writer.writeStartElement( "directions" );
    for ( String step : recipe.directions )
      writeCharacters( writer, "step", step );
    writer.writeEndElement(); // </directions>

    writer.writeEndElement(); // </recipe>

    writer.writeEndDocument();
  }

  private static void writeIngredientElements( XMLStreamWriter writer, Recipe.Ingredient ingredient )
      throws XMLStreamException {
    writer.writeStartElement( "ing" );

    writer.writeStartElement( "amt" );
    writeCharacters( writer, "qty", ingredient.ing$amt$qty );
    writeCharacters( writer, "unit", ingredient.ing$amt$unit );
    writer.writeEndElement(); // </amt>

    writeCharacters( writer, "item", ingredient.ing$item );

    writer.writeEndElement(); // </ing>
  }
}
//end::solution-c[]

/*
<recipeml version="0.5">
  <recipe>
    <head>
      <title>11 Minute Strawberry Jam</title>
      <categories>
        <cat>Canning</cat>
        <cat>Preserves</cat>
        <cat>Jams &amp; jell</cat>
      </categories>
      <yield>8</yield>
    </head>
    <ingredients>
      <ing>
        <amt>
          <qty>3</qty>
          <unit>cups</unit>
        </amt>
        <item>Strawberries</item>
      </ing>
      <ing>
        <amt>
          <qty>3</qty>
          <unit>cups</unit>
        </amt>
        <item>Sugar</item>
      </ing>
    </ingredients>
    <directions>
      <step>Put the strawberries in a pan.</step>
      <step>Add 1 cup of sugar.</step>
      <step>Bring to a boil and boil for 4 minutes.</step>
      <step>Add the second cup of sugar and boil again for 4 minutes.</step>
      <step>Then add the third cup of sugar and boil for 3 minutes.</step>
      <step>Remove from stove, cool, stir occasionally.</step>
      <step>Pour in jars and seal.</step>
    </directions>
  </recipe>
</recipeml>
 */