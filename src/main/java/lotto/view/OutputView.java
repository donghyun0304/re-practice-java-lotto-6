package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottosDto;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottos(LottosDto lottosDto) {
        List<Lotto> lottos = lottosDto.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            String result = numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        }
    }

    public void printLottoResult(Map<Rank, Integer> result) {
        printRankResult(Rank.FIFTH_PLACE, result.getOrDefault(Rank.FIFTH_PLACE, 0));
        printRankResult(Rank.FOURTH_PLACE, result.getOrDefault(Rank.FOURTH_PLACE, 0));
        printThirdPlaceResult(Rank.THIRD_PLACE, result.getOrDefault(Rank.THIRD_PLACE, 0));
        printRankResult(Rank.SECOND_PLACE, result.getOrDefault(Rank.SECOND_PLACE, 0));
        printRankResult(Rank.FIRST_PLACE, result.getOrDefault(Rank.FIRST_PLACE, 0));
    }

    private void printRankResult(Rank rank, int winningSize) {
        String winningAmount = String.format("%,d", rank.getWinningAmount());
        System.out.println(rank.getMatchedNumber() + "개 일치 (" + winningAmount + "원) - " + winningSize + "개");
    }

    private void printThirdPlaceResult(Rank rank, int winningSize) {
        String winningAmount = String.format("%,d", rank.getWinningAmount());
        System.out.println(rank.getMatchedNumber() + "개 일치, 보너스 볼 일치 (" + winningAmount + "원) - " + winningSize + "개");
    }

    public void printRateOfReturn(double rateOfReturn){
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
