package lotto.utils;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberConverter {

    private static final String NUMBERS_DELIMITER = ",";

    public static Lotto parse(final String numbers) {
        String trimmedNumbers = numbers.trim();
        List<Integer> lottoNumbers = Arrays.stream(trimmedNumbers.split(NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
