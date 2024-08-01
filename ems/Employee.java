package ems;

import java.time.LocalDate;

public class Employee {

    int id;
    String name;
    LocalDate hireDate;
    LocalDate exitDate;
    String manager;

    public Employee(int id, String name, LocalDate hireDate, LocalDate exitDate, String manager) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.exitDate = exitDate;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', hireDate=%s, exitDate=%s, manager='%s'}",
                id, name, hireDate, exitDate, manager);
    }
}
