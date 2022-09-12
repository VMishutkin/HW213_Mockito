package mish.vlad.hw_streams;

import java.util.List;

public interface EmployeeService {


    List<Employee> getEmployees();

    public Employee addEmployee(String firstName, String lastName, int salary, int department );
    public Employee removeEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);



}
