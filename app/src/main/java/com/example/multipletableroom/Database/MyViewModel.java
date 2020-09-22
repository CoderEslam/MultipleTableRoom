package com.example.multipletableroom.Database;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.multipletableroom.MainActivity;
import com.example.multipletableroom.Tables.Chapter;
import com.example.multipletableroom.Tables.Lecture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyViewModel extends AndroidViewModel implements ViewModelStoreOwner {
    private Repository repository;
//    private LiveData<List>
//

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
    }

    public void getVolleyDetails(){
        Toast.makeText(getApplication(), "GET VOLLEY REACHED", Toast.LENGTH_LONG).show();
        //Creating A Request Queue
        RequestQueue requestQueue;
        // Instantiate a request queue
        requestQueue = Volley.newRequestQueue(getApplication());
        //Creating an JSonArray ReQuest
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://rkmshillong.online/public/BEG.cache", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        //Request Object of Volley Created
                        JSONObject obj = response.getJSONObject(i);
                        String chapno=obj.getString("chapterNo");
                        String title=obj.getString("title");
                        int items=obj.getInt("items");
                        Chapter details =new Chapter(chapno,title,items);
                        insertChapter(details);
                        //Log.d("INSERT CHAPTER", details.toString());
                        JSONArray lecture_ar = obj.getJSONArray("lecture");
                        for(int j=0;j<lecture_ar.length();j++)
                        {
                            JSONObject lecture_obj = lecture_ar.getJSONObject(j);

                            if(lecture_obj.getString("content").equals("video"))
                            {
                                String lecture_id = lecture_obj.getString("lectureId");
                                Lecture lecture1 = new Lecture(chapno,lecture_id);
                                Toast.makeText(getApplication(), lecture1.getLecture_id(),Toast.LENGTH_LONG).show();
                                Log.i("GO",lecture_obj.getString("lectureId"));
                                insertLecture(lecture1);
                            }
                        }

                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Something went wrong");
            }
        });
        //Request added to the Request Queue
        requestQueue.add(jsonArrayRequest);
    }

    //inserting into chapter
    public void insertChapter(final Chapter chapter){
        Toast.makeText(getApplication(), "INSERT CHAPTER REACHED", Toast.LENGTH_LONG).show();
        repository.insertChapter(chapter);
        Log.d("INSERT CHAPTER", chapter.getChapter_no());
    }

    //Inserting into Lecture
    public void insertLecture( Lecture lecture){
        Toast.makeText(getApplication(), "INSERT LECTURE REACHED", Toast.LENGTH_LONG).show();
        repository.insertLecture(lecture);
        Log.d("INSERT LECTURE", lecture.getChapter_no());

    }


        public void getDetailVolley(){


        }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return null;
    }

}
