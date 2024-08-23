package com.example.submission_awal_android_expert.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission_awal_android_expert.R
import com.example.submission_awal_android_expert.data.response.ResultsItem
import com.example.submission_awal_android_expert.presentation.ui.DetailActivity

class gameAdapter(private val games : List<ResultsItem?>?, private val context: Context) : RecyclerView.Adapter<gameAdapter.MyGameViewHolder>() {
    inner class MyGameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvJudul : TextView =itemView.findViewById(R.id.tv_judul_game)
        private val tvJDesk : TextView =itemView.findViewById(R.id.tv_desk_game)
        private val ivImage : ImageView = itemView.findViewById(R.id.iv_riwayat_deteksi)

        fun bind(game:ResultsItem) {
            val img = game.backgroundImage
            Glide.with(context).load(img).circleCrop().fitCenter().into(ivImage)
            tvJudul.text = game.name
            tvJDesk.text = game.rating.toString()
            val idGame = game.id
            val rating = game.rating.toString()

            var min : String? = null
            var rec : String? = null

            game.platforms?.forEach { pf ->
                val requirements = pf?.requirementsEn
                if (requirements != null) {
                    if (requirements.minimum != null) {
                        min = requirements.minimum
                    }
                    if (requirements.recommended != null) {
                        rec = requirements.recommended
                    }
                }
            }

                itemView.setOnClickListener {
                        val intent = Intent(context, DetailActivity::class.java).apply {
                            putExtra(IMG, img)
                            putExtra(TITLE, tvJudul.text.toString())
                            putExtra(RATINGS, rating)
                            putExtra(MINSPEC, min)
                            putExtra(RECSPEC, rec)
                        }
                        context.startActivity(intent)
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

    companion object {
        private const val ID_GAME = "IdGame"
        private const val IMG = "ImgGame"
        private const val TITLE = "TitleGame"
        private const val RATINGS = "Ratings"
        private const val MINSPEC = "MinSpec"
        private const val RECSPEC = "RecSpec"
    }
}