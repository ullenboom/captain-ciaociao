package com.tutego.exercise.thread;

import java.io.IOException;
import java.net.*;
import java.time.*;
import java.util.concurrent.*;

//tag::solution-1[]
class WebResourceLastModifiedCallable implements Callable<ZonedDateTime> {

  private final URL url;

  WebResourceLastModifiedCallable( URL url ) {
    this.url = url;
  }

  @Override public ZonedDateTime call() throws IOException {
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    long dateTime = con.getLastModified();
    con.disconnect();
    return ZonedDateTime.ofInstant( Instant.ofEpochMilli( dateTime ), ZoneId.of( "UTC" ) );
  }
}
//end::solution-1[]

public class PageLastModifiedCallableDemo {
  public static void main( String[] args ) throws MalformedURLException {
    //tag::solution-2[]
    ExecutorService executor = Executors.newCachedThreadPool();
    URL url = new URL( "https://en.wikipedia.org/wiki/Main_Page" );
    Callable<ZonedDateTime> callable = new WebResourceLastModifiedCallable( url );

    Future<ZonedDateTime> dateTimeFuture = executor.submit( callable );

    try {
      System.out.println( executor.submit( callable ).get( 1, TimeUnit.MICROSECONDS ) );
    }
    catch ( InterruptedException | ExecutionException | TimeoutException e ) {
      e.printStackTrace();
    }

    try {
      ZonedDateTime wikiChangedDateTime = dateTimeFuture.get();
      System.out.println( wikiChangedDateTime );
      System.out.println( Duration.between( wikiChangedDateTime,
                                            ZonedDateTime.now( ZoneId.of( "UTC" ) ) ).toMinutes() );
    }
    catch ( InterruptedException | ExecutionException e ) {
      e.printStackTrace();
    }

    executor.shutdown();
    //end::solution-2[]
  }
}
