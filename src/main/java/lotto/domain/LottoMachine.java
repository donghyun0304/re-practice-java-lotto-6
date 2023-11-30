package lotto.domain;

import lotto.utils.RandomNumberGenerator;

import java.util.*;

public class LottoMachine {

    public List<Lotto> createLottos(Price price){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<price.getDividedAmountByUnit(); i++){
            List<Integer> numbers = new ArrayList<>(RandomNumberGenerator.createNumbers());
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Result determineLottoResults(WinningLotto winningLotto, List<Lotto> lottos){
//        List<Rank> ranks = new ArrayList<>();
//        for(Lotto lotto : lottos){
//            ranks.add(winningLotto.determineRank(lotto));
//        }
//        return ranks;

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for(Lotto lotto : lottos){
            Rank rank = winningLotto.determineRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new Result(result);
    }

//    public double determineRateOfReturn(List<Rank> ranks){
//        double sum = ranks.stream()
//                .mapToDouble(Rank::getWinningAmount)
//                .sum();
//
//        double rateOfReturn = sum / (ranks.size() * 1000) * 100;
//        return Math.round(rateOfReturn * 100) / 100.0;
//    }

}
