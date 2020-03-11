package io.dao;

import java.io.Serializable;

public class Student implements Serializable, Identifiable {
  final long id;
  final String name;
  final int age;

  private static final long serialVersionUID = 1L;

  @Override
  public long getId() {
    return id;
  }

  public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public static Student parse(String line) {
    String[] chunks = line.split(":");
    return new Student(
        Integer.parseInt(chunks[0]),
        chunks[1],
        Integer.parseInt(chunks[2])
    );
  }

  public String represent() {
    return String.format("%d:%s:%d", id, name, age);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;

    if (id != student.id) return false;
    if (age != student.age) return false;
    return name != null ? name.equals(student.name) : student.name == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + age;
    return result;
  }

  @Override
  public String toString() {
    return String.format("Student[id=%d, name='%s', age=%d]", id, name, age);
  }

}
