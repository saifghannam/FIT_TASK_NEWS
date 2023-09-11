package com.example.fit_task_news.Modle

data class Article(

    val author: String? = "",

    val content: String? = "",

    val description: String? = "",

    val publishedAt: String? = "",

    val source: Source? = Source(),

    val title: String? = "",

    val url: String? = "",

    val urlToImage: String? = ""
)