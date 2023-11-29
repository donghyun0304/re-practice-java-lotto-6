package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.LottosDto;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        LottoMachine lottoMachine = new LottoMachine();
        int price = inputView.inputPrice();
//        System.out.println("price = " + price);
        List<Integer> numbers = RandomNumberGenerator.createNumbers();
        System.out.println(numbers);
        List<Lotto> lottos = lottoMachine.createLottos(price);
//        for(Lotto lotto : lottos){
//            System.out.println(lotto);
//        }
        LottosDto lottosDto = new LottosDto(lottos);
        outputView.printLottos(lottosDto);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
//        System.out.println(winningNumbers);

        int bonusNumber = inputView.inputBonusNumber();
//        System.out.println(bonusNumber);

        WinningLotto winningLottoWithBonusNumber = WinningLotto.from(winningLotto, bonusNumber);
        System.out.println(winningLottoWithBonusNumber);

        List<Rank> ranks = lottoMachine.determineLottoResults(winningLottoWithBonusNumber, lottos);

        for(Rank rank : ranks){
            System.out.println(rank.getMatchedNumber());
        }

        Map<Rank, Integer> result = new HashMap<>();
        for(Rank rank : ranks){
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        outputView.printLottoResult(result);

        double rateOfReturn = lottoMachine.determineRateOfReturn(ranks);
        outputView.printRateOfReturn(rateOfReturn);

    }
}
