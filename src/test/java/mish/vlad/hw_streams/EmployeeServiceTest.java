package mish.vlad.hw_streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    List<Employee> employeesForTest;


/*    public static Stream<Arguments> EmployeeParamsForTest() {
        return Stream.of(Arguments.of("IVAn", "PSOv", 12411, 2),
                Arguments.of("PES", "Koshkin-MyshKIN", 23521, 1),
                Arguments.of("Polyak", "Polyakov", 63443, 1),
                Arguments.of("AnNa", "PAVLOva", 87221, 1),
                Arguments.of("ALeX", "Belyashikov", 11123, 2)
        );
    }*/

    @BeforeEach
    private void returnTestEmployees() {
        employeesForTest= new ArrayList<>();
        employeesForTest.add(new Employee("Ivan", "PSoV", 12411, 2));
        employeesForTest.add(new Employee("PES", "KoshKIN", 23521, 1));
        employeesForTest.add(new Employee("Polyak", "Polyakov-StarYY", 63443, 1));
        employeesForTest.add(new Employee("Anna", "PAVLova", 87221, 1));
        employeesForTest.add(new Employee("ALex", "BelYAshikov", 11123, 2));
        for (Employee employee : employeesForTest) {
            employeeService.addEmployee(employee.getFirstname(), employee.getLastname(), employee.getSalary(), employee.getDepartment());
        }
    }

/*
    @ParameterizedTest
    @MethodSource("EmployeeParamsForTest")
    public void addingEmployees(String name, String lastname, int salary, int departmentId) {
        Employee expected = new Employee(name, lastname, salary, departmentId);
        assertEquals(expected,employeeService.addEmployee(name, lastname, salary, departmentId));
    }
*/
    @Test
    public void getEmployees() {


        assertEquals(employeesForTest, employeeService.getEmployees());
    }
    @Test
    public void removeEmployee(){

        assertEquals(employeeService.removeEmployee("PES", "KOSHKIN"), new Employee("Pes", "Koshkin", 23521, 1));
    }

    @Test
    public void findEmployee(){

        assertEquals(employeeService.findEmployee("PES", "KOSHKIN"), new Employee("Pes", "Koshkin", 23521, 1));
    }

    @Test
    public void getInvalidInput() {
        assertThrows(InvalidInputException.class, () -> employeeService.addEmployee("V@sya", "Bublikov", 12341, 1));
    }

    @Test
    public void getNotFound(){

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Pesa", "Koshkin"));
    }

    @Test
    public void getAlreadyAdded(){

        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Alex", "belyashikov", 12411, 1));
    }

    @Test
    public void getStorageFull(){
      //  System.out.println(employeeService.getEmployees().size());
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("Another", "One", 11111, 2));

    }




}
