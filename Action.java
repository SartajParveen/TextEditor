package action;

import java.time.LocalDateTime;

public class Action {
    private int actionId;
    private LocalDateTime localdateTime;
    private int lineNumber;
    private String text;
    private boolean isAddition;

    public Action(int actionId, LocalDateTime localdateTime, boolean isAddition, int lineNumber, String text){
        this.actionId = actionId;
        this.localdateTime = localdateTime;
        this.isAddition = isAddition;
        this.lineNumber = lineNumber;
        this.text = text;
    }

    public void setActionId(int actionId){
        this.actionId = actionId;
    }

    public void setDateTime(LocalDateTime localdateTime){
        this.localdateTime = localdateTime;
    }

    public void setLineNo(int lineno){
        lineNumber = lineno;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setIsAddition(boolean isAddition){
        this.isAddition = isAddition;
    }

    public int getActionId(){
        return this.actionId;
    }

    public LocalDateTime getLocalDateTime(){
        return this.localdateTime;
    }

    public int getLineNumber(){
        return this.lineNumber;
    }

    public String getText(){
        return this.text;
    }

    public boolean getIsAddition(){
        return this.isAddition;
    }
}
