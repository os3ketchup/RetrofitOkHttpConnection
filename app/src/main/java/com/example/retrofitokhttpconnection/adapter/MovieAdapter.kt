package com.example.retrofitokhttpconnection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitokhttpconnection.databinding.ItemRvBinding
import com.example.retrofitokhttpconnection.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter( var list: List<Movie>):RecyclerView.Adapter<MovieAdapter.VH>() {

    inner class VH(private var itemRV: ItemRvBinding): RecyclerView.ViewHolder(itemRV.root){
        fun onBind(movie: Movie){
            Picasso.get().load(movie.imageurl).into(itemRV.ivMovie)
            itemRV.tvMovie.text = movie.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}