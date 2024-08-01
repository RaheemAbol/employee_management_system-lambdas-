package ems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public static void writeEmployeesToCSV(List<Employee> employees, String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("id,name,hire_date,exit_date,manager");
            bw.newLine();
            for (Employee e : employees) {
                bw.write(String.format("%d,%s,%s,%s,%s",
                        e.id,
                        e.name,
                        e.hireDate,
                        e.exitDate != null ? e.exitDate : "",
                        e.manager));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
