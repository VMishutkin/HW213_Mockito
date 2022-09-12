package mish.vlad.hw_streams;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;


    public EmployeeServiceImpl() {

        this.employees = new ArrayList<Employee>();
    }
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        if (employees.contains(new Employee(firstName, lastName, salary, department))) {
            throw new EmployeeAlreadyAddedException();
        }

        Employee newEmployee = new Employee(firstName, lastName, salary, department);
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee removedEmployee = employees.stream()
                .filter(e -> e.getFirstname().equals(firstName) && e.getLastname().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        employees.remove(removedEmployee);
        return removedEmployee;
    }


    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstname().equals(firstName) && e.getLastname().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }


}
