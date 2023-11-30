package lotto.domain;

import java.util.*;

public class Result {

    private final Map<Rank, Integer> result;

    public Result(Map<Rank, Integer> result) {
        this.result = new EnumMap<>(result);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public double calcRateOfReturn(){
        Set<Map.Entry<Rank, Integer>> entries = result.entrySet();
        double sumOfWinningAmount = entries.stream()
                .mapToDouble(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
        double rateOfReturn = sumOfWinningAmount / (result.size() * 1000) * 100;
        return Math.round(rateOfReturn * 100) / 100.0;
    }
}
