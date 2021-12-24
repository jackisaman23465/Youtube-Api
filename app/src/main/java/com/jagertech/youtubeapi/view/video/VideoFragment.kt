package com.jagertech.youtubeapi.view.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.jagertech.youtubeapi.databinding.FragmentHomeBinding
import com.jagertech.youtubeapi.databinding.FragmentVideoBinding
import timber.log.Timber

class VideoFragment: Fragment(), YouTubePlayer.OnInitializedListener {

    private lateinit var _binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoBinding.inflate(inflater,container,false)
        _binding.video.initialize("htyhry",this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youtubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (youtubePlayer == null) {
            Timber.d("CheckPoint youtubePlayer == null");
            return;
        }

        if (!wasRestored) {
            Timber.d("CheckPoint !wasRestored");
            youtubePlayer.cueVideo("TRDV0xw3j4Y");
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }
}