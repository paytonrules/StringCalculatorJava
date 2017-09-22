import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StringCalculatorTest {
    StringCalculator calc;
    ILogger logger;
    IWebService errorService;

    @Before
    public void setUp() {
        logger = mock(ILogger.class);
        errorService = mock(IWebService.class);
        calc = new StringCalculator(logger, errorService);
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

    @Test
    public void itLogsTheResultOfTheAddFunctionThroughTheLogger() {
        calc.add("1");
        verify(logger).write("1");
    }

    @Test
    public void whenTheLoggerThrowsAnExceptionNotifyIWebService() {
        doThrow(new RuntimeException()).when(logger).write("1");

        calc.add("1");

        verify(errorService).notify("Error Logging Message");
    }
}
