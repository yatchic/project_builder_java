package org.example.homework;


import java.util.HashMap;

import java.util.Map;

public class EmployeeDirectory {
    private Map<Long, Employee> phonebook = new HashMap<>();


    private void reassignEmployeeIds() {
        Map<Long, Employee> newPhonebook = new HashMap<>();
        long id = 1;

        for (Employee employee : phonebook.values()) {
            newPhonebook.put(id++, employee);
        }

        phonebook = newPhonebook;
    }


    public void searchEmployeesByJobNumber(Long jobNumber) {
        for (Map.Entry<Long, Employee> entry : phonebook.entrySet()) {
            if (entry.getValue().getJobNumber().equals(jobNumber)) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


    public void searchEmployeesByPhoneNumber(Long phoneNumber) {
        for (Map.Entry<Long, Employee> entry : phonebook.entrySet()) {
            if (entry.getValue().getPhoneNumber().equals(phoneNumber)) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


    public void searchEmployeesByName(String name) {
        for (Map.Entry<Long, Employee> entry : phonebook.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


    public void searchEmployeesByWorkingExperience(Integer workingExperience) {
        for (Map.Entry<Long, Employee> entry : phonebook.entrySet()) {
            if (entry.getValue().getWorkingExperience().equals(workingExperience)) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


    public void addEmployee(Long jobNumber, Long phoneNumber, String name, Integer workingExperience) {
        long id = phonebook.size() + 1;
        Employee newEmployee = new Employee(jobNumber, phoneNumber, name, workingExperience);
        phonebook.put(id, newEmployee);

        reassignEmployeeIds();
    }


    public void removeEmployee(Long id) {
        phonebook.remove(id);
        reassignEmployeeIds();
    }


    public void removeAllEmployees() {
        phonebook.clear();
        reassignEmployeeIds();
    }

    public void printAllEmployees() {
        for (Map.Entry<Long, Employee> entry : phonebook.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}