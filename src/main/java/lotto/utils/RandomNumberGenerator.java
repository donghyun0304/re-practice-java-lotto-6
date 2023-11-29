package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private RandomNumberGenerator() {
    }

    public static List<Integer> createNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
        validateNumberRange(numbers);
        return numbers;
    }

    private static void validateNumberRange(final List<Integer> numbers){
        boolean isValidNumber = numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
        if(!isValidNumber){
            throw new IllegalArgumentException("[ERROR] 정해진 범위의 숫자가 아닙니다.");
        }
    }

}
