package org.example.homework;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addEmployee(111L, 1L, "Сергей", 12);
        employeeDirectory.addEmployee(222L, 12L, "Толик", 13);
        employeeDirectory.addEmployee(333L, 123L, "Вова", 14);
        employeeDirectory.addEmployee(555L, 1234L, "Вова", 14);
        employeeDirectory.addEmployee(666L, 12345L, "Света", 14);

          //employeeDirectory.searchEmployeesByJobNumber(111L);//по табельному номеру

          //employeeDirectory.searchEmployeesByPhoneNumber(1L);//по номеру телефона

          //employeeDirectory.searchEmployeesByName("Вова");//по имени

         //employeeDirectory.searchEmployeesByWorkingExperience(14);//по стажу работы
    }
}