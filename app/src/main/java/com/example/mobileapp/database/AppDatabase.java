package com.example.mobileapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mobileapp.database.dao.LabDao;
import com.example.mobileapp.database.dao.LecturerDao;
import com.example.mobileapp.database.dao.StudentDao;
import com.example.mobileapp.database.entity.LabEntity;
import com.example.mobileapp.database.entity.LecturerEntity;
import com.example.mobileapp.database.entity.StudentEntity;

@Database(entities = {StudentEntity.class, LecturerEntity.class, LabEntity.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract StudentDao studentDao();
    public abstract LecturerDao lecturerDao();
    public abstract LabDao labDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "studex_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}