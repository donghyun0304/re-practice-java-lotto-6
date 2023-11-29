package lotto.validation;

import lotto.domain.ErrorMessage;
import lotto.domain.RegexPattern;

public class InputValidator {

    public static void validateOnlyNumbers(String input){
        if(!RegexPattern.ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_ALL_NUMERIC);
        }
    }

}
