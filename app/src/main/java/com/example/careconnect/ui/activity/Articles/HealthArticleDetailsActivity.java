package com.example.careconnect.ui.activity.Articles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.careconnect.R;

public class HealthArticleDetailsActivity extends AppCompatActivity {

    TextView title, content;
    ImageView image;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        image = findViewById(R.id.image);
        share = findViewById(R.id.shareBtn);

        String t = getIntent().getStringExtra("title");
        String d = getIntent().getStringExtra("desc");
        String img = getIntent().getStringExtra("image");

        title.setText(t);
        content.setText(d);

        Glide.with(this).load(img).into(image);

        // 🔥 SHARE
        share.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, t + "\n\n" + d);
            startActivity(Intent.createChooser(i, "Share via"));
        });
    }
}