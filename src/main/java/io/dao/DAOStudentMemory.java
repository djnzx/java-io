package io.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOStudentMemory implements DAO<Student> {

  private final Map<Long, Student> storage = new HashMap<>();

  @Override
  public Optional<Student> get(int id) {
    try {
      return Optional.of(storage.get(id));
    } catch (NullPointerException ex) {
      return Optional.empty();
    }
  }

  @Override
  public Collection<Student> getAll() {
    return storage.values();
  }

  @Override
  public Collection<Student> getAllBy(Predicate<Student> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(Student data) {
    storage.put(data.id, data);
  }

  @Override
  public void delete(int id) {
    storage.remove(id);
  }
}
