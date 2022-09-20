package mish.vlad.hw_streams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.findEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.findEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> printEmployees() {

        return departmentService.printAll();

    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> printEmployees(@RequestParam(value = "departmentId") Integer departmentId) {
        return departmentService.printDepartment(departmentId);

    }
}
