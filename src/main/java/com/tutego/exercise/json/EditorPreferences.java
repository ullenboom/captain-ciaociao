package com.tutego.exercise.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//tag::solution[]
public class EditorPreferences {

  private static final Path FILENAME = Paths.get(
      /*System.getProperty( "user.home" ),*/ ".editor-configuration.json" );

  private final ObjectMapper jsonMapper = new ObjectMapper();

  private Settings settings = new Settings();

  public EditorPreferences() {
    jsonMapper.enable( SerializationFeature.INDENT_OUTPUT );
    jsonMapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
  }

  public Settings settings() {
    return settings;
  }

  public Settings load() {
    try ( InputStream is = Files.newInputStream( FILENAME ) ) {
      settings = jsonMapper.readValue( is, Settings.class );
      return settings;
    }
    catch ( IOException e ) {
      return settings;
    }
  }

  public void save() {
    try ( OutputStream os = Files.newOutputStream( FILENAME ) ) {
      jsonMapper.writeValue( os, settings );
    }
    catch ( IOException e ) {
      throw new IllegalStateException( e );
    }
  }
}
//end::solution[]
