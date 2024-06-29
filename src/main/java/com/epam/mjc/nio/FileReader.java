package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            reader.close();

            StringBuilder sb = new StringBuilder();
            List<String> strings = Files.readAllLines(file.toPath());

            for (String string : strings) {
                sb.append(string).append("\n");
            }

            sb.setLength(sb.length() - 1);
            return ProfileParser.parse(sb.toString());
        } catch (IOException e) {
            Logger.getLogger("FileReader").log(Level.SEVERE, "Error reading file", e);
        }

        return null;
    }
}
