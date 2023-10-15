package com.kodilla.converter.own;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class Student
{
  private String indexNumber;
  private String name;
  private String surname;

  public Student()
  {
  }

  public Student(String indexNumber, String name, String surname)
  {
    this.indexNumber = indexNumber;
    this.name = name;
    this.surname = surname;
  }

  public String getIndexNumber()
  {
    return indexNumber;
  }

  public void setIndexNumber(String indexNumber)
  {
    this.indexNumber = indexNumber;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }
}
