package com.example.mobileapp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobileapp.database.entity.LabEntity;

import java.util.List;

@Dao
public interface LabDao {

    @Insert
    void insert(LabEntity lab);

    @Update
    void update(LabEntity lab);

    @Delete
    void delete(LabEntity lab);

    @Query("SELECT * FROM labs ORDER BY title ASC")
    List<LabEntity> getAllLabs();

    @Query("SELECT * FROM labs ORDER BY title ASC")
    LiveData<List<LabEntity>> getAllLabsLiveData();

    @Query("SELECT * FROM labs WHERE id = :id LIMIT 1")
    LabEntity getLabById(int id);

    @Query("DELETE FROM labs")
    void deleteAll();
}