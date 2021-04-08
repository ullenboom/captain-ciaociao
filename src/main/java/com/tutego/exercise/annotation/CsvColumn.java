package com.tutego.exercise.annotation;

//tag::solution[]
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
public @interface CsvColumn {
  String format() default "";
}
//end::solution[]
