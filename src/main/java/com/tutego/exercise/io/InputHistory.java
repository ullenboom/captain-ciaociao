package com.tutego.exercise.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//tag::solution-a[]
class Inputs implements Serializable {
  private static final long serialVersionUID = 1;

  public static class Input implements Serializable {
    private static final long serialVersionUID = 1;
    CharSequence input;
    LocalDateTime localDateTime = LocalDateTime.now();
  }

  public List<Input> inputs = new ArrayList<>();
}
//end::solution-a[]

//tag::solution-b[]
public class InputHistory {

  private final static Path FILENAME =
      Paths.get( System.getProperty( "java.io.tmpdir" ), "String2Uppercase.ser" );

  private Inputs inputs;

  InputHistory() {
    try ( InputStream       is  = Files.newInputStream( FILENAME );
          ObjectInputStream ois = new ObjectInputStream( is ) ) {
      inputs = (Inputs) ois.readObject();
      inputs.inputs.forEach( input -> System.out.println( input.input ) );
    }
    catch ( IOException | ClassNotFoundException e ) {
      inputs = new Inputs();
      e.printStackTrace();
    }
  }

  void addAndSave( String string ) {
    Inputs.Input newInput = new Inputs.Input();
    newInput.input = string;
    inputs.inputs.add( newInput );

    try ( OutputStream       os  = Files.newOutputStream( FILENAME );
          ObjectOutputStream oos = new ObjectOutputStream( os ) ) {
      oos.writeObject( inputs );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String[] args ) {
    InputHistory inputHistory = new InputHistory();
    for ( String line; (line = new Scanner( System.in ).nextLine()) != null; ) {
      inputHistory.addAndSave( line );
      System.out.println( line.toUpperCase() );
    }
  }
}
//end::solution-b[]
