package com.tutego.exercise.thread;

public class ParameterizedRunnable {
  static
  //tag::solution-1[]
  class PrintingRunnable implements Runnable {
    private final String text;
    private final int repetitions;

    PrintingRunnable( String text, int repetitions ) {
      this.text = text;
      this.repetitions = repetitions;
    }

    @Override public void run() {
      for ( int i = 0; i < repetitions; i++ )
        System.out.printf( "%s; %s%n", text, Thread.currentThread() );
    }
  }
  //end::solution-1[]

  //tag::solution-2[]
  public static Runnable getPrintingRunnable( String text, int repetitions ) {
    return () -> {
      for ( int i = 0; i < repetitions; i++ )
        System.out.printf( "%s; %s%n", text, Thread.currentThread() );

    };
  }
  //end::solution-2[]

  public static void main( String[] args ) {
    Runnable r1 = new PrintingRunnable( "Wink", 30 );
    Runnable r2 = getPrintingRunnable( "Wave flag", 50 );
  }
}
