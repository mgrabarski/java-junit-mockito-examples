package com.grabarski.mateusz.models;

import com.grabarski.mateusz.models.enums.Note;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {

    private ATM atm;

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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenValueIsBiggerThenATMHave() {
        atm.withdraw(2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTryWithdrawLessThen10() {
        atm.withdraw(5);
    }
}