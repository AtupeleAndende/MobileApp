package com.example.mobileapp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobileapp.database.entity.LecturerEntity;

import java.util.List;

@Dao
public interface LecturerDao {

    @Insert
    void insert(LecturerEntity lecturer);

    @Update
    void update(LecturerEntity lecturer);

    @Delete
    void delete(LecturerEntity lecturer);

    @Query("SELECT * FROM lecturers ORDER BY name ASC")
    List<LecturerEntity> getAllLecturers();

    @Query("SELECT * FROM lecturers ORDER BY name ASC")
    LiveData<List<LecturerEntity>> getAllLecturersLiveData();

    @Query("SELECT * FROM lecturers WHERE id = :id LIMIT 1")
    LecturerEntity getLecturerById(int id);

    @Query("DELETE FROM lecturers")
    void deleteAll();
}