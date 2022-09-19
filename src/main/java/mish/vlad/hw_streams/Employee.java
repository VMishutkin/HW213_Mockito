package mish.vlad.hw_streams;

import java.util.Objects;

public class Employee {
    private String firstname;
    private String lastname;
    private int salary;
    private int department;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Employee(String firstname, String lastname, int salary, int department) {
        this.firstname = InputDataService.validateName(firstname);
        this.lastname = InputDataService.validateSurname(lastname);
        this.salary = salary;
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj==null || getClass()!= obj.getClass()) {
            return false;
        } else if (this == obj) {
            return true;
        }

        Employee anotherEmployee = (Employee) obj;
        return this.firstname.equals(anotherEmployee.firstname) && this.lastname.equals(anotherEmployee.lastname);
    }

    @Override
    public String toString() {
        return getLastname() + " " + getFirstname();

    }
}
