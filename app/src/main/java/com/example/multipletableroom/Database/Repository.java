package com.example.multipletableroom.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.multipletableroom.Tables.Chapter;
import com.example.multipletableroom.Tables.Lecture;

import java.util.List;

public class Repository {
    HikaiDAO hikaiDAO;
    LiveData<List<Chapter>> alldetails;

    public Repository(Application application){
        HiakiDatabase database= HiakiDatabase.getInstance(application);
        hikaiDAO =database.chapterDAO();
        alldetails= hikaiDAO.getAllNotes();
    }

    public void insertChapter(Chapter chapter){
        new InsertChapterAsyncTask(hikaiDAO).execute(chapter);
    }


    public void insertLecture(Lecture lecture){
        new InsertLectureAsyncTask(hikaiDAO).execute(lecture);
    }

//    public void insertAll(Chapter chapter,Lecture lecture){
//
//
//    }

    private static class InsertLectureAsyncTask extends AsyncTask<Lecture,Void,Void> {

        private HikaiDAO hikaiDAO;

        private InsertLectureAsyncTask (HikaiDAO hikaiDAO){
            this.hikaiDAO = hikaiDAO;
        }

        @Override
        protected Void doInBackground(Lecture... lectures) {
            hikaiDAO.insertLecture(lectures[0]);
            return null;
        }
    }

        private static class InsertChapterAsyncTask extends AsyncTask<Chapter,Void,Void> {

            private HikaiDAO hikaiDAO;

            private InsertChapterAsyncTask (HikaiDAO hikaiDAO){
                this.hikaiDAO = hikaiDAO;
            }

            @Override
            protected Void doInBackground(Chapter... chapters) {
                hikaiDAO.insertChapter(chapters[0]);

                return null;
            }
    }



}
