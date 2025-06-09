package service;

import model.Employee;
import model.EmployeeItem;
import repository.EmployeeRepo;

import java.time.LocalDate;
import java.util.*;

public class EmployeeCoordinator {
    private final Map<Employee, List<EmployeeItem>> workerAssignments;
    private final EmployeeRepo<EmployeeItem> itemStorage;

    public EmployeeCoordinator() {
        this.workerAssignments = new HashMap<>();
        this.itemStorage = new EmployeeRepo<>();
    }

    public void assignWorkToWorker(Employee employee, EmployeeItem item) {
        workerAssignments.computeIfAbsent(employee, k -> new ArrayList<>()).add(item);
        itemStorage.storeItem(item);
    }

    public List<EmployeeItem> getWorkerTasks(Employee employee) {
        return workerAssignments.getOrDefault(employee, Collections.emptyList());
    }

    public List<EmployeeItem> organizeByPriority(Employee employee) {
        List<EmployeeItem> items = getWorkerTasks(employee);
        items.sort(Comparator.naturalOrder());
        return items;
    }

    public List<EmployeeItem> organizeByDeadline(Employee employee) {
        List<EmployeeItem> items = getWorkerTasks(employee);
        items.sort(Comparator.comparing(EmployeeItem::getDeadline));
        return items;
    }

    public List<EmployeeItem> searchInDescriptions(String searchTerm) {
        return itemStorage.findItems(item ->
                item.getItemDetails().toLowerCase().contains(searchTerm.toLowerCase()));
    }

    public List<EmployeeItem> getOverdueItems() {
        return itemStorage.findItems(EmployeeItem::isPastDue);
    }

    public List<EmployeeItem> getItemsDueSoon() {
        return itemStorage.findItems(item ->
                item.getDeadline().equals(LocalDate.now().plusDays(1)));
    }

    public List<Employee> getOverloadedWorkers(int taskThreshold) {
        return workerAssignments.entrySet().stream()
                .filter(entry -> {
                    long pendingCount = entry.getValue().stream()
                            .filter(item -> item.getCurrentStatus() == EmployeeItem.WorkStatus.NEW)
                            .count();
                    return pendingCount > taskThreshold;
                })
                .map(Map.Entry::getKey)
                .toList();
    }
}