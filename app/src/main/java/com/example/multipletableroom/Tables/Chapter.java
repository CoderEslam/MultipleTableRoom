package com.example.multipletableroom.Tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Chapter_table",indices={@Index(value="Chapter_no", unique=true)})
public class Chapter {


        @PrimaryKey(autoGenerate = true)
        private int id;


        private String Chapter_no;
        private String title;
        private int items;

        //Constructor

        public Chapter(String Chapter_no, String title, int items) {
            this.Chapter_no = Chapter_no;
            this.title = title;
            this.items = items;
        }

        //Setter for id


        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getChapter_no() {
            return Chapter_no;
        }

        public String getTitle() {
            return title;
        }

        public int getItems() {
            return items;
        }
}
