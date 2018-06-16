package model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Quiz implements IModel {

    private int ID;
    private String content;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private String answer;
    private Date dateCreated;
    private User creator;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toJSON() {
        return "{\"id\":"+ ID + ",\"content\":\""+content+"\",\"optA\":\""+optA+"\",\"optB\":\""+optB
                +"\",\"optC\":\""+optC+"\",\"optD\":\""+optD+"\",\"key\":\""+answer+"\"}";
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
