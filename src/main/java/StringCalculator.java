public class StringCalculator {
    private final IWebService errorService;
    private ILogger logger;

    public StringCalculator(ILogger logger, IWebService errorService) {
        this.errorService = errorService;
        this.logger = logger;
    }

    private boolean isInt(String digit) {
        try {
            Integer.valueOf(digit);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int add(String input) {
        String[] digits = input.split(",");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            if (isInt(digits[i]))
                sum += Integer.valueOf(digits[i]);
        }
        logSum(sum);

        return sum;
    }

    private void logSum(int sum) {
        try {
            logger.write(String.format("%d", sum));
        } catch(Exception e) {
            errorService.notify("Error Logging Message");
        }
    }
}
