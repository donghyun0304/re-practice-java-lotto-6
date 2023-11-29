package lotto.domain;

import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> createLottos(int price){
        // price 가격검증 로직 추가
        int amount = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<amount; i++){
            List<Integer> numbers = RandomNumberGenerator.createNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Rank> determineLottoResults(WinningLotto winningLotto, List<Lotto> lottos){
        List<Rank> ranks = new ArrayList<>();
        for(Lotto lotto : lottos){
            ranks.add(winningLotto.determineRank(lotto));
        }
        return ranks;
    }

    public double determineRateOfReturn(List<Rank> ranks){
        double sum = ranks.stream()
                .mapToDouble(Rank::getWinningAmount)
                .sum();

        double rateOfReturn = sum / (ranks.size() * 1000) * 100;
        return Math.round(rateOfReturn * 100) / 100.0;
    }





}
