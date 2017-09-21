import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    StringCalculator calc;

    @Before
    public void setUp() {
        calc = new StringCalculator();
    }

    @Test
    public void itReturnsZeroWhenTheStringIsEmpty() {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void itReturnsTheNumberIfTheStringIsOnlyANumber() {
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void itReturnsTwoNumbersSummedIfTheyAreSeperatedByAComma() {
        assertEquals(2, calc.add("1,1"));
    }
}
