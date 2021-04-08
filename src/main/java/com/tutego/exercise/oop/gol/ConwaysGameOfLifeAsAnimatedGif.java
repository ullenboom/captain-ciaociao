package com.tutego.exercise.oop.gol;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class ConwaysGameOfLifeAsAnimatedGif {
  public static void main( String[] args ) throws IOException {
    int size = 300;
    Cells cells = new Cells( size ).randomCellsAlive();
    File gif = File.createTempFile( "ConwaysGameOfLife", ".gif" );
    System.out.println( gif.getAbsolutePath() );

    try ( ImageOutputStream output = new FileImageOutputStream( gif );
          GifSequenceWriter writer = new GifSequenceWriter( output, BufferedImage.TYPE_INT_ARGB, 200, true ) ) {

      BufferedImage img = new BufferedImage( size * 2, size * 2, BufferedImage.TYPE_INT_ARGB );

      for ( int generation = 0; generation < 1000; generation++ ) {

        for ( int y = 0; y < size; y++ ) {
          for ( int x = 0; x < size; x++ ) {
            int color = cells.isLiveAt( x, y ) ? Color.BLACK.getRGB() : Color.LIGHT_GRAY.getRGB();
            img.setRGB( 2*x,   2*y,   color );
            img.setRGB( 2*x+1, 2*y,   color );
            img.setRGB( 2*x,   2*y+1, color );
            img.setRGB( 2*x+1, 2*y+1, color );
          }
        }
        
        writer.writeToSequence( img );
        cells = cells.nextGeneration();
      }
    }
    Desktop.getDesktop().open( gif );
  }
}
