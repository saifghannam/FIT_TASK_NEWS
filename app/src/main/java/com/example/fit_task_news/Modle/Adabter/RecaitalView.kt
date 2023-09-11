package com.example.fit_task_news.Modle.Adabter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_task_news.Modle.Article
import com.example.fit_task_news.R

class RecaitalView:RecyclerView.Adapter<RecaitalView.UserViewHolder>() {

    var listOfData:ArrayList<Article> = ArrayList()

    fun setList(arrayList: ArrayList<Article>){
        this.listOfData=arrayList
        notifyDataSetChanged()


    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_image: ImageView =itemView.findViewById(R.id.Img_NEWS_ID)
        var tv_textTitle: TextView =itemView.findViewById(R.id.Title_News_ID)
        var tv_textDescrpition: TextView =itemView.findViewById(R.id.Descrpition_News_ID)
        var tv_textAuter: TextView =itemView.findViewById(R.id.Auter_News_ID)



        fun bind(apiData: Article){

            tv_textTitle.text=apiData.title
            tv_textDescrpition.text=apiData.description
            tv_textAuter.text=apiData.author
            Glide.with(itemView.context)
                .load(apiData.urlToImage)
                .error(R.drawable.baseline_error_24)
                .into(tv_image)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var abd:Article=listOfData[position]

        holder.bind(abd)
    }
}