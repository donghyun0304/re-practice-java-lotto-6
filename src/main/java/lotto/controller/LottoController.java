package lotto.controller;

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
        int price = inputView.inputPrice();
//        System.out.println("price = " + price);
        List<Integer> numbers = RandomNumberGenerator.createNumbers();
        System.out.println(numbers);
    }
}
