package com.example.submission_awal_android_expert.help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission_awal_android_expert.R
import com.example.submission_awal_android_expert.data.response.ResultsItem

class gameAdapter(private val games : List<ResultsItem?>?, private val context: Context) : RecyclerView.Adapter<gameAdapter.MyGameViewHolder>() {
    inner class MyGameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvJudul : TextView =itemView.findViewById(R.id.tv_judul_game)
        private val tvJDesk : TextView =itemView.findViewById(R.id.tv_desk_game)
        private val ivImage : ImageView = itemView.findViewById(R.id.iv_riwayat_deteksi)

        fun bind(game:ResultsItem) {
            Glide.with(context).load(game.backgroundImage).circleCrop().fitCenter().into(ivImage)
            tvJudul.text = game.name
            tvJDesk.text = game.rating.toString()

            itemView.setOnClickListener {
                Toast.makeText(context,game.name.toString(),Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return MyGameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return games!!.size
    }

    override fun onBindViewHolder(holder: MyGameViewHolder, position: Int) {
        val gameB = games!![position]
        holder.bind(gameB!!)
    }
}