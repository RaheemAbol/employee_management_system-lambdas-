package ems;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        List<Employee> employees = CSVReader.readEmployeesFromCSV(inputFile);



        // returning the count of employees
        long count = EmployeeOperations.countEmployeesByManager(employees, "Bob Brown");
//        System.out.println("Number of employees under Bob Brown: " + count);


        //Mapping to a diff type
        List<String> employeeNames = EmployeeOperations.getEmployeeNames(employees);
//        System.out.println("Employee Names: " + employeeNames);


        // example for sorting
        List<Employee> sortedByHireDate = EmployeeOperations.sortEmployeesByHireDate(employees);
//        System.out.println("Employees sorted by hire date:");
//        sortedByHireDate.forEach(System.out::println);



        // Grouping example
        Map<String, List<Employee>> employeesByManager = EmployeeOperations.groupEmployeesByManager(employees);
//        employeesByManager.forEach((manager, empList) -> {
//            System.out.println("Manager: " + manager);
//            empList.forEach(System.out::println);
//        });



        //reducing example
        long totalYearsWorked = EmployeeOperations.getTotalYearsWorked(employees);
//        System.out.println("Total years worked by all employees: " + totalYearsWorked);


        // min/max example
        Employee longestWorkingEmployee = EmployeeOperations.getLongestWorkingEmployee(employees);
//        System.out.println("Employee who has worked the longest: " + longestWorkingEmployee);


        //checking conditions
        boolean allSameManager = EmployeeOperations.allEmployeesHaveSameManager(employees, "Jane Smith");
//        System.out.println("All employees have the same manager: " + allSameManager);


        //Limiting example
        List<Employee> firstThreeEmployees = EmployeeOperations.getFirstThreeEmployeesByHireDate(employees);
//        System.out.println("First 3 employees based on hire date:");
//        firstThreeEmployees.forEach(System.out::println);

        //creating summery
        DoubleSummaryStatistics stats = EmployeeOperations.getEmployeeWorkStatistics(employees);
        System.out.println("Number of employees: " + stats.getCount());
        System.out.println("Average years worked: " + stats.getAverage());


        CSVWriter.writeEmployeesToCSV(EmployeeOperations.sortEmployeesByHireDate(employees), "sorted_employees.csv");
        CSVWriter.writeEmployeesToCSV(EmployeeOperations.getFirstThreeEmployeesByHireDate(employees), "first_three_employees.csv");
    }
}
