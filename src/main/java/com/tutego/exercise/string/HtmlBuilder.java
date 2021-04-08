package com.tutego.exercise.string;

public class HtmlBuilder {

  //tag::solution[]
  public static String htmlElement( String tag, String body ) {
    if ( tag == null )
      tag = "";
    if ( body == null )
      body = "";
    if ( tag.isEmpty() )
      return body;
    else
      return "<" + tag + ">" + body + "</" + tag + ">";
  }

  public static String strong( String body ) {
    return htmlElement( "strong", body );
  }

  public static String emphasized( String body ) {
    return htmlElement( "em", body );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( htmlElement( "strong", "strong is bold" ) );
    System.out.println( strong( emphasized( "strong + emphasized" ) ) );
    System.out.println( htmlElement( "span", null ) );
    System.out.println( htmlElement( "", "no" ) );
    System.out.println( htmlElement( null, "not bold" ) );
    System.out.println( htmlElement( null, null ) );
  }
}
