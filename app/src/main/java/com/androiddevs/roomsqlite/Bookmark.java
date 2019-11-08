package com.androiddevs.roomsqlite;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookmarks")
public class Bookmark {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "bookmark_name")
    private String name;

    @ColumnInfo(name = "bookmark_url")
    private String url;

    public Bookmark(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
