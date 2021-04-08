package com.tutego.exercise.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

  public static void main( String[] args ) {
    //tag::solution[]
    // A string of exactly 10 digits

    Pattern p12 = Pattern.compile( "\\d{10}" );
    Matcher m12 = p12.matcher( "0123456789" );
    System.out.println( m12.matches() );       // true
    Pattern p11 = Pattern.compile( "\\d{10}" );
    Matcher m11 = p11.matcher( "1" );
    System.out.println( m11.matches() );                // false
    Pattern p10 = Pattern.compile( "\\d{10}" );
    Matcher m10 = p10.matcher( "abcdefghij" );
    System.out.println( m10.matches() );       // false

    // A string of 5 to 10 numbers and letters.

    Pattern p9 = Pattern.compile( "\\d{5,10}" );
    Matcher m9 = p9.matcher( "01234567" );
    System.out.println( m9.matches() );       // true
    Pattern p8 = Pattern.compile( "\\d{5,10}" );
    Matcher m8 = p8.matcher( "0" );
    System.out.println( m8.matches() );              // false
    Pattern p7 = Pattern.compile( "\\d{5,10}" );
    Matcher m7 = p7.matcher( "01234567890123" );
    System.out.println( m7.matches() ); // false

    // A string that ends with `.`, `!` or `?`, like a sentence.

    Pattern p6 = Pattern.compile( ".*?[.!?]" );
    Matcher m6 = p6.matcher( "Ja? Ja!" );
    System.out.println( m6.matches() );         // true
    Pattern p5 = Pattern.compile( ".*?[.!?]" );
    Matcher m5 = p5.matcher( "Nein?" );
    System.out.println( m5.matches() );           // true
    Pattern p4 = Pattern.compile( ".*?[.!?]" );
    Matcher m4 = p4.matcher( "Ok." );
    System.out.println( m4.matches() );             // true
    Pattern p3 = Pattern.compile( ".*?[.!?]" );
    Matcher m3 = p3.matcher( "No" );
    System.out.println( m3.matches() );              // true

    // A string that contains no digits.

    Pattern p2 = Pattern.compile( "\\D*" );
    Matcher m2 = p2.matcher( "Ciao" );
    System.out.println( m2.matches() );                // true
    Pattern p1 = Pattern.compile( "\\D*" );
    Matcher m1 = p1.matcher( "Cia0" );
    System.out.println( m1.matches() );                // false
    Pattern p = Pattern.compile( "\\D*" );
    Matcher m = p.matcher( "" );
    System.out.println( m.matches() );                    // false

    // The official title, Prof., Dr., Dr. med., Dr. h.c.

    Pattern pattern = Pattern.compile( "(Prof\\.|Dr\\. med\\.|Dr\\. h\\.c\\.|Dr\\.)\\s" );
    System.out.println( pattern.matcher( "Hallo Herr Dr. Miles" ).find() ); // true
    System.out.println( pattern.matcher( "Nix mit Dr. h.c. Thai med." ).find() ); // true
    System.out.println( pattern.matcher( "Megan Dr.Thai" ).find() ); // false
    //end::solution[]
  }
}
