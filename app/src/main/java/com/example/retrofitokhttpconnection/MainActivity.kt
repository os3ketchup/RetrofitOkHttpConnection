package com.example.retrofitokhttpconnection

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitokhttpconnection.adapter.MovieAdapter
import com.example.retrofitokhttpconnection.databinding.ActivityMainBinding
import com.example.retrofitokhttpconnection.models.Movie
import com.example.retrofitokhttpconnection.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: List<Movie>
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()


        RetrofitClient.retrofitService().getMarvel().enqueue(object :Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful){
                    list = response.body()!!
                    binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
                    movieAdapter = MovieAdapter(list)
                    binding.rvMain.adapter = movieAdapter
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "internet error!!!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}