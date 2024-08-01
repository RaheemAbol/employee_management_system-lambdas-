package ems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeOperations {

    public static long countEmployeesByManager(List<Employee> employees, String managerName) {
        return employees.stream()
                .filter(e -> managerName.equals(e.manager))
                .count();
    }


    public static List<String> getEmployeeNames(List<Employee> employees) {
        return employees.stream()
//                .map(e -> e.name) // this is doing the same thing
                .map(Employee::getName)
                .collect(Collectors.toList());
    }


    public static List<Employee> sortEmployeesByHireDate(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getHireDate))
                .collect(Collectors.toList());
    }

    public static Map<String, List<Employee>> groupEmployeesByManager(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.manager));
    }

    public static long getTotalYearsWorked(List<Employee> employees) {
        return employees.stream()
                .mapToLong(e -> ChronoUnit.YEARS.between(e.hireDate, e.exitDate != null ? e.exitDate : LocalDate.now()))
                .sum();
    }


    public static Employee getLongestWorkingEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingLong(e -> ChronoUnit.DAYS.between(e.hireDate, e.exitDate != null ? e.exitDate : LocalDate.now())))
                .orElse(null);
    }


    public static boolean allEmployeesHaveSameManager(List<Employee> employees, String managerName) {
        return employees.stream()
                .allMatch(e -> managerName.equals(e.manager));
    }

    public static List<Employee> getFirstThreeEmployeesByHireDate(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(e -> e.hireDate))
                .limit(3)
                .collect(Collectors.toList());
    }


    public static DoubleSummaryStatistics getEmployeeWorkStatistics(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(e -> ChronoUnit.YEARS.between(e.hireDate, e.exitDate != null ? e.exitDate : LocalDate.now()))
                .summaryStatistics();
    }
}
