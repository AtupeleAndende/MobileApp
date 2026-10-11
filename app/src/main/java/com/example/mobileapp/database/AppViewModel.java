package com.example.mobileapp.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mobileapp.database.entity.LabEntity;
import com.example.mobileapp.database.entity.LecturerEntity;
import com.example.mobileapp.database.entity.StudentEntity;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private final AppRepository repository;
    private final LiveData<List<StudentEntity>> allStudents;
    private final LiveData<List<LecturerEntity>> allLecturers;
    private final LiveData<List<LabEntity>> allLabs;

    public AppViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
        allStudents = repository.getAllStudents();
        allLecturers = repository.getAllLecturers();
        allLabs = repository.getAllLabs();
    }

    // Student operations
    public LiveData<List<StudentEntity>> getAllStudents() { return allStudents; }
    public void insertStudent(StudentEntity student) { repository.insertStudent(student); }
    public void updateStudent(StudentEntity student) { repository.updateStudent(student); }
    public void deleteStudent(StudentEntity student) { repository.deleteStudent(student); }

    // Lecturer operations
    public LiveData<List<LecturerEntity>> getAllLecturers() { return allLecturers; }
    public void insertLecturer(LecturerEntity lecturer) { repository.insertLecturer(lecturer); }
    public void updateLecturer(LecturerEntity lecturer) { repository.updateLecturer(lecturer); }
    public void deleteLecturer(LecturerEntity lecturer) { repository.deleteLecturer(lecturer); }

    // Lab operations
    public LiveData<List<LabEntity>> getAllLabs() { return allLabs; }
    public void insertLab(LabEntity lab) { repository.insertLab(lab); }
    public void updateLab(LabEntity lab) { repository.updateLab(lab); }
    public void deleteLab(LabEntity lab) { repository.deleteLab(lab); }
}