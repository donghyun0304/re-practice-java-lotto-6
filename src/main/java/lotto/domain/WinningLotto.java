package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(Lotto winningLotto, int bonusNumber){
        return new WinningLotto(winningLotto,
                BonusNumber.validateNonDuplicateAndCreate(winningLotto, bonusNumber));
    }




}
