/*
package mish.vlad.hw_streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeBook {
    private Map<String, Employee> employees;// массив сотрудников

    public EmployeeBook() {
        //Реализовал возможность динамически менять размер массива, чтобы не использовать коллекции а воспользоваться только пройденным материалом
        employees = new HashMap<String, Employee>();
    }

    public void addEmployee(String name, int department, int salary) {
        if (employees.containsKey(name)) {
            System.out.println("Сотрудник " + name + " уже добавлен");
            return;
        }
        if (name == null) {
            System.out.println("Введите имя сотрудника");
            return;
        }
        employees.put(name, new Employee(name, department, salary));

    }

    private void addEmployee(String name, Employee employee) {
        if (employees.containsKey(name)) {
            System.out.println("Сотрудник " + name + " уже добавлен");
            return;
        }
        employees.put(name, employee);
    }

    public void deleteEmployee(String deletingEmployeeName) {
        if (employees.containsKey(deletingEmployeeName)) {
            employees.remove(deletingEmployeeName);
        }
    }

    public void deleteEmployee(int id) {
        for (String name : employees.keySet()) {
            if (employees.get(name).getId() == id) {
                employees.remove(name);
            }
        }
    }


    public int getSalarySummorize() {
        //Суммируем все зарплаты.
        int sumSalary = 0;
        for (String employeeName : employees.keySet()) {
            sumSalary += employees.get(employeeName).getSalary();
        }
        //System.out.println("Суммарная зарплата = " + sumSalary);
        // Не делаю вывод в консоль чтобы при вызове метода из другого не получать лишнюю строку
        return sumSalary;
    }

    public void printAllEmployeesInfo() {
        System.out.println("Список сотрудников");
        for (String employeeName : employees.keySet()) {
            System.out.println(employees.get(employeeName));
        }
    }

    public void printEmployeesNames() {
        System.out.println("Все сотрудники: ");
        for (String employeeName : employees.keySet()) {
            System.out.println(employees.get(employeeName).getName());
        }
    }

    public int getAverageSalary() {
        //Использую метод из пункта про сумму, но приходится не делать вывод чтобы не получать строку про сумму зарплат
        return getSalarySummorize() / employees.size();
    }

    public Employee findMaximalSalary() {
        Employee lucky = null;// временная переменная.
        if (employees == null) {
            System.out.println("Список сотрудников пустой");
            return null;
        } else {
            for (String employeeName : employees.keySet()) {
                if (lucky == null) {
                    lucky = employees.get(employeeName);
                } else if (lucky.getSalary() < employees.get(employeeName).getSalary()) {
                    lucky = employees.get(employeeName);
                }
            }
        }
        System.out.println("Самый счастливый сотрудник - " + lucky.getName());
        return lucky;
    }

    public Employee findMinimalSalary() {
        Employee loser = null;// временная переменная.
        if (employees == null) {
            System.out.println("Список сотрудников пустой");
            return null;
        } else {
            for (String employeeName : employees.keySet()) {
                if (loser == null) {
                    loser = employees.get(employeeName);
                } else if (loser.getSalary() > employees.get(employeeName).getSalary()) {
                    loser = employees.get(employeeName);
                }
            }
        }
        System.out.println("Самый грустный сотрудник - " + loser.getName());
        return loser;
    }

    public void printSalariesLowerThreshold(int upperThreshold) {
        System.out.println("Сотрудники у которых зарплата меньше " + upperThreshold + " рублей:");
        for (String employeeName : employees.keySet()) {
            if (employees.get(employeeName).getSalary() < upperThreshold) {
                System.out.println(employees.get(employeeName));
            }
        }
    }

    public void printSalariesUpperThreshold(int lowerThreshold) {
        System.out.println("Сотрудники у которых зарплата больше " + lowerThreshold + " рублей:");

        for (String employeeName : employees.keySet()) {
            if (employees.get(employeeName).getSalary() > lowerThreshold) {
                System.out.println(employees.get(employeeName));
            }
        }

    }

    public void getDepartmentInfoAndIndexing(int departmentID, int indexingSize) {
        EmployeeBook department = new EmployeeBook();
        for (String employeeName : employees.keySet()) {
            if (employees.get(employeeName).getDepartment() == departmentID) {
                department.addEmployee(employees.get(employeeName).getName(), employees.get(employeeName));
            }
        }
        department.findMinimalSalary();
        department.findMaximalSalary();
        department.getSalarySummorize();
        department.getAverageSalary();
        department.indexingSalaries(indexingSize);
        department.printAllEmployeesInfo();
    }


    public void indexingSalaries(int procentIncrease) {
        for (String employeeName : employees.keySet()) {
            employees.get(employeeName).setSalary(employees.get(employeeName).getSalary() * (100 + procentIncrease) / 100);
        }
    }

    //..
    public void changeSalary(String employeeName, int newSalary) {
        if (employees.containsKey(employeeName)) {
            employees.get(employeeName).setSalary(newSalary);
        }
    }

    public void changeDepartment(String employeeName, int newDepartmentId) {
        if (employees.containsKey(employeeName)) {
            employees.get(employeeName).setDepartment(newDepartmentId);
        }
    }


    public void printEmployeesByDepartments() {
        Map<Integer, List<Employee>> departments = new HashMap<>();
        for (String employeeName : employees.keySet()) {
            int emplDepartment = employees.get(employeeName).getDepartment();
            if (!departments.containsKey(emplDepartment)) {
                departments.put(emplDepartment, new ArrayList<>());
            }
            departments.get(emplDepartment).add(employees.get(employeeName));
        }

    for(Integer department : departments.keySet()){
        System.out.println("Сотрудники отдела " + department + ":");
        for (Employee employee : departments.get(department)){
            System.out.println(employee);
        }
    }
    }
}
*/
