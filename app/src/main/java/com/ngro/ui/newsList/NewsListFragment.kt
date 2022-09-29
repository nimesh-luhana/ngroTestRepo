package com.ngro.ui.newsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngro.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private val viewModel by viewModels<NewsListFragmentViewModel>()
    private lateinit var binding: FragmentNewsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsListAdapter = NewsListAdapter(listOf()) { position ->
            val newsDetails = viewModel.newsListLD.value!!.results[position]
            findNavController().navigate(com.ngro.ui.newsList.NewsListFragmentDirections.startNewsDetailsFragment(newsDetails))
        }
        binding.newsListRecyclerView.adapter = newsListAdapter
        if (context != null)
            binding.newsListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.newsListLD.observe(viewLifecycleOwner) { newsList ->
            (binding.newsListRecyclerView.adapter as NewsListAdapter).newsList = newsList.results
            (binding.newsListRecyclerView.adapter as NewsListAdapter).notifyDataSetChanged()
        }
        viewModel.getNewsList()
    }
}