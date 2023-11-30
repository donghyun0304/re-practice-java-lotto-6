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

    public void run() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = purchaseLottos(lottoMachine);

        WinningLotto winningLotto = getWinningLotto();
        displayResults(lottoMachine, lottos, winningLotto);
    }

    private List<Lotto> purchaseLottos(LottoMachine lottoMachine) {
        Price price = inputView.inputPrice();
        List<Lotto> lottos = lottoMachine.createLottos(price);
        LottosDto lottosDto = new LottosDto(lottos);
        outputView.printLottos(lottosDto);
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumbers = inputView.inputWinningNumbers();
        return getWinningLottoWhenGetValidBonus(winningNumbers);
    }

    private void displayResults(LottoMachine lottoMachine, List<Lotto> lottos, WinningLotto winningLotto) {
        Result result = lottoMachine.determineLottoResults(winningLotto, lottos);
        outputView.printLottoResult(result);
        outputView.printRateOfReturn(result.calcRateOfReturn());
    }

    private WinningLotto getWinningLottoWhenGetValidBonus(Lotto winningNumbers){
        try {
            int bonusNumber = inputView.inputBonusNumber();
            return WinningLotto.from(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또번호와 중복된 번호가 존재합니다.");
            return getWinningLottoWhenGetValidBonus(winningNumbers);
        }
    }
}
