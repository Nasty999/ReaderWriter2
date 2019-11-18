package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    private BufferedReader br;

    public Reader(String file) throws FileNotFoundException{
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    }

    public String getAllText() throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            result.append(line);
        }
        br.close();
        return result.toString();
    }


}
