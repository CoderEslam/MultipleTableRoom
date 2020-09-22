package com.example.multipletableroom.Tables;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
(foreignKeys = @ForeignKey(entity = Chapter.class,
        parentColumns = "Chapter_no",
        childColumns = "chapter_no",
        onDelete = ForeignKey.CASCADE),tableName = "Lecture_table")

public class Lecture {
    @PrimaryKey(autoGenerate = true)
    private int id;
   private String chapter_no; //FOREIGN key
   private String Lecture_id;

    public Lecture(String chapter_no, String Lecture_id) {
        this.chapter_no = chapter_no;

       this.Lecture_id = Lecture_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getChapter_no() {
        return chapter_no;
    }

    public String getLecture_id() {
        return Lecture_id;
    }
}
