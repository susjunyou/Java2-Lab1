import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee(Name: " + name + ", Age: " + age + ")";
    }
}

class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(String name, int age) {
        // 检查员工是否已经存在，避免重复添加
        for (Employee emp : employees) {
            if (emp.getName().equals(name)) {
                System.out.println("Employee " + name + " already exists. Skipping addition.");
                return;
            }
        }
        Employee newEmployee = new Employee(name, age);
        employees.add(newEmployee);
        System.out.println("Added " + newEmployee);
    }

    public void deleteEmployee(String name) {
        for (Employee emp : employees) {
            if (emp.getName().equals(name)) {
                employees.remove(emp);
                System.out.println("Deleted employee: " + name);
                return;
            }
        }
        System.out.println("Employee " + name + " not found.");
    }

    public void printEmployees() {
        // 按名字字母顺序排序
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

public class Practice {
    public static void main(String[] args) {
        EmployeeManagement managementSystem = new EmployeeManagement();

        // 1. 添加3个员工 A, B, C
        managementSystem.addEmployee("A", 30);
        managementSystem.addEmployee("B", 25);
        managementSystem.addEmployee("C", 40);

        // 2. 删除员工 B
        managementSystem.deleteEmployee("B");

        // 3. 添加2个员工 A, D
        managementSystem.addEmployee("A", 30); // 不应重复添加
        managementSystem.addEmployee("D", 35);

        // 4. 打印所有员工
        managementSystem.printEmployees();
    }
}