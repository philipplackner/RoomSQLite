package com.androiddevs.roomsqlite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Bookmark.class, version = 1)
public abstract class BookmarkDatabase extends RoomDatabase {

    private static BookmarkDatabase instance;

    public abstract BookmarkDao bookmarkDao();

    public static synchronized BookmarkDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BookmarkDatabase.class, "bookmark_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
