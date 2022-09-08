package mish.vlad.hw_streams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в самый убогий справочник сотрудников";
    }

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("departmentId") int departmentId) {
        return employeeService.addEmployee(firstName, lastName,salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {

        return employeeService.findEmployee(firstName, lastName);

    }



    @GetMapping("/max-salary")
    public Employee findMaxSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return employeeService.findMaxSalaryByDepartment(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee findMinSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return employeeService.findMinSalaryByDepartment(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> printEmployees(
            @RequestParam(value = "departmentId", required = false) Integer departmentId) {

        return employeeService.printEmployees(departmentId);
    }


}
