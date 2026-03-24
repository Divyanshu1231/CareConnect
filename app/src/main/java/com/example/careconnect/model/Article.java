package com.example.careconnect.model;

public class Article {

    public String title;
    public String description;
    public String urlToImage;

    // 🔥 EMPTY constructor (Retrofit के लिए जरूरी)
    public Article() {
    }

    // 🔥 CUSTOM constructor (manual add के लिए)
    public Article(String title, String description, String urlToImage) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
    }
}