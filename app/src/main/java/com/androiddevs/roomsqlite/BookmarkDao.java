package com.androiddevs.roomsqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(Bookmark bookmark);

    @Delete
    void delete(Bookmark bookmark);

    // in a real app you would use the MVVM pattern, so this function
    // would return a LiveData that automatically updates our RecyclerView
    // however, this would take too long for this tutorial
    @Query("SELECT * FROM bookmarks")
    List<Bookmark> getAllBookmarks();
}
