package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

//    public boolean hasMatchedBonusNumbers(BonusNumber bonusNumber){
//        return numbers.contains(bonusNumber);
//    }

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
