package mbabilo.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class TestBase {

    @BeforeSuite
    File setUp() {
        System.out.println("setUp");
        File folder = new File("TMP");
        System.out.println(folder);
        boolean flag = folder.mkdir();
        return folder;

    }

    @AfterSuite
    void tearDown() throws IOException {
        System.out.println("tearDown");
        deleteDirectory(new File("TMP"));

    }
}
