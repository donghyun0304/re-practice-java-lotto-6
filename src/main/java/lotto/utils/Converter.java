package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public List<Integer> parseToIntListByDelimiter(final String str, final String delimiter){
        return Arrays.stream(str.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
