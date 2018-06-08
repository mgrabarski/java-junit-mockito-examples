package com.grabarski.mateusz;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 07.06.2018.
 */
public class MathUtils {
    public static int eval(String evalText) {
        return makeCalculations(evalText);
    }

    private static int makeCalculations(String evalText) {

        if (evalText.contains("+")) {
            return addNumbers(splitStringByChar(evalText, "\\+"));
        } else if (evalText.contains("-")) {
            return subtractionNumbers(splitStringByChar(evalText, "\\-"));
        } else if (evalText.contains("*")) {
            return multiplicationNumbers(splitStringByChar(evalText, "\\*"));
        } else if (evalText.contains("/")) {
            return divisionNumbers(splitStringByChar(evalText, "/"));
        } else if (evalText.contains("%")) {
            return moduloNumbers(splitStringByChar(evalText, "%"));
        }

        try {
            return Integer.parseInt(evalText);
        } catch (Exception e) {
            throw e;
        }
    }

    private static List<String> splitStringByChar(String evalText, String splitChar) {
        return Arrays.asList(evalText.split(splitChar));
    }

    private static int addNumbers(List<String> numbers) {
        return numbers.stream()
                .mapToInt(value -> Integer.parseInt(value))
                .sum();
    }

    private static int subtractionNumbers(List<String> numbers) {
        int sum = Integer.parseInt(numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            sum -= Integer.parseInt(numbers.get(i));
        }
//.reduce(0, (d, v) -> d - v);
        return sum;
    }

    private static int multiplicationNumbers(List<String> numbers) {
        return Integer.parseInt(numbers.get(0)) * Integer.parseInt(numbers.get(1));
    }

    private static int divisionNumbers(List<String> numbers) {
        return Integer.parseInt(numbers.get(0)) / Integer.parseInt(numbers.get(1));
    }

    private static int moduloNumbers(List<String> numbers) {
        return Integer.parseInt(numbers.get(0)) % Integer.parseInt(numbers.get(1));
    }
}