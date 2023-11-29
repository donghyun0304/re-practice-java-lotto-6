package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;

public class Lotto{

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateNonDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberRange(final List<Integer> numbers){
        boolean isValidNumber = numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
        if(!isValidNumber){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBER_RANGE);
        }
    }

    private static void validateNonDuplicate(final List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != NUMBER_SIZE){
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchingNumbers(final Lotto lotto){
//        int count = 0;
//        for(Integer number : this.numbers){
//            for(Integer parameterNumber : lotto.numbers){
//                if(number == parameterNumber){
//                    count++;
//                }
//            }
//        }
//        return count;
//
        Set<Integer> thisNumbers = new HashSet<>(this.numbers);
        Set<Integer> otherNumbers = new HashSet<>(lotto.numbers);

        thisNumbers.retainAll(otherNumbers); // 교집합을 구함
        return thisNumbers.size();
    }

    public boolean hasMatchedBonusNumbers(final BonusNumber bonusNumber){
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

//    @Override
//    public int compareTo(Lotto o) {
//        int count = 0;
//        for(Integer number : this.numbers){
//            for(Integer parameterNumber : o.numbers){
//                if(number == parameterNumber){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // TODO: 추가 기능 구현
}
