package com.example.paperly.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paperly.AdapterRvNews;
import com.example.paperly.Article;
import com.example.paperly.R;

import java.util.ArrayList;

public class FragmentNews extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_news, container, false);

        /*
        Tải danh sách bài báo
        */
        ArrayList<Article> arlNews = new ArrayList<>();
        arlNews.add(new Article("Bài 1", "đây là bài 1", "https://static.thanhnien.com.vn/thanhnien.vn/image/logo-share.jpg", "1h trước", "Báo Xuân Phát", "https://thanhnien.vn/3-nguoi-giau-nhat-the-gioi-deu-co-mat-o-le-nham-chuc-cua-ong-trump-18525011515062539.htm"));

        RecyclerView rvNews = view.findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterRvNews adapter = new AdapterRvNews(arlNews, getContext());
        rvNews.setAdapter(adapter);


        return view;

    }
}
