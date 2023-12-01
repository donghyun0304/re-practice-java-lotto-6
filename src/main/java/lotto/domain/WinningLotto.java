package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final Lotto winningLotto, final int bonusNumber){
        return new WinningLotto(
                winningLotto,
                BonusNumber.validateNonDuplicateAndCreate(winningLotto, bonusNumber)
        );
    }

    public Rank determineRank(final Lotto lotto){
        int matchedCount = winningLotto.countMatchingNumbers(lotto);
        boolean hasBonusNumber = lotto.hasMatchedBonusNumber(bonusNumber);
        return Rank.find(matchedCount, hasBonusNumber);
    }


    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningLotto=" + winningLotto +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
