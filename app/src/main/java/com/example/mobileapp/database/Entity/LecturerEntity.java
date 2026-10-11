package com.example.mobileapp.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lecturers")
public class LecturerEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String staffNumber;
    private String subject;
    private String email;

    public LecturerEntity(String name, String staffNumber, String subject, String email) {
        this.name = name;
        this.staffNumber = staffNumber;
        this.subject = subject;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStaffNumber() { return staffNumber; }
    public void setStaffNumber(String staffNumber) { this.staffNumber = staffNumber; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}