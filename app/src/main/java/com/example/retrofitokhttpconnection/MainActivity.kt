package com.example.retrofitokhttpconnection

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitokhttpconnection.adapter.MovieAdapter
import com.example.retrofitokhttpconnection.databinding.ActivityMainBinding
import com.example.retrofitokhttpconnection.models.Movie
import com.example.retrofitokhttpconnection.retrofit.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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


        RetrofitClient.retrofitService().getMarvel()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    result ->
                            movieAdapter.list = result


                },{
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                }
            )
        binding.rvMain.adapter = movieAdapter
    }
}