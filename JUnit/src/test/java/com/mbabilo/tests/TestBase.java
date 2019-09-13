package com.mbabilo.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class TestBase {


    @BeforeClass
    public static void setUp() {
        System.out.println("setUp");
        File folder = new File("JUnitFolder");
        System.out.println("folderName is: " + folder);
        boolean flag = folder.mkdir();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        System.out.println("tearDown");
        deleteDirectory(new File("JUnitFolder"));
    }
}
