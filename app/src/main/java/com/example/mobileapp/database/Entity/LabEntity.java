package com.example.mobileapp.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "labs")
public class LabEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String subject;
    private String room;
    private int capacity;

    public LabEntity(String title, String subject, String room, int capacity) {
        this.title = title;
        this.subject = subject;
        this.room = room;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}