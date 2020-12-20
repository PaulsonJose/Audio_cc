import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition(){
        Calculator calculator = new Calculator();
        String input = "34+54-((54+1)+(1+1))";

        int output = calculator.calculate(input,30);

        assertEquals(output,31);


    }

    @Test
    public void testMultiplication(){
        Calculator calculator = new Calculator();
        String input = "34*10-((54+1)+(1+1))";

        int output = calculator.calculate(input,40);

        assertEquals(output,283);


    }

}