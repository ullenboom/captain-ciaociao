package com.tutego.exercise.net;

import javax.net.SocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

//tag::solution[]
public class SlangingMatchClient {

  private static final String HOST = "localhost";
  private static final int    PORT = 10_000;

  public static void main( String[] args ) throws IOException {
    while ( true ) {
      String request = new Scanner( System.in ).nextLine();
      remoteSearchInsult( request );
    }
  }

  private static void remoteSearchInsult( String search ) throws IOException {
    try ( Socket socket = SocketFactory.getDefault().createSocket( HOST, PORT );
          PrintWriter requestWriter =
              new PrintWriter( socket.getOutputStream(), true, StandardCharsets.UTF_8 );
          BufferedReader responseReader = new BufferedReader(
              new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8 ) ) ) {
      requestWriter.println( search );
      System.out.println( responseReader.lines().collect( Collectors.joining( "\n" ) ) );
    }
  }
}
//end::solution[]
