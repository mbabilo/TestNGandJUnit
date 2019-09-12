package com.mbabilo.tests;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class simpleTests extends TestBase {


    @Test(groups = "positive", priority = 2)
    public void test1() throws IOException {
        String relativePath = "TMP\\file1.txt";
        System.out.println("positive1");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test(groups = "positive", priority = 2)
    public void test2() throws IOException {
        String relativePath = "TMP\\file2.bat";
        System.out.println("positive2");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test(groups = "positive", priority = 2)
    public void test3() throws IOException {
        String relativePath = "TMP\\file3";
        System.out.println("positive3");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test(groups = "negative", priority = 1)
    public void test4() {
        String relativePath = "TMP0\\file1.txt";
        System.out.println("negative1");
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        assertFalse(flag, "Folder TMP0 is not exists in the project root directory");
    }

    @Test(groups = "negative", priority = 1)
    public void test0() {
        String relativePath = "TMP1\\file1.txt";
        System.out.println("negative2");
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        assertFalse(flag, "Folder TMP1 is not exists in the project root directory");
    }
}
