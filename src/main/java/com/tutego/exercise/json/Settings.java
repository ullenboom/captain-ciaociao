package com.tutego.exercise.json;

//tag::solution[]
import java.util.*;

public class Settings {

  enum FontWeight {
    normal, bold;
  }

  public static class Editor {
    public String cursorStyle = "line";
    public boolean folding = true;
    public List<String> fontFamily = Arrays.asList( "Consolas, 'Courier New', monospace" );
    public int fontSize = 14;
    public FontWeight fontWeight = FontWeight.normal;
  }

  public static class Workbench {
    public String colorTheme = "Default Dark+";
    public String iconTheme;
  }

  public Editor editor = new Editor();
  public Workbench workbench = new Workbench();
  public Map<String, String> terminal = new HashMap<>();
}
//end::solution[]
