package com.mbabilo.tests;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.StrictMath.random;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> name() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Object[]{String.valueOf(random())});
        }
        return data.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadNameFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/names.data")));

        List<Object[]> data = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            data.add(line.split("\n"));
            line = in.readLine();
        }
        in.close();
        return data.iterator();
    }
}
