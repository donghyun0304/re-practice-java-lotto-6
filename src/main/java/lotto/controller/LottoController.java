package lotto.controller;

import lotto.domain.*;
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
        Price price = inputView.inputPrice();
        List<Lotto> lottos = lottoMachine.createLottos(price);
        LottosDto lottosDto = new LottosDto(lottos);
        outputView.printLottos(lottosDto);

        Lotto winningNumbers = inputView.inputWinningNumbers();
        WinningLotto winningLotto = getWinningLottoWhenGetValidBonus(winningNumbers);
        Result result = lottoMachine.determineLottoResults(winningLotto, lottos);

        outputView.printLottoResult(result);
        outputView.printRateOfReturn(result.calcRateOfReturn());
    }

    private WinningLotto getWinningLottoWhenGetValidBonus(Lotto winningNumbers){
        try{
            int bonusNumber = inputView.inputBonusNumber();
            return WinningLotto.from(winningNumbers, bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또번호와 중복된 번호가 존재합니다.");
            return getWinningLottoWhenGetValidBonus(winningNumbers);
        }
    }
}
