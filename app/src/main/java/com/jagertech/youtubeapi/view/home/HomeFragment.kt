package com.jagertech.youtubeapi.view.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jagertech.youtubeapi.R
import com.jagertech.youtubeapi.databinding.FragmentHomeBinding
import com.jagertech.youtubeapi.model.api.dataformat.Items
import com.jagertech.youtubeapi.view.adapter.VideoListAdapter
import java.util.Arrays.asList

class HomeFragment : Fragment(), VideoListAdapter.VideosListAdapterInteraction {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private var videoItemList = arrayListOf<Items>()
    private val videoListAdapter = VideoListAdapter(this)

    var isLoading: Boolean = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.searchResultLiveData.observe(viewLifecycleOwner, Observer {
            videoItemList.addAll(it)
            videoListAdapter.notifyDataSetChanged()
            isLoading = false
        })
        homeViewModel.searchVideo("你要不要吃")
        initAdapter()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        videoListAdapter.dataList = videoItemList
        binding.videoRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.videoRecyclerview.adapter = videoListAdapter
        initScrollListener()
    }

    private fun initScrollListener() {
        binding.videoRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (!isLoading) {
                        loadMore()
                        isLoading = true
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun loadMore() {
        homeViewModel.nextPage()
    }

    override fun onVideoItemClick(userName: String) {
        Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment_content_main)).navigate(R.id.nav_gallery)
    }
}