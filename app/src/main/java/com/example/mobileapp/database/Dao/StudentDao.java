package com.example.mobileapp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobileapp.database.entity.StudentEntity;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(StudentEntity student);

    @Update
    void update(StudentEntity student);

    @Delete
    void delete(StudentEntity student);

    @Query("SELECT * FROM students ORDER BY name ASC")
    List<StudentEntity> getAllStudents();

    @Query("SELECT * FROM students ORDER BY name ASC")
    LiveData<List<StudentEntity>> getAllStudentsLiveData();

    @Query("SELECT * FROM students WHERE id = :studentId LIMIT 1")
    StudentEntity getStudentById(int studentId);

    @Query("DELETE FROM students")
    void deleteAll();
}