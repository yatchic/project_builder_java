package org.example.data.repositories;
import org.example.domain.models.UserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataRepository {
    public void saveToFile(UserData userData) throws IOException {
        String fileName = userData.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData.toFormattedString());
            writer.newLine();
        }
    }
}

