package pro.sky.java.collectionslists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(

            new Employee("Иван", "Иванов"),
            new Employee("Борис", "Петров"),
            new Employee("Роман", "Круглов"),
            new Employee("Наталья", "Громова"),
            new Employee("Нина", "Попова"),
            new Employee("Алексей", "Панов"),
            new Employee("Мария", "Финкова"),
            new Employee("Никита", "Фоменко"),
            new Employee("Анатолий", "Яшин"),
            new Employee("Светлана", "Фрунзе")
    ));


    public String findEmployee(String firstName, String lastName) {

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String addEmployee(String firstName, String lastName) {
        final int employeeListSize;
        employeeListSize = 9;
        if (employees.size() > employeeListSize) {
            throw new EmployeeStorageIsFullException();
        }
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException();
            }
        }

        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);

        return employee.toString();
    }

    public String removeEmployee(String firstName, String lastName) {

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(i);
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String allEmployees() {

        return employees.toString();
    }
}





