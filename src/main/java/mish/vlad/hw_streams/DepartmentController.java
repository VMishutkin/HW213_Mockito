package mish.vlad.hw_streams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/departments")

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.findMaxSalaryByDepartment(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee findMinSalalryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.findMinSalaryByDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> printEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if(departmentId==null) {
            return departmentService.printAll();
        }
        else{
          return new HashMap<Integer, List<Employee>>(Map.of(departmentId, departmentService.printDepartment(departmentId)));
        }

    }
}
