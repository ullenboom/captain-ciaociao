package com.tutego.exercise.lang;

class EqualsHashCodePerson1 {

  static class Person {
    public long id;
    public int age;
    public double income;
    public boolean isDrugLord;
    public String name;

    @Override
    //tag::equals_intellj[]
    public boolean equals( Object o ) {
      if ( this == o )
        return true;
      if ( o == null || getClass() != o.getClass() )
        return false;

      Person person = (Person) o;

      if ( id != person.id )
        return false;
      if ( age != person.age )
        return false;
      if ( Double.compare( person.income, income ) != 0 )
        return false;
      if ( isDrugLord != person.isDrugLord )
        return false;
      return name != null ? name.equals( person.name ) : person.name == null;
    }
    //end::equals_intellj[]

    @Override
    //tag::hashcode_intellj[]
    public int hashCode() {
      int result;
      long temp;
      result = (int) (id ^ (id >>> 32));
      result = 31 * result + age;
      temp = Double.doubleToLongBits( income );
      result = 31 * result + (int) (temp ^ (temp >>> 32));
      result = 31 * result + (isDrugLord ? 1 : 0);
      result = 31 * result + (name != null ? name.hashCode() : 0);
      return result;
    }
    //end::hashcode_intellj[]
  }
}

class EqualsHashCodePerson2 {

  static class Person {
    public long id;
    public int age;
    public double income;
    public boolean isDrugLord;
    public String name;

    @Override
    //tag::hashcode_eclipse[]
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + (int) (id ^ (id >>> 32));
      long temp;
      temp = Double.doubleToLongBits( income );
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + (isDrugLord ? 1231 : 1237);
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
    }
    //end::hashcode_eclipse[]

    @Override
    //tag::equals_eclipse[]
    public boolean equals( Object obj ) {
      if ( this == obj )
        return true;
      if ( obj == null )
        return false;
      if ( getClass() != obj.getClass() )
        return false;
      Person other = (Person) obj;
      if ( age != other.age )
        return false;
      if ( id != other.id )
        return false;
      if ( Double.doubleToLongBits( income ) !=
           Double.doubleToLongBits( other.income ) )
        return false;
      if ( isDrugLord != other.isDrugLord )
        return false;
      if ( name == null ) {
        if ( other.name != null )
          return false;
      }
      else if ( !name.equals( other.name ) )
        return false;
      return true;
    }
    //end::equals_eclipse[]
  }
}