package com.androiddevs.roomsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {

    List<Bookmark> bookmarks;

    public BookmarkAdapter(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item, parent, false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        holder.tvBookmarkName.setText(bookmarks.get(position).getName());
        holder.tvBookmarkUrl.setText(bookmarks.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public class BookmarkViewHolder extends RecyclerView.ViewHolder {

        TextView tvBookmarkName;
        TextView tvBookmarkUrl;

        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBookmarkName = itemView.findViewById(R.id.tvBookmarkName);
            tvBookmarkUrl = itemView.findViewById(R.id.tvBookmarkUrl);
        }
    }
}
