package lotto.domain;

public class Price {

    private static final int UNIT = 1000;
    private final int amount;

    public Price(final int amount) {
        validateMultipleOfUnit(amount);
        this.amount = amount;
    }

    private void validateMultipleOfUnit(final int amount){
        if((amount % UNIT) != 0){
            throw new IllegalArgumentException("[ERROR] 1000 단위가 아닙니다.");
        }
    }

    public int getDividedAmountByUnit(){
        return amount / UNIT;
    }
}
