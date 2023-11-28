package lotto.domain;

import java.util.List;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber validateNonDuplicateAndCreate(Lotto wininngLotto, int bonusNumber){
        List<Integer> numbers = wininngLotto.getNumbers();
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호가 중복될 수 없습니다.");
        }
        return new BonusNumber(bonusNumber);
    }

}
