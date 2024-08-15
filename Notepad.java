
package notepad;

import action.Action;

import java.time.LocalDateTime;
import java.util.*;

public class Notepad {
    private int id = 1;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBoard;
    private int capacity;

    public Notepad(int capacity){
        this.capacity = capacity;
        notepad = new String[capacity];

        for(int i=0; i<capacity; i++){
            notepad[i] = "";
        }

        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipBoard = new LinkedList<>();
        
    }

    public void display() {
        for(int i=0; i<notepad.length; i++){
            System.out.println(notepad[i]);
        }
    }

    public void display(int startingLine, int endingLine) {
        if(startingLine <= 0 || startingLine > endingLine || endingLine > this.capacity) {
            System.out.println("Unable to display text, please check the input");
            return;
        }

        for(int i=startingLine-1; i<endingLine; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void insertLine(int lineNumber, String text) {
        if(lineNumber > this.capacity) {
            System.out.println("Notepad limit crossed");
            return;
        }

        notepad[lineNumber-1] = text;
        undoAction.push(new Action(id++, LocalDateTime.now(), true, lineNumber, text));
        //display();
    }

    public void insertLine(int lineNumber, String[] text){
        if((lineNumber + text.length) > capacity){
            System.out.println("No that many rows to insert");
            return;
        }

        for(int i=0; i<text.length; i++){
            insertLine(lineNumber, text[i]);
            lineNumber += 1;
        }
    }

    public void delete(int lineNumber) {
        if(lineNumber > capacity) {
            System.out.println("No such row to delete");
            return;
        }

        if(notepad[lineNumber-1].isEmpty()){
            System.out.println("Nothing to delete");
            return;
        }

        redoAction.push(new Action(id++, LocalDateTime.now(), false, lineNumber, notepad[lineNumber-1]));
        notepad[lineNumber-1] = "";
        //display();
    }

    public void delete(int startingLine, int endingLine) {
        if(startingLine > endingLine || endingLine > capacity) {
            System.out.println("Unable to delete, please check the input");
            return;
        }

        for(int i=startingLine; i<=endingLine; i++) {
            delete(i);
        }
    }

    public void copy(int startingLine, int endingLine){
        if(startingLine > endingLine || endingLine > capacity){
            System.out.println("Unable to copy");
            return;
        }

        String copyText="";
        for(int i=startingLine-1; i<endingLine; i++){
            copyText += (notepad[i]+"\n");
        }

        if(!copyText.isEmpty()) clipBoard.add(copyText);
    }

    public void paste(int lineNumber) {
        if(clipBoard.isEmpty()){
            System.out.println("Nothing to paste");
            return;
        }

        String text = clipBoard.peek();
        insertLine(lineNumber, text);
    }

    public void undo(){
        if(this.undoAction.isEmpty()){
            System.out.println("Nothing to undo");
            return;
        }

        Action action = this.undoAction.peek();
        this.undoAction.pop();

        delete(action.getLineNumber());
    }

    public void redo(){
        if(this.redoAction.isEmpty()){
            System.out.println("Nothing to redo");
            return;
        }

        Action action = this.redoAction.peek();
        this.redoAction.pop();

        insertLine(action.getLineNumber(), action.getText());
    }
}
