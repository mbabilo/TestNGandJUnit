package mbabilo.tests;

import mbabilo.base.TestBase;
import org.testng.annotations.Test;
import java.io.File;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class negativeTests extends TestBase {

    @Test
    public void test4() {
        String relativePath = "TMP0\\file1.txt";
        System.out.println(relativePath);
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        assertFalse(flag, "Folder TMP0 is not exists in the project root directory");
    }

    @Test
    public void test5() {
        String relativePath = "TMP1\\file1.txt";
        System.out.println(relativePath);
        File file = new File(relativePath);
        boolean flag=file.mkdir();
        assertFalse(flag, "Folder TMP1 is not exists in the project root directory");
    }
}
