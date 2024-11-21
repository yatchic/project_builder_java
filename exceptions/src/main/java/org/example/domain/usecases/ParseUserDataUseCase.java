package org.example.domain.usecases;




import org.example.domain.exceptions.InvalidDateException;
import org.example.domain.exceptions.InvalidPhoneNumberException;
import org.example.domain.exceptions.InvalidSexException;
import org.example.domain.exceptions.InvalidUserInputException;
import org.example.domain.models.UserData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParseUserDataUseCase {
    public UserData parse(String input) throws InvalidUserInputException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new InvalidUserInputException("Неверное количество данных. Требуется 6 элементов.");
        }

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];


        String birthDate = parts[3];
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Неверный формат даты. Ожидается dd.MM.yyyy.");
        }


        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new InvalidPhoneNumberException("Неверный формат номера телефона. Ожидается целое число.");
        }

        // Проверка пола
        char sex = parts[5].toLowerCase().charAt(0);
        if (sex != 'f' && sex != 'm') {
            throw new InvalidSexException("Неверный формат пола. Ожидается 'f' или 'm'.");
        }

        return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, sex);
    }
}
