package com.tutego.exercise.fileformat;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ScreenCapturesInDocx {

  //tag::solution[]
  private static final int TOTAL_NUMBER_OF_SCREEN_CAPTURES  = 3;
  private static final int DURATION_BETWEEN_SCREEN_CAPTURES = 5;
  private static final Rectangle SCREEN_SIZE =
      new Rectangle( Toolkit.getDefaultToolkit().getScreenSize() );

  private static byte[] getScreenCapture() throws AWTException, IOException {
    BufferedImage screenCapture = new Robot().createScreenCapture( SCREEN_SIZE );
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write( screenCapture, "jpeg", os );
    return os.toByteArray();
  }

  private static void appendImage( XWPFDocument doc, byte[] imageBytes )
      throws IOException, InvalidFormatException {
    XWPFRun paragraph = doc.createParagraph().createRun();
    paragraph.addPicture( new ByteArrayInputStream( imageBytes ), Document.PICTURE_TYPE_JPEG,
                          UUID.randomUUID().toString(),
                          Units.toEMU( SCREEN_SIZE.width / 100. * 20 ),
                          Units.toEMU( SCREEN_SIZE.height / 100. * 20 ) );
    paragraph.addBreak();
  }

  public static void main( String[] args ) throws Exception {
    try ( XWPFDocument xwpfDocument = new XWPFDocument() ) {
      for ( int i = 0; i < TOTAL_NUMBER_OF_SCREEN_CAPTURES; i++ ) {
        appendImage( xwpfDocument, getScreenCapture() );
        TimeUnit.SECONDS.sleep( DURATION_BETWEEN_SCREEN_CAPTURES );
      }

      Path tempFile = Files.createTempFile( "screen-captures", ".docx" );
      try ( OutputStream out = Files.newOutputStream( tempFile ) ) {
        xwpfDocument.write( out );
      }
      System.out.println( "Written to " + tempFile );
    }
  }
  //end::solution[]
}
