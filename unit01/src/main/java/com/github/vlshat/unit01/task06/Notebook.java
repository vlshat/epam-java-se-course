package com.github.vlshat.unit01.task06;

import java.util.Arrays;

/**
 * Created by wladislaw on 26.02.17.
 */
public class Notebook {

    private Note[] notes;
    private int pointer = 0;

    public Notebook(int capacity){
        notes = new Note[capacity];
    }

    /**
     * @param note
     */
    public void add(Note note){
        if (pointer + 1 < notes.length){
            notes[pointer++] = note;
        } else {
            throw new IllegalArgumentException("Notebook is filled");
        }
    }

    /**
     *
     * @param noteNumber - Expects number of note in notebook
     */
    public void delete(int noteNumber){

        if (noteNumber - 1 != pointer){
            notes[noteNumber - 1] = null;
            for (int i = noteNumber; i <= pointer; i++){
                notes[i - 1] = notes[i];
            }
        } else {
            notes[noteNumber - 1] = null;
        }

        pointer -= 1;
    }

    /**
     * @param noteNumber
     * @param text to insert in certain note
     */
    public void edit(int noteNumber, String text){
        notes[noteNumber - 1].setText(text);
    }

    public Note getNote(int noteNumber){
        return notes[noteNumber - 1];
    }

    public int getNotesCount(){
        return pointer;
    }


    /**
     * @return all notes as a string
     */
    public String showAll(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pointer; i++){
            builder.append("Note ")
                    .append(i + 1)
                    .append(":")
                    .append(notes[i].getText())
                    .append("\n");
        }

        return builder.toString();
    }


}
