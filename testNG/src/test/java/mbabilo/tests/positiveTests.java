package mbabilo.tests;

import mbabilo.base.TestBase;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class positiveTests extends TestBase {

    @Test
    public void test1() throws IOException {
        String relativePath = "TMP\\file1.txt";
        System.out.println(relativePath);
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test
    public void test2() throws IOException {
        String relativePath = "TMP\\file2.bat";
        System.out.println(relativePath);
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test
    public void test3() throws IOException {
        String relativePath = "TMP\\file3";
        System.out.println(relativePath);
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

}
