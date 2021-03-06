package com.mbabilo.tests;

import com.mbabilo.categoryInterface.MyCategories;
import com.mbabilo.fixtures.FixtureRules;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;



public class SimpleTests extends FixtureRules {


    @Test
    @Category(MyCategories.PositiveTests.class)
    public void test1() throws IOException {
        String relativePath = "JUnitFolder\\file1.txt";
        System.out.println("positive1");
        File file = new File(relativePath);
        //assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
        Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }

    @Test
    @Category(MyCategories.PositiveTests.class)
    public void test2() throws IOException {
        String relativePath = "JUnitFolder\\file2.bat";
        System.out.println("positive2");
        File file = new File(relativePath);
        //assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
        Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }

    @Test
    @Category(MyCategories.PositiveTests.class)
    public void test3() throws IOException {
        String relativePath = "JUnitFolder\\file3";
        System.out.println("positive3");
        File file = new File(relativePath);
        //assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
        Assert.assertThat(file.createNewFile(), CoreMatchers.equalTo(true));
    }

    @Test
    @Category(MyCategories.NegativeTests.class)
    public void test4() {
        String relativePath = "TMP1\\file1.txt";
        System.out.println("negative1");
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        //assertFalse(flag, "Folder TMP0 is not exists in the project root directory");
        Assert.assertThat(flag, CoreMatchers.equalTo(false));
    }

    @Test
    @Category(MyCategories.NegativeTests.class)
    public void test0() {
        String relativePath = "TMP1\\file1.txt";
        System.out.println("negative2");
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        //assertFalse(flag, "Folder TMP1 is not exists in the project root directory");
        Assert.assertThat(flag, CoreMatchers.equalTo(false));
    }
}
