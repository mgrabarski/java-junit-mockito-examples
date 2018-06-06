package com.grabarski.mateusz.models;

import com.grabarski.mateusz.models.enums.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class ATMWithdrawParameterizedTest {

    private ATM atm;

    private int checkingValue;
    private List<Note> expectedNotes;

    public ATMWithdrawParameterizedTest(int checkingValue, List<Note> expectedNotes) {
        this.checkingValue = checkingValue;
        this.expectedNotes = expectedNotes;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100, Arrays.asList(Note._100)},
                {200, Arrays.asList(Note._200)},
                {300, Arrays.asList(Note._200, Note._100)},
                {250, Arrays.asList(Note._200, Note._50)},
                {500, Arrays.asList(Note._200, Note._200, Note._100)},
                {1100, Arrays.asList(Note._200, Note._200, Note._200, Note._200, Note._200, Note._100)},
                {20, Arrays.asList(Note._20)},
                {10, Arrays.asList(Note._10)},
        });
    }

    @Before
    public void setUp() throws Exception {
        atm = new ATM(); // 1900

        atm.addNote(Note._200);
        atm.addNote(Note._200);
        atm.addNote(Note._200);
        atm.addNote(Note._200);
        atm.addNote(Note._200);

        atm.addNote(Note._100);
        atm.addNote(Note._100);
        atm.addNote(Note._100);
        atm.addNote(Note._100);
        atm.addNote(Note._100);

        atm.addNote(Note._50);
        atm.addNote(Note._50);
        atm.addNote(Note._50);
        atm.addNote(Note._50);
        atm.addNote(Note._50);

        atm.addNote(Note._20);
        atm.addNote(Note._20);
        atm.addNote(Note._20);
        atm.addNote(Note._20);
        atm.addNote(Note._20);

        atm.addNote(Note._10);
        atm.addNote(Note._10);
        atm.addNote(Note._10);
        atm.addNote(Note._10);
        atm.addNote(Note._10);
    }

    @Test
    public void shouldSuccessWithdrawFromATM() {
        List<Note> notes = atm.withdraw(checkingValue);

        assertTrue("Expected 'a' and 'expected' to be equal." +
                        "\n  'a'        = " + notes +
                        "\n  'expected' = " + expectedNotes,
                expectedNotes.equals(notes));
    }
}
