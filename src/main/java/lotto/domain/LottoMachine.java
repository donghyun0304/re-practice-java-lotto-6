package lotto.domain;

import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> createLottos(int price){
        // price 가격검증 로직 추가
        int amount = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<amount; i++){
            List<Integer> numbers = RandomNumberGenerator.createNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
