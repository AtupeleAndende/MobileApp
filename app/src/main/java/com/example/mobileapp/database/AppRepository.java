package com.example.mobileapp.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mobileapp.database.dao.LabDao;
import com.example.mobileapp.database.dao.LecturerDao;
import com.example.mobileapp.database.dao.StudentDao;
import com.example.mobileapp.database.entity.LabEntity;
import com.example.mobileapp.database.entity.LecturerEntity;
import com.example.mobileapp.database.entity.StudentEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppRepository {

    private final StudentDao studentDao;
    private final LecturerDao lecturerDao;
    private final LabDao labDao;

    private final LiveData<List<StudentEntity>> allStudents;
    private final LiveData<List<LecturerEntity>> allLecturers;
    private final LiveData<List<LabEntity>> allLabs;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public AppRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        studentDao = db.studentDao();
        lecturerDao = db.lecturerDao();
        labDao = db.labDao();

        allStudents = studentDao.getAllStudentsLiveData();
        allLecturers = lecturerDao.getAllLecturersLiveData();
        allLabs = labDao.getAllLabsLiveData();
    }

    // Students
    public LiveData<List<StudentEntity>> getAllStudents() { return allStudents; }

    public void insertStudent(StudentEntity student) {
        executor.execute(() -> studentDao.insert(student));
    }

    public void updateStudent(StudentEntity student) {
        executor.execute(() -> studentDao.update(student));
    }

    public void deleteStudent(StudentEntity student) {
        executor.execute(() -> studentDao.delete(student));
    }

    // Lecturers
    public LiveData<List<LecturerEntity>> getAllLecturers() { return allLecturers; }

    public void insertLecturer(LecturerEntity lecturer) {
        executor.execute(() -> lecturerDao.insert(lecturer));
    }

    public void updateLecturer(LecturerEntity lecturer) {
        executor.execute(() -> lecturerDao.update(lecturer));
    }

    public void deleteLecturer(LecturerEntity lecturer) {
        executor.execute(() -> lecturerDao.delete(lecturer));
    }

    // Labs
    public LiveData<List<LabEntity>> getAllLabs() { return allLabs; }

    public void insertLab(LabEntity lab) {
        executor.execute(() -> labDao.insert(lab));
    }

    public void updateLab(LabEntity lab) {
        executor.execute(() -> labDao.update(lab));
    }

    public void deleteLab(LabEntity lab) {
        executor.execute(() -> labDao.delete(lab));
    }
}