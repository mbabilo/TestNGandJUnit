package com.mbabilo.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class TestBase {

    @BeforeMethod
    void beforeMethod(Method m) {
        TempDir tempDir = m.getAnnotation(TempDir.class);
        if (tempDir != null) {
            System.out.println("set " + tempDir.read());
            System.out.println("set " + tempDir.write());
        }
    }


    @BeforeSuite(alwaysRun = true)
    @Parameters("folderName")
    File setUp(String folderName) {
        System.out.println("setUp");
        File folder = new File(folderName);
        System.out.println("folderName is: " + folder);
        boolean flag = folder.mkdir();
        return folder;

    }

    @AfterSuite(alwaysRun = true)
    @Parameters("folderName")
    void tearDown(String folderName) throws IOException {
        System.out.println("tearDown");
        deleteDirectory(new File(folderName));

    }
}
