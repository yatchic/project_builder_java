package org.example.homework;

public class Employee {
    private Long jobNumber;
    private Long phoneNumber;
    private String name;
    private Integer workingExperience;

    public Employee(Long jobNumber, Long phoneNumber, String name, Integer workingExperience) {
        this.jobNumber = jobNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workingExperience = workingExperience;
    }

    public Long getJobNumber() { return jobNumber; }
    public Long getPhoneNumber() { return phoneNumber; }
    public String getName() { return name; }
    public Integer getWorkingExperience() { return workingExperience; }



    public String toString() {
        return "Employee{" +
                "jobNumber=" + jobNumber +
                ", phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", workingExperience=" + workingExperience +
                '}';
    }

}

