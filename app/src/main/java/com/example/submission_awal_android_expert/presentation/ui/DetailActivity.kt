package com.example.submission_awal_android_expert.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.submission_awal_android_expert.R
import com.example.submission_awal_android_expert.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding

    private var title : String? = null
    private var img : String? = null
    private var rating : String? = null
    private var minSpec : String? = null
    private var recSpec : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        img = intent.getStringExtra(IMG)
        title = intent.getStringExtra(TITLE)
        rating = intent.getStringExtra(RATINGS)
        minSpec = intent.getStringExtra(MINSPEC)
        recSpec = intent.getStringExtra(RECSPEC)

        binding?.tvJudulGame?.text = title
        binding?.tvRatings?.text = rating
        binding?.tvMinSpek?.text = minSpec
        binding?.tvRecSpek?.text = recSpec
        binding?.ivGame?.let { Glide.with(this).load(img).fitCenter().into(it) }

        Log.d(TAG,"minimum: $minSpec")
        Log.d(TAG,"rec: $recSpec")
    }

    companion object {
        private const val TAG = "DetailActivity"
        private const val ID_GAME = "IdGame"
        private const val IMG = "ImgGame"
        private const val TITLE = "TitleGame"
        private const val RATINGS = "Ratings"
        private const val MINSPEC = "MinSpec"
        private const val RECSPEC = "RecSpec"
    }
}