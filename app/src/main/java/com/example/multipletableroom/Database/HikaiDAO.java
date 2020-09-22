package com.example.multipletableroom.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.multipletableroom.Tables.Chapter;
import com.example.multipletableroom.Tables.Lecture;

import java.util.List;

@Dao
public abstract class HikaiDAO {

    @Insert
    public  abstract void insertChapter (Chapter chapter);

    @Insert
    public  abstract void insertLecture(Lecture lecture);

//    @Transaction
//   public void insertAll(Chapter chapter,Lecture lecture){
//        insertChapter(chapter);
//        insertLecture(lecture);
//
//    }

    @Query("Select * from Chapter_table c,Lecture_table t where c.Chapter_no=t.chapter_no ")
    abstract LiveData<List<Chapter>> getAllNotes();

}
