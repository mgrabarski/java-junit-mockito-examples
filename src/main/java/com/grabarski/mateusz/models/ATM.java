package com.grabarski.mateusz.models;

import com.grabarski.mateusz.models.enums.Note;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<Note> notes;

    public ATM() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> withdraw(int value) {

        canWithdraw(value);

        List<Note> listToWithdraw = new ArrayList<>();

        while (value > 0) {
            if (value >= Note._200.getValue()) {
                value = getNoteFromATM(value, listToWithdraw, Note._200);
            } else if (value >= Note._100.getValue()) {
                value = getNoteFromATM(value, listToWithdraw, Note._100);
            } else if (value >= Note._50.getValue()) {
                value = getNoteFromATM(value, listToWithdraw, Note._50);
            } else if (value >= Note._20.getValue()) {
                value = getNoteFromATM(value, listToWithdraw, Note._20);
            } else if (value >= Note._10.getValue()) {
                value = getNoteFromATM(value, listToWithdraw, Note._10);
            }
        }

        return listToWithdraw;
    }

    private int getNoteFromATM(int value, List<Note> listToWithdraw, Note note) {
        listToWithdraw.add(note);
        value -= note.getValue();
        notes.remove(note);
        return value;
    }

    private void canWithdraw(int value) {
        int atmSum = getSATMSummary();

        if (value > atmSum) {
            throw new IllegalArgumentException("In ATM is less notes.");
        }

        if (value < 10) {
            throw new IllegalArgumentException("Value can not be lee then 10.");
        }
    }

    private int getSATMSummary() {
        return notes.stream()
                .mapToInt(value -> value.getValue())
                .sum();
    }
}
