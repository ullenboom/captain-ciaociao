package com.tutego.exercise.net;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//tag::solution[]
public class SlangingMatchServer {

  private static final int PORT              = 10_000;
  private static final int MAXIMUM_POOL_SIZE = 10_000;

  public static void main( String[] args ) throws IOException {
    Executor executor = new ThreadPoolExecutor( 0, MAXIMUM_POOL_SIZE,
                                                60, TimeUnit.SECONDS,
                                                new SynchronousQueue<>() );

    try ( ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket( PORT ) ) {
      System.out.println( "Server running at port " + serverSocket.getLocalPort() );

      while ( Thread.currentThread().isInterrupted() ) {
        Socket socket = serverSocket.accept();
        executor.execute( () -> handleConnection( socket ) );
      }
    }
  }

  private static void handleConnection( Socket socket ) {
    try ( Socket __ = socket; // try ( socket ) since Java 9
          Scanner requestReader = new Scanner( socket.getInputStream(), StandardCharsets.UTF_8 );
          PrintWriter responseWriter = new PrintWriter( socket.getOutputStream(),
                                                        true, StandardCharsets.UTF_8 ) ) {
      String request = requestReader.nextLine();
      responseWriter.println( searchInsult( request ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  private static String searchInsult( String search ) {
    return Stream.of( "You, sir, are an oxygen thief!",
                      "Stop trying to be a smart ass, you're just an ass.",
                      "Shock me, say something intelligent." )
                 .filter( s -> s.toLowerCase().contains( search.toLowerCase() ) )
                 .collect( Collectors.joining( "\n" ) );
  }
}
//end::solution[]
