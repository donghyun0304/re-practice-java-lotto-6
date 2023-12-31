package lotto.validation;

import lotto.domain.ErrorMessage;
import lotto.domain.RegexPattern;

import java.util.List;

public class InputValidator {

    // 숫자로만 이루어져있는지 검증
    public static void validateOnlyNumber(String input){
        if(!RegexPattern.ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_ALL_NUMERIC);
        }
    }

    //
    public static void validateOnlyNumbers(List<String> input){
        boolean hasOnlyNumbers = input.stream()
                .allMatch(str -> RegexPattern.ONLY_NUMBER.matches(str));
        if(!hasOnlyNumbers){
            throw new IllegalArgumentException(ErrorMessage.NOT_ALL_NUMERIC);
        }
    }
    
    // 0보다 큰 숫자인지 검증
    public static void validateOverZeroNumber(String input){
        if(Integer.parseInt(input) <= 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_OVER_ZERO);
        }
    }
    
    //컴마가 들어있는지 검증
    public static void validateIncludeComma(String input){
        if(RegexPattern.NOT_INCLUDE_COMMA.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INCLUDE_COMMA);
        }
    }
    
    
    

}
