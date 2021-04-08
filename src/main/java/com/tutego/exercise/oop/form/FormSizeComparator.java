package com.tutego.exercise.oop.form;

import java.util.Comparator;

public class FormSizeComparator implements Comparator<Form> {
  @Override
  public int compare( Form f1, Form f2 ) {
    return Double.compare( f1.area(), f2.area() );
  }
}