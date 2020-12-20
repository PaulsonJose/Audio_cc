
import javax.swing.*;
import java.util.*;

public class App {
    public static void main(String[] arg) {
        Calculator calculator = new Calculator();
        IncreasingDigit increasingDigit = new IncreasingDigit();

        Scanner in = new Scanner(System.in);
        String term = in.next();
        calculator.calculate(term, 600);

        /*String inputVal = in.next();
        increasingDigit.calculate(inputVal);*/

    }

}
