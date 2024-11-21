package org.example.presentation;





import org.example.domain.exceptions.InvalidUserInputException;
import org.example.domain.models.UserData;
import org.example.domain.usecases.ParseUserDataUseCase;
import org.example.domain.usecases.SaveUserDataUseCase;

import java.io.IOException;
import java.util.Scanner;
//Пример правильного ввода
// Иванов Иван Иванович 12.03.1990 89211234567 m
//Ввод должен состоять из шести слов
//дата_рождения - строка формата dd.mm.yyyy
//номер_телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m
//Почему-то недавно стали вместо русских символов кракозябы
//Последний раз помогла переустановка винды может у вас нормально будет
public class ConsoleApp {
    public static void main(String[] args) {



        ParseUserDataUseCase parseUseCase = new ParseUserDataUseCase();
        SaveUserDataUseCase saveUseCase = new SaveUserDataUseCase();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter data (Last Name First Name Middle Name Date of Birth Phone Number Gender):");
        String input = scanner.nextLine();

        try {
            UserData userData = parseUseCase.parse(input);
            saveUseCase.save(userData);
            System.out.println("Dates saved");
        } catch (InvalidUserInputException e) {
            System.err.println("Error in dates: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error write to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

