package com.example.mobileapp.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String number;
    private String group;
    private String programme;

    public StudentEntity(String name, String number, String group, String programme) {
        this.name = name;
        this.number = number;
        this.group = group;
        this.programme = programme;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getProgramme() { return programme; }
    public void setProgramme(String programme) { this.programme = programme; }
}