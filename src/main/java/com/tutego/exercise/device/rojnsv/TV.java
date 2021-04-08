package com.tutego.exercise.device.rojnsv;

//tag::solution[]
class TV extends ElectronicDevice {

  private MonitorTube monitorTube = new MonitorTube();

  @Override void on() {
    super.on();
    monitorTube.on();
  }

  @Override void off() {
    super.off();
    monitorTube.off();
  }
}
//end::solution[]
