public class StringCalculator {

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
        return sum;
    }
}
