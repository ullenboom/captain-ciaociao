package com.tutego.exercise.oop.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group extends Form {

  private final List<Form> forms = new ArrayList<>();

  public void add( Form form ) {
    forms.add( form );
  }

  @Override
  public double area() {
    return forms.stream().mapToDouble( Form::area ).sum();
  }

  public Form maximum() {
    if ( forms.isEmpty() )
      return null;
    return Collections.max( forms, new FormSizeComparator() );
  }

  @Override
  public String toString() {
    return "Group[" + forms + "]";
  }
}
