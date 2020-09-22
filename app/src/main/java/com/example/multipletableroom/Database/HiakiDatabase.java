package com.example.multipletableroom.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.multipletableroom.Tables.Chapter;
import com.example.multipletableroom.Tables.Lecture;
@Database(entities = {Chapter.class, Lecture.class},version = 1)
public abstract class HiakiDatabase extends RoomDatabase {
    public static HiakiDatabase instance;
    public  abstract HikaiDAO chapterDAO();

    public static synchronized HiakiDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HiakiDatabase.class, "Detail").fallbackToDestructiveMigration().build();

        }
        return instance;
    }

}
