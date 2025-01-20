package com.example.paperly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterRvNews extends RecyclerView.Adapter<AdapterRvNews.ArticleViewHolder> {

    private ArrayList<Article> articleList;
    private Context context;

    public AdapterRvNews(ArrayList<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @Override
    public AdapterRvNews.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        holder.tvTime.setText(article.getTime());
        holder.tvAuthor.setText(article.getAuthor());

        Glide.with(context)
                .load(article.getThumbnail())
                .into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvAuthor, tvTime;
        ImageView ivThumbnail;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvAuthor = itemView.findViewById(R.id.tv_item_author);
            tvTime = itemView.findViewById(R.id.tv_item_time);
            ivThumbnail = itemView.findViewById(R.id.iv_item_thumbnail);
        }
    }
}
