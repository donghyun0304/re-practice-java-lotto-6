package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberConverter {

    private static final String NUMBERS_DELIMITER = ",";

    public static List<Integer> parse(final String numbers) {
        String trimmedNumbers = numbers.trim();
        return Arrays.stream(trimmedNumbers.split(NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
