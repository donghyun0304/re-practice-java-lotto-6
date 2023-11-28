package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottosDto;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottos(LottosDto lottosDto){
        List<Lotto> lottos = lottosDto.getLottos();
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            String result = numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        }
    }

    private void printFrontSquare(){
        System.out.println();
    }
}
