package org.example.domain.models;



public class UserData {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String birthDate;
    private final long phoneNumber;
    private final char sex;

    public UserData(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public String toFormattedString() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, middleName, birthDate, phoneNumber, sex);
    }
}

