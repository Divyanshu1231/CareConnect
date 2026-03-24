package com.example.careconnect.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.careconnect.R;
import com.example.careconnect.model.Article;
import com.example.careconnect.ui.activity.Articles.HealthArticleActivity;
import com.example.careconnect.ui.activity.Articles.HealthArticleDetailsActivity;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.VH> {

    List<Article> list;
    Context context;

    public ArticleAdapter(List<Article> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class VH extends RecyclerView.ViewHolder {

        TextView title, desc;
        ImageView image, bookmark;

        public VH(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            image = itemView.findViewById(R.id.image);
            bookmark = itemView.findViewById(R.id.bookmark);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_article, parent, false);

        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {

        Article a = list.get(position);

        h.title.setText(a.title);
        h.desc.setText(a.description);
        Glide.with(context).load(a.urlToImage).into(h.image);

        //Glide.with(context).load(a.description).into(h.image);

        // 🔥 OPEN DETAILS
        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, HealthArticleDetailsActivity.class);
            i.putExtra("title", a.title);
            i.putExtra("desc", a.description);
            i.putExtra("image", a.urlToImage);
            context.startActivity(i);
        });

        // ⭐ BOOKMARK
        h.bookmark.setOnClickListener(v ->
                Toast.makeText(context, "Saved ⭐", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}