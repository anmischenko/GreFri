package com.example.grefri;

import java.sql.Timestamp;

public class Note {
    String content;
    Timestamp timestamp; // class from firebase

    public Note() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
