package com.example.fit_task_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.RecyclerView
import com.example.fit_task_news.Modle.Adabter.RecaitalView
import com.example.fit_task_news.Modle.Article
import com.example.fit_task_news.Modle.Headlines
import com.example.fit_task_news.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    var listData:ArrayList<Article> = ArrayList()

    // var recitalView:RecaitalView=RecaitalView()   Create Ojecte


    val recitalView: RecaitalView by lazy {
        RecaitalView()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Call API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val servesAPI = retrofit.create(ServesAPI::class.java)

        val call: Call<List<Headlines>> =
            servesAPI.getPost("us", "517c6e4f02a24c6f821dd5dbae4cc53e")
        call.enqueue(object : Callback<List<Headlines>> {
            override fun onResponse(
                call: Call<List<Headlines>>,
                response: Response<List<Headlines>>
            ) {
                for (x in 0..8){
                    listData.add(
                    Article(
                        response.body()!!.get(x).articles!![x].title,
                        response.body()!!.get(x).articles!![x].description,
                        response.body()!!.get(x).articles!![x].author,
                        response.body()!!.get(x).articles!![x].urlToImage,

                    )
                )

                }
            }

            override fun onFailure(call: Call<List<Headlines>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })}}

