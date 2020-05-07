package com.mbabilo.tests;


import com.mbabilo.fixtures.FixtureRules;
import com.mbabilo.fixtures.UniversalDataProviders;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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

import static com.mbabilo.tests.DataSource.Type.FILE;
import static com.mbabilo.tests.DataSource.Type.RESOURCE;
import static java.lang.StrictMath.random;

import com.mbabilo.tests.DataSource.Type.*;

@RunWith(DataProviderRunner.class)
public class DataProviderTests extends FixtureRules {

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
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value = "/user.data", type = RESOURCE)
    public void test1(String user, String password) {
        System.out.println(user + ":" + password);
    }


    @Test
    //@UseDataProvider("loadNameFromFile")
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value = "/user.data", type = FILE)
    public void test3(Object name) throws IOException {
        System.out.println(name);
        //Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }



    ////old way  tests
    @Test
    @UseDataProvider("name")
    public void testDP1(Object name) throws IOException {
        String relativePath = "JUnitFolder\\" + String.valueOf(name);
        System.out.println("positive1");
        File file = new File(relativePath);
        //assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
        Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }

    @Test
    @UseDataProvider("loadNameFromFile")
    public void testDP2(Object name) throws IOException {
        String relativePath = "JUnitFolder\\" + name;
        System.out.println("positive2");
        File file = new File(relativePath);
        //assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
        Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }


}
