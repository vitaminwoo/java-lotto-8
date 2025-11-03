package lotto.util;

public class InputConverter {

    public static int convertInput(String input) {
        int numberInput;
        try {
            numberInput = Integer.parseInt(input);
            validate(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다");
        }
        return numberInput;
    }

    private static void validate(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수 값을 입력해야 합니다");
        }
    }
}
