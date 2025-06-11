import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    List<Employee> employees;

    Department(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class Main {
    public static void main(String[] args) {
        Department dept1 = new Department(Arrays.asList(
                new Employee("Amit"),
                new Employee("Anjali"),
                new Employee("Bharat"),
                new Employee("Chirag"),
                new Employee("Deepika")
        ));

        Department dept2 = new Department(Arrays.asList(
                new Employee("Esha"),
                new Employee("Farhan"),
                new Employee("Gaurav"),
                new Employee("Harsh"),
                new Employee("Isha")
        ));

        Department dept3 = new Department(Arrays.asList(
                new Employee("Jatin"),
                new Employee("Kavita"),
                new Employee("Lakshmi"),
                new Employee("Manish"),
                new Employee("Neha")
        ));

        List<Department> departments = List.of(dept1, dept2, dept3);

        //  Combine all employees
        List<Employee> allEmployees = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .collect(Collectors.toList());

        System.out.println("All Employees:");
        allEmployees.forEach(e -> System.out.println("- " + e.getName()));

        //  Filter names starting with a specific letter (e.g., 'A')
        String specifiedLetter = "d";
        List<String> filteredByLetter = allEmployees.stream()
                .map(Employee::getName).filter(name -> name.toLowerCase().startsWith(specifiedLetter))
                .sorted().collect(Collectors.toList());

        System.out.println("Employees starting with '" + specifiedLetter + "':");
        filteredByLetter.forEach(System.out::println);

        //  Group sorted names by their first letter
        Map<Character, List<String>> groupedByLetter = allEmployees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("Grouped by First Letter:");
        groupedByLetter.forEach((k, v) -> System.out.println(k + ": " + v));

        Collections.shuffle(allEmployees); // Randomize

        List<List<Employee>> teams = new ArrayList<>();

        for(int i=0;i<5;i++){
            teams.add(new ArrayList<>());
        }
        int cnt=0;
        for(int i=0;i<allEmployees.size();i++){
            if(cnt>=5){
                cnt=0;
            }
            teams.get(cnt).add(allEmployees.get(i));
            cnt++;
        }

        System.out.println("\nSports Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ":");
            teams.get(i).forEach(e -> System.out.println(" - " + e.getName()));
        }

        List<List<Employee>> divisions = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        for (int i = 0; i < teams.size(); i++) {
            divisions.get(i % 3).addAll(teams.get(i));
        }

        System.out.println("Divisions:");
        for (int i = 0; i < divisions.size(); i++) {
            System.out.println("Division " + (i + 1) + ":");
            divisions.get(i).forEach(e -> System.out.println(" - " + e.getName()));
        }
    }
}