import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void itReturnsZeroWhenTheStringIsEmpty() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void itReturnsTheNumberIfTheStringIsOnlyANumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void itReturnsTwoNumbersSummedIfTheyAreSeperatedByAComma() {
        assertEquals(2, StringCalculator.add("1,1"));
    }
}
