package com.github.vlshat.unit01.task06;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 26.02.17.
 */
public class NotebookTest {

    @Test
    public void add(){
        Notebook notebook = new Notebook(5);
        notebook.add(new Note("blahblah"));
        assertTrue(notebook.getNotesCount() == 1);
    }

    @Test
    public void delete(){
        Notebook notebook = new Notebook(5);
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        notebook.delete(2);
        assertTrue(notebook.getNotesCount() == 2);
    }

    @Test
    public void edit(){
        Notebook notebook = new Notebook(5);
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        notebook.edit(2, "edited blahblah");
        assertEquals(notebook.getNote(2).getText(), "edited blahblah");
    }

    @Test
    public void view(){
        Notebook notebook = new Notebook(5);
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        notebook.add(new Note("blahblah"));
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= notebook.getNotesCount(); i++){
            builder.append("Note ")
                    .append(i)
                    .append(":")
                    .append(notebook.getNote(i).getText())
                    .append("\n");
        }

        System.out.println(notebook.showAll());
        assertEquals(builder.toString(), notebook.showAll());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBigNotebook(){
        Notebook notebook = new Notebook(10);
        for (int i = 0; i < 100; i++){
            notebook.add(new Note("1"));
        }
    }

}