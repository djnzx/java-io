package io.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOStudentFileText implements DAO<Student> {

  private File file;

  public DAOStudentFileText(String filename) {
    this.file = new File(filename);
  }

  @Override
  public Collection<Student> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().map(Student::parse).collect(Collectors.toList());
    } catch (IOException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Optional<Student> get(int id) {
    return getAll().stream().filter(s -> s.id == id).findFirst();
  }

  @Override
  public Collection<Student> getAllBy(Predicate<Student> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(Student student) {
    Collection<Student> students = getAll();
    students.add(student);
    write(students);
  }

  @Override
  public void delete(int id) {
    Collection<Student> students = getAllBy(s -> s.id != id);
    write(students);
  }

  private void write(Collection<Student> students) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (Student s: students) {
        bw.write(s.represent());
        bw.write("\n");
      }
    } catch (IOException ex) {
      throw new RuntimeException("DAO:write:IOException", ex);
    }
  }

}
