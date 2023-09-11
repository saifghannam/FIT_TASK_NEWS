package com.example.fit_task_news.Modle

data class Headlines (

    val articles: List<Article>? = ArrayList(),
    val status:String?=null,
    val totalResults:Int

)

