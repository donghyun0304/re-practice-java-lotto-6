package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Delimiter;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.utils.Converter;
import lotto.utils.RandomNumberGenerator;
import lotto.utils.RetryUtil;
import lotto.utils.WinningNumberConverter;
import lotto.validation.InputValidator;

import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public Price inputPrice(){
        return RetryUtil.getInput(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            InputValidator.validateOnlyNumber(input);
            InputValidator.validateOverZeroNumber(input);
            return new Price(Integer.parseInt(input));
        });

    }

    public Lotto inputWinningNumbers(){
        return RetryUtil.getInput(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            InputValidator.validateIncludeComma(input);
            InputValidator.validateOnlyNumbers(
                    Converter.parseToStringListByDelimiter(input, Delimiter.COMMA));
            return WinningNumberConverter.parse(input);
        });
    }

    public int inputBonusNumber(){
        return RetryUtil.getInput(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            InputValidator.validateOnlyNumber(input);
            return Integer.parseInt(input);
        });
    }


}
