package mish.vlad.hw_streams;

import java.util.List;

public interface EmployeeService {

    public List<Employee> printEmployees(Integer departmentId);
    public Employee addEmployee(String firstName, String lastName, int salary, int department );
    public Employee removeEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);

    Employee findMaxSalaryByDepartment(Integer departmentId);

    Employee findMinSalaryByDepartment(Integer departmentId);
}
