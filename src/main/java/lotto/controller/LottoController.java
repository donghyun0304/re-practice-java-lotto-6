package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.dto.LottosDto;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
//        System.out.println(winningNumbers);

        int bonusNumber = inputView.inputBonusNumber();
//        System.out.println(bonusNumber);


    }
}
