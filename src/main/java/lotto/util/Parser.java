package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String SPLIT_DELIMITER = ",";

    public static List<String> splitInput(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

}
