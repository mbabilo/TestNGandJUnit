package mbabilo;

import org.testng.annotations.Test;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tests {

    @Test
    public void testAssertThatListHasItems() {
        assertThat(
                Arrays.asList("A", "B", "C"),
                hasItems("A", "B"));
    }
}
