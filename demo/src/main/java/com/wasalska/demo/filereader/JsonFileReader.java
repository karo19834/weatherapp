package com.wasalska.demo.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {
    public String readFile(String path) {
        File file = new File(path);
        String json = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                json += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
