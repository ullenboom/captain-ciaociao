package com.tutego.exercise.net;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//tag::solution-a[]
enum Protocol {
  TCP {
    @Override AutoCloseable openSocket( int port ) throws IOException {
      return ServerSocketFactory.getDefault().createServerSocket( port );
    }
  },
  UDP {
    @Override AutoCloseable openSocket( int port ) throws IOException {
      return new DatagramSocket( port );
    }
  };

  abstract AutoCloseable openSocket( int port ) throws IOException;

  public boolean isAvailable( int port ) {
    try ( AutoCloseable __ = openSocket( port ) ) { return true; }
    catch ( Exception e ) { return false; }
  }

  private static final String COMPRESSED_SERVICE_NAMES =
      "7 Echo\n13 Daytime\n20 FTP\n21 FTP\n22 SSH\n23 Telnet\n25 SMTP\n53 DNS\n80 HTTP\n"
      + "135 EPMAP\n137 NetBIOS Name Service\n138 NetBIOS Datagram Service\n139 NetBIOS Session Service\n"
      + "445 Microsoft-DS Active Directory\n843 Adobe Flash\n"
      + "1900 Simple Service Discovery Protocol (SSDP)\n3702 Web Services Dynamic Discovery\n"
      + "5353 Multicast DNS\n5355 Link-Local Multicast Name Resolution (LLMNR)\n"
      + "17500 Dropbox\n27017 MongoDB\n";

  private static final Map<Integer, String> SERVICE_NAMES =
      Pattern.compile( "\n" )
             .splitAsStream( COMPRESSED_SERVICE_NAMES )
             .map( Scanner::new )
             .collect( Collectors.toMap( Scanner::nextInt, Scanner::nextLine ) );

  static String serviceName( int port ) {
    return Optional.ofNullable( SERVICE_NAMES.get( port ) ).orElse( "" );
  }
}
//end::solution-a[]

public class PortScanner {

  public static void main( String[] args ) {
    //tag::solution-b[]
    final int MIN_SYSTEM_PORT     =     0;
    //    final int MAX_SYSTEM_PORT     =  1023;
    //    final int MIN_REGISTERED_PORT =  1024;
    final int MAX_REGISTERED_PORT = 49151;

    System.out.println( "Protocol   Port       Service" );
    for ( int port = MIN_SYSTEM_PORT; port <= MAX_REGISTERED_PORT; port++ ) {
      for ( Protocol protocol : Protocol.values() )
        if ( ! protocol.isAvailable( port ) )
          System.out.printf( "%s       %5d      %s%n",
                             protocol, port,    Protocol.serviceName( port ) );
    }
    //end::solution-b[]
  }
}
