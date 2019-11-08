package com.androiddevs.roomsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity {

    RecyclerView rvBookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        rvBookmarks = findViewById(R.id.rvBookmarks);
        rvBookmarks.setLayoutManager(new LinearLayoutManager(this));

        new LoadAllBookmarksAsyncTask().execute();
    }

    class LoadAllBookmarksAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            List<Bookmark> bookmarks = BookmarkDatabase.getInstance(BookmarkActivity.this).bookmarkDao().getAllBookmarks();
            final BookmarkAdapter adapter = new BookmarkAdapter(bookmarks);
            rvBookmarks.post(new Runnable() {
                @Override
                public void run() {
                    rvBookmarks.setAdapter(adapter);
                }
            });
            return null;
        }
    }
}
