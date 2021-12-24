package com.jagertech.youtubeapi.view.adapter

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jagertech.youtubeapi.R
import com.jagertech.youtubeapi.model.api.dataformat.Items

class VideoListAdapter(private val listener: VideosListAdapterInteraction) :
    RecyclerView.Adapter<VideoListAdapter.VideosListViewHolder>() {

    lateinit var context: Context
    var dataList = listOf<Items>()

    interface VideosListAdapterInteraction {
        fun onVideoItemClick(userName: String)
    }

    inner class VideosListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoItem: ConstraintLayout = itemView.findViewById(R.id.video_item)
        private val videoThumbnail: ImageView = itemView.findViewById(R.id.video_thumbnail)
        private val videoDescription: AppCompatTextView = itemView.findViewById(R.id.video_title)
        private val userAvatar: ImageView = itemView.findViewById(R.id.user_avatar)
        private val userName: AppCompatTextView = itemView.findViewById(R.id.user_name)
        private val publishTime: AppCompatTextView = itemView.findViewById(R.id.publish_time)

        fun bind(item: Items) {
            videoDescription.text = item.snippet.title
            userName.text = item.snippet.channelTitle
            publishTime.text = item.snippet.publishTime
            videoItem.setOnClickListener {
                listener.onVideoItemClick(item.id.videoId)
            }
            Glide.with(context)
                .load(item.snippet.thumbnails.high.url)
                .apply(RequestOptions.centerCropTransform())
                .into(videoThumbnail)

//            Glide.with(context)
//                .load(item.snippet.)
//                .apply(RequestOptions.circleCropTransform())
//                .into(videoThumbnail)
        }
    }

    override fun onBindViewHolder(holder: VideosListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosListViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_video, parent, false)
        return VideosListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}