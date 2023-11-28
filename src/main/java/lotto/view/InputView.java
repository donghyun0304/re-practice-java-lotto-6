package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.RandomNumberGenerator;
import lotto.utils.WinningNumberConverter;

import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public int inputPrice(){
        return getInput(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            // 검증로직 추가
            return Integer.parseInt(input);
        });
    }

    public List<Integer> inputWinningNumbers(){
        return getInput(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            // 검증로직 추가
            return WinningNumberConverter.parse(input);
        });
    }

    private <T> T getInput(Supplier<T> inputSupplier){
        while(true){
            try{
                return inputSupplier.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
