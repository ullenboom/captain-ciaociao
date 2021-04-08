package com.tutego.exercise.device;

import java.util.*;
import javax.swing.event.EventListenerList;

public class ShipWithModificationEvents {

  public static void main( String[] args ) {
    Ship bude = new Ship();
    ElectronicDevice radio = new IceMachine();
    ElectronicDevice tv = new TV();
    bude.addModificationListener( e -> System.out.println( "Neues Element" ) );
    bude.add( radio ); // Meldung vom Listener
    bude.add( tv ); // Meldung vom Listener

  }
}

class ModificationEvent extends EventObject {
  public ModificationEvent( Object source ) {
    super( source );
  }
}

interface ModificationListener extends EventListener {
  void onModify( ModificationEvent e );
}

class Ship {
  private final ArrayList<ElectronicDevice> devices = new ArrayList<>();
  private final EventListenerList listeners = new EventListenerList();

  void add( ElectronicDevice e ) {
    devices.add( e );

    // Notify all interested parties
    for ( ModificationListener listener : listeners.getListeners( ModificationListener.class ) ) {
      ModificationEvent event = new ModificationEvent( this );
      listener.onModify( event );
    }
  }

  public void addModificationListener( ModificationListener listener ) {
    listeners.add( ModificationListener.class, listener );
  }
}

class ElectronicDevice {
}

class IceMachine extends ElectronicDevice {
}

class TV extends ElectronicDevice {
}