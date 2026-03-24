package com.example.careconnect.ui.activity.Articles;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.Article;
import com.example.careconnect.model.NewsResponse;
import com.example.careconnect.api.ApiService;
import com.example.careconnect.network.RetrofitClient;
import com.example.careconnect.ui.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;

public class HealthArticleActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArticleAdapter adapter;
    List<Article> list = new ArrayList<>();

    String API_KEY = "1d9083c49b554c8dadf0dd11a9742311";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ArticleAdapter(list, this);
        recycler.setAdapter(adapter);

        loadNews();
    }

    private void loadNews() {

        ApiService api = RetrofitClient.getInstance().create(ApiService.class);

        // 🔥 IMPORTANT: everything API use करो
        api.getEverything("health", API_KEY)
                .enqueue(new Callback<NewsResponse>() {

                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                        Log.d("API", "Response: " + response);

                        if (response.isSuccessful() && response.body() != null
                                && response.body().articles != null
                                && !response.body().articles.isEmpty()) {

                            list.clear();

                            for (Article a : response.body().articles) {

                                // 🔥 NULL SAFE FILTER
                                if (a.title != null && a.urlToImage != null) {
                                    list.add(a);
                                }
                            }

                            adapter.notifyDataSetChanged();

                            Toast.makeText(HealthArticleActivity.this,
                                    "Loaded: " + list.size(),
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            // 🔥 FALLBACK DATA (IMPORTANT)
                            loadDummyData();

                            Toast.makeText(HealthArticleActivity.this,
                                    "API empty → showing demo",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {

                        Log.e("API ERROR", t.toString());

                        loadDummyData();

                        Toast.makeText(HealthArticleActivity.this,
                                "API Error → demo data",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // 🔥 BACKUP DATA (NEVER EMPTY SCREEN)
    private void loadDummyData() {

        list.clear();

        list.add(new Article(
                "Health Tips",
                "Drink water daily",
                "https://images.unsplash.com/photo-1505751172876-fa1923c5c528"
        ));

        list.add(new Article(
                "Fitness Guide",
                "Exercise regularly",
                "https://images.unsplash.com/photo-1571019613914-85f342c1d4b4"
        ));

        adapter.notifyDataSetChanged();
    }
}
