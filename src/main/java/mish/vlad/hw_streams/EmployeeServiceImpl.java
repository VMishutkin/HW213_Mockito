package mish.vlad.hw_streams;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int EMPLOYEE_LIST_SIZE=5;
    private final List<Employee> employees;


    public EmployeeServiceImpl() {

        this.employees = new ArrayList<Employee>();
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {

        firstName = InputDataService.validateName(firstName);
        lastName = InputDataService.validateSurname(lastName);

        if (employees.contains(new Employee(firstName, lastName, salary, department))) {
            throw new EmployeeAlreadyAddedException();
        }
        if(employees.size()>EMPLOYEE_LIST_SIZE){
            throw new EmployeeStorageIsFullException();
        }

        Employee newEmployee = new Employee(firstName, lastName, salary, department);
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        final String name = InputDataService.validateName(firstName);
        final String surname = InputDataService.validateSurname(lastName);


        Employee removedEmployee = employees.stream()
                .filter(e -> e.getFirstname().equals(name) && e.getLastname().equals(surname))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        employees.remove(removedEmployee);
        return removedEmployee;
    }


    public Employee findEmployee(String firstName, String lastName) {
        final String name = InputDataService.validateName(firstName);
        final String surname = InputDataService.validateSurname(lastName);
        return employees.stream()
                .filter(e -> e.getFirstname().equals(name) && e.getLastname().equals(surname))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }


}
