package com.tutego.exercise.annotation;

import java.io.StringWriter;

//tag::example-1[]
@Csv
class Pirate {
  @CsvColumn String name;
  @CsvColumn String profession;
  @CsvColumn int height;
  @CsvColumn( format = "### €" ) double income;
  @CsvColumn( format = "###.00" ) Object weight;
  String secrets;
}
//end::example-1[]

public class CsvPirateWriter {
  public static void main( String[] args ) {
    //tag::example-2[]
    Pirate p1 = new Pirate();
    p1.name = "Hotzenplotz";
    p1.profession = null;
    p1.height = 192;
    p1.income = 124234.3234;
    p1.weight = 89.10;
    p1.secrets = "kinky";

    StringWriter writer = new StringWriter();
    try ( CsvWriter<Pirate> csvWriter =
              new CsvWriter<>( Pirate.class, writer ).delimiter( ',' ) ) {
      csvWriter.writeObject( p1 );
      csvWriter.writeObject( p1 );
    }
    System.out.println( writer );
    //end::example-2[]
  }
}
