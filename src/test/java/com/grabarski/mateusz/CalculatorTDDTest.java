package com.grabarski.mateusz;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz Grabarski on 07.06.2018.
 */
public class CalculatorTDDTest {

    public static final int MAX_NUMBER = 10;

    private Random random;

    @Before
    public void setUp() throws Exception {
        random = new Random();
    }

    @Test
    public void shouldReturnValueItself_forIntegerParameter() {
        int randomNumber = random.nextInt(MAX_NUMBER);
        String evalText = String.valueOf(randomNumber);

        int addingResult = MathUtils.eval(evalText);

        assertEquals(evalText, randomNumber, addingResult);
    }

    @Test
    public void shouldReturnSum_forAdditionParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);

        int addingResult = MathUtils.eval(String.valueOf(randomNumber1 + "+" + randomNumber2));

        assertEquals(randomNumber1 + randomNumber2, addingResult);
    }

    @Test
    public void shouldReturnDifference_forSubtractionParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);

        int addingResult =
                MathUtils.eval(String.valueOf(randomNumber1 + "-" + randomNumber2));

        assertEquals(randomNumber1 - randomNumber2, addingResult);
    }

    @Test
    public void shouldReturnProduct_forMultiplicationParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);

        int addingResult =
                MathUtils.eval(String.valueOf(randomNumber1 + "*" + randomNumber2));

        assertEquals(randomNumber1 * randomNumber2, addingResult);
    }

    @Test
    public void shouldReturnQuotient_forDivisionParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER) + 1;

        int addingResult =
                MathUtils.eval(String.valueOf(randomNumber1 + "/" + randomNumber2));

        assertEquals(randomNumber1 / randomNumber2, addingResult);
    }

    @Test
    public void shouldReturnResult_forModuloParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER) + 1;
        int randomNumber2 = random.nextInt(MAX_NUMBER) + 1;

        int addingResult = MathUtils.eval(String.valueOf(randomNumber1 + "%" + randomNumber2));

        assertEquals(randomNumber1 % randomNumber2, addingResult);
    }

    @Test
    public void shouldReturnResult_forMultipleAdditionParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);
        int randomNumber3 = random.nextInt(MAX_NUMBER);

        int addingResult =
                MathUtils.eval(String.valueOf(randomNumber1 + "+" + randomNumber2 + "+" + randomNumber3));

        assertEquals(randomNumber1 + randomNumber2 + randomNumber3, addingResult);
    }

    @Test
    public void shouldReturnResult_forMultipleSubtractionParameter() {
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);
        int randomNumber3 = random.nextInt(MAX_NUMBER);

        String evalText = String.valueOf(randomNumber1 + "-" + randomNumber2 + "-" + randomNumber3);

        int addingResult =
                MathUtils.eval(evalText);

        assertEquals(evalText, randomNumber1 - randomNumber2 - randomNumber3, addingResult);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowParseException_forInvalidParameters() {
        MathUtils.eval("abc");
    }

}