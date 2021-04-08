//tag::solution[]
package com.tutego.exercise.device.fzrcph;

import static com.tutego.exercise.device.fzrcph.Radio.Modulation.*;

public class Application3 {
  public static void main( String[] args ) {
    Radio radio = new Radio();
    radio.setModulation( AM );
  }
}
//end::solution[]
