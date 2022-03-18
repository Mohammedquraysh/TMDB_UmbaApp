package com.example.umbatmdbapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umbatmdbapplication.databinding.LatestMoviesRecyclerviewBinding
import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
import com.example.umbatmdbapplication.util.Functions
import com.squareup.picasso.Picasso

class LatestMoviesAdapter(): RecyclerView.Adapter<LatestMoviesAdapter.LatestMoviesViewHolder>()  {
    var listOfLatestMovies = ArrayList<LatestMoviesModel>()
    private lateinit var nListener: OnItemClickListener


    interface OnItemClickListener{

        fun onItemClick(position:Int,value: View?)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        nListener = listener
    }


    fun setUpdatedData(movies: ArrayList<LatestMoviesModel>){
        this.listOfLatestMovies = movies
        notifyDataSetChanged()

    }


    inner class LatestMoviesViewHolder(binding: LatestMoviesRecyclerviewBinding, listener: OnItemClickListener ):RecyclerView.ViewHolder(binding.root){
        val imageThumbLatestMovies = binding.ivLatestMoviesImageThumb
        val titleLatestMovies = binding.tvTitleLatestMovies


        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition,itemView)
            }
        }

        fun bindViews(data: LatestMoviesModel){
            titleLatestMovies.text = data.original_title
            val myUrl = data.poster_path
            //  tvDesc.text = data.description


           // Glide.with(requireContext(context)).load(image).placeholder(R.drawable.car_place_holder).into(binding.ivVINIdentificationVehicleSpecificationFragmentCarImage)
           // "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg/"
            val getImageNumber = Functions.getUrlNumber(myUrl)
            Picasso.get()
                .load(myUrl)
                .into(imageThumbLatestMovies)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestMoviesViewHolder {
        val binding = LatestMoviesRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LatestMoviesViewHolder(binding,nListener)
    }

    override fun onBindViewHolder(holder: LatestMoviesViewHolder, position: Int) {
        holder.bindViews(listOfLatestMovies.get(position))
    }

    override fun getItemCount(): Int {
        return listOfLatestMovies.size
    }
}