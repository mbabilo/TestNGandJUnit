package com.mbabilo.tests;


import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.random;
import static org.testng.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class DataProviderTests extends TestBase {

    @DataProvider
    public static Object[] name () {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Object[]{String.valueOf(random())});
        }
        return data.toArray(new Object[]{});
    }

    @DataProvider
    public static Object[] loadNameFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviderTests.class.getResourceAsStream("/names.data")));

        List<Object[]> userData = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split("\n"));
            line = in.readLine();
        }

        in.close();

        return userData.toArray(new Object[]{});
    }

    @Test
    @UseDataProvider("name")
    public void testDP1(Object name) throws IOException {
        String relativePath = "JUnitFolder\\" + String.valueOf(name);
        System.out.println("positive1");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test
    @UseDataProvider("loadNameFromFile")
    public void testDP2(Object name) throws IOException {
        String relativePath = "JUnitFolder\\" + name;
        System.out.println("positive2");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

}
