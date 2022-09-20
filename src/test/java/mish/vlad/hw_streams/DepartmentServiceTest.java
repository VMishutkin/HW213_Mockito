package mish.vlad.hw_streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    DepartmentService departmentService;

    @Mock
    private EmployeeService employeeServiceMock;

    List<Employee> employeesForTest;


    @BeforeEach
    private void init() {
/*        employeeServiceMock.addEmployee("Ivan", "IvaNOV", 12121, 2);
        employeeServiceMock.addEmployee("PetR", "Petrov", 22221, 1);
        employeeServiceMock.addEmployee("AleX", "KuleBYAkov", 52521, 1);
        employeeServiceMock.addEmployee("John", "Douh", 22355, 2);*/
        employeesForTest = new ArrayList<>();
        employeesForTest.add(new Employee("Ivan", "Ivanov", 12121, 2));
        employeesForTest.add(new Employee("Petr", "Petrov", 22221, 1));
        employeesForTest.add(new Employee("Alex", "Kulebyakov", 52521, 1));
        employeesForTest.add(new Employee("John", "Douh", 22355, 2));
        departmentService = new DepartmentServiceImpl(employeeServiceMock);

    }

    @Test
    public void findEmplWithMaxSalary() {
        assertNotNull(employeeServiceMock);
        Mockito.when(employeeServiceMock.getEmployees()).thenReturn(employeesForTest);
        assertEquals(new Employee("John", "Douh", 22355, 2),departmentService.findEmployeeWithMaxSalaryByDepartment(2));
    }
    @Test
    public void findEmplWithMinSalary() {
        assertNotNull(employeeServiceMock);
        Mockito.when(employeeServiceMock.getEmployees()).thenReturn(employeesForTest);
        assertEquals(new Employee("Petr", "Petrov", 1, 1),departmentService.findEmployeeWithMinSalaryByDepartment(1));
    }

    @Test
    public void missedDepartmentInSearch(){

        Mockito.when(employeeServiceMock.getEmployees()).thenReturn(employeesForTest);
        assertThrows(EmployeeNotFoundException.class, () ->departmentService.findEmployeeWithMaxSalaryByDepartment(10));
    }





}
