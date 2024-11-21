package org.example.domain.usecases;





import org.example.domain.models.UserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveUserDataUseCase {
    public void save(UserData userData) throws IOException {
        String fileName = userData.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData.toFormattedString());
            writer.newLine();
        }
    }
}

