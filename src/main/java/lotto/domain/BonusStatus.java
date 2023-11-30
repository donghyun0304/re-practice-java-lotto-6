package lotto.domain;

import java.util.function.Predicate;

public enum BonusStatus {

    MATCHED(hasBonusNumber -> hasBonusNumber),
    NOT_MATCHED(hasBonusNumber -> hasBonusNumber),
    NOT_REQUIRED(hasBonusNumber -> true);

    private Predicate<Boolean> predicate;

    BonusStatus(Predicate<Boolean> predicate) {
        this.predicate = predicate;
    }

    public boolean matches(boolean hasBonusNumber){
        return predicate.test(hasBonusNumber);
    }
}
