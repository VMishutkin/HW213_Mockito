package mish.vlad.hw_streams;

import java.util.List;
import java.util.Map;

public interface DepartmentService {


    Employee findEmployeeWithMaxSalaryByDepartment(Integer departmentId);

    Employee findMinSalaryByDepartment(Integer departmentId);

    public Map<Integer, List<Employee>> printAll();

    public List<Employee> printDepartment(Integer departmentId);
}
