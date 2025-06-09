package repository;

import exception.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeRepo<T> {
    private final List<T> storedItems = new ArrayList<>();

    public void storeItem(T item) {
        storedItems.add(item);
    }

    public void removeItem(T item) {
        if (!storedItems.remove(item)) {
            throw new ItemNotFoundException("Specified work item not found");
        }
    }

    public T fetchItemById(int id) {
        return storedItems.stream()
                .filter(item -> {
                    if (item instanceof model.EmployeeItem) {
                        return ((model.EmployeeItem) item).getItemId() == id;
                    }
                    return false;
                })
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }

    public List<T> getAllStoredItems() {
        return new ArrayList<>(storedItems);
    }

    public List<T> findItems(Predicate<T> condition) {
        return storedItems.stream()
                .filter(condition)
                .toList();
    }
}