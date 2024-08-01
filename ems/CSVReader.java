package ems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Employee> readEmployeesFromCSV(String file) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                LocalDate hireDate = LocalDate.parse(values[2]);
                LocalDate exitDate = values[3].isEmpty() ? null : LocalDate.parse(values[3]);
                String manager = values[4];
                employees.add(new Employee(id, name, hireDate, exitDate, manager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
