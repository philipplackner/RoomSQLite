package com.androiddevs.roomsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        final EditText etUrl = findViewById(R.id.etUrl);
        Button btnOpenUrl = findViewById(R.id.btnOpenUrl);
        ImageView ivAddBookmark = findViewById(R.id.ivAddBookmark);

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(etUrl.getText().toString());
            }
        });

        ivAddBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncUpsertTask(new Bookmark("MyBookmark", etUrl.getText().toString())).execute();
                Toast.makeText(MainActivity.this,
                        "Successfully added new bookmark", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, BookmarkActivity.class));
            }
        });
    }

    class AsyncUpsertTask extends AsyncTask<Void, Void, Void> {

        private Bookmark bookmark;

        public AsyncUpsertTask(Bookmark bookmark) {
            this.bookmark = bookmark;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            BookmarkDatabase.getInstance(MainActivity.this).bookmarkDao().upsert(bookmark);

            return null;
        }
    }
}
