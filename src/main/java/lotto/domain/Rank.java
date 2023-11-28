package lotto.domain;

import static lotto.domain.BonusStatus.*;

public enum Rank {

    FIRST_PLACE(6, NOT_REQUIRED, 2_000_000_000),
    SECOND_PLACE(5, MATCHED, 30_000_000),
    THIRD_PLACE(5, NOT_MATCHED, 1_500_000),
    FOURTH_PLACE(4, NOT_REQUIRED, 50_000),
    FIFTH_PLACE(3, NOT_REQUIRED, 5_000),
    NOTHING(0, NOT_REQUIRED, 0);

    private int matchedNumber;
    private BonusStatus bonusStatus;
    private int winningAmount;

    Rank(int matchedNumber, BonusStatus bonusStatus, int winningAmount) {
        this.matchedNumber = matchedNumber;
        this.bonusStatus = bonusStatus;
        this.winningAmount = winningAmount;
    }


}
