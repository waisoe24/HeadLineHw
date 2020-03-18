package com.example.headline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.headline.adapter.HeadAdapter
import com.example.headline.api.HeadApiInterface
import com.example.headline.model.Article
import com.example.headline.model.New
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getArticle()
    }

    fun getArticle() {

        var BASE_URL = "https://newsapi.org/v2/"

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(HeadApiInterface::class.java)

        var apiCall = retrofitService.getNews(
            "ch",
            "business", "34500a0a110c4cd19a015b6eb3c9c0ea"
        )

        apiCall.enqueue(object : Callback<New> {

            override fun onFailure(call: Call<New>, t: Throwable) {
                Log.d("Failure>>>", t.toString())
            }
            override fun onResponse(call: Call<New>, response: Response<New>) {
                var headList = response.body()?.articles
                Log.d("Response>>>>>>>", headList.toString())
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerview.adapter = HeadAdapter(headList as ArrayList<Article>)
            }
        })
    }
}
