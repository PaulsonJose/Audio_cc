import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncreasingDigitTest {
    @Test
    public void testIncreasing() {
        IncreasingDigit increasingDigit = new IncreasingDigit();
        String input = "33245";
        String output = increasingDigit.calculate(input);

        assertEquals(output,"29999");
    }
}
