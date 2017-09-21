public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] digits = input.split(",");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Integer.valueOf(digits[i]);
        }
        return sum;
    }
}
