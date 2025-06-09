package repository;

import exception.LibraryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Repository<T> {
    private final Map<String, T> storage = new HashMap<>();
    private final String entityName;

    public Repository(String entityName) {
        this.entityName = entityName;
    }

    public void add(String id, T entity) {
        storage.put(id, entity);
    }

    public T get(String id) throws LibraryException {
        T entity = storage.get(id);
        if (entity == null) {
            throw new LibraryException(entityName + " with ID " + id + " not found");
        }
        return entity;
    }

    public void remove(String id) throws LibraryException {
        if (!storage.containsKey(id)) {
            throw new LibraryException(entityName + " with ID " + id + " not found");
        }
        storage.remove(id);
    }
//Allows filtering/searching entities using a condition.
    public List<T> search(Predicate<T> condition) {
        List<T> results = new ArrayList<>();
        for (T entity : storage.values()) {
            if (condition.test(entity)) {
                results.add(entity);
            }
        }
        return results;
    }

    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }
}