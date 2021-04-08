package com.tutego.exercise.json;

public class EditorPreferencesDemo {
  public static void main( String[] args ) {
    //tag::solution[]
    EditorPreferences preferences = new EditorPreferences();
    preferences.save();

    Settings settings = preferences.load();
    settings.editor.fontSize = 22;
    settings.terminal.put( "integrated.unicodeVersion", "11" );
    preferences.save();
    //end::solution[]
  }
}
