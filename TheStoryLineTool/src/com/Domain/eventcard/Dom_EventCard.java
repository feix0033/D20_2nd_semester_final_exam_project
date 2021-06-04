package com.Domain.eventcard;


import java.time.LocalDateTime;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu, Ibraheem Swaidan
 * @ create 2021-05-26-20.31
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description This is the EASV D20 2nd semester final exam project
 * @ Supervisors Karsten Skov, Tommy Haugaard, Frank Østergaard Hansen
 * @ Version 0.1
 */
public class Dom_EventCard  {
    private int eventCardID;
    private String eventName;
    private String authorName;

    private LocalDateTime editDate = LocalDateTime.now();
    private Dom_Event dom_event = new Dom_Event(this.eventCardID);
    private Dom_Note dom_note = new Dom_Note(this.eventCardID);
    private Dom_Comment dom_comment = new Dom_Comment(this.eventCardID);

    public Dom_EventCard() {
    }

    public Dom_EventCard(int eventCardID, String eventName, String authorName, LocalDateTime editDate) {
        this.eventCardID = eventCardID;
        this.eventName = eventName;
        this.authorName = authorName;
        this.editDate = editDate;
    }

    public int getEventCardID() {
        return eventCardID;
    }

    public void setEventCardID(int eventCardID) {
        this.eventCardID = eventCardID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    public Dom_Event getDom_event() {
        return dom_event;
    }

    public void setDom_event(Dom_Event dom_event) {
        this.dom_event = dom_event;
    }

    public Dom_Note getDom_note() {
        return dom_note;
    }

    public void setDom_note(Dom_Note dom_note) {
        this.dom_note = dom_note;
    }

    public Dom_Comment getDom_comment() {
        return dom_comment;
    }

    public void setDom_comment(Dom_Comment dom_comment) {
        this.dom_comment = dom_comment;
    }

    @Override
    public String toString() {
        return "Dom_EventCard{" +
                "eventID=" + eventCardID +
                ", eventName='" + eventName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", editDate=" + editDate +
                ", dom_event=" + dom_event +
                ", dom_note=" + dom_note +
                ", dom_comment=" + dom_comment +
                '}';
    }
}
