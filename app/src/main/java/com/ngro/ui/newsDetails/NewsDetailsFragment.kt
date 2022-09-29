package com.ngro.ui.newsDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ngro.databinding.FragmentNewsDetailsBinding
import com.ngro.utils.ImageUtil

class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    private val args: com.ngro.ui.newsDetails.NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsDetails = args.newsDetails
        if (!newsDetails.media.isEmpty())
            ImageUtil.displayImage(
                newsDetails.media[0].mediaMetaDataList[1].url,
                binding.bannerImageView
            )
        binding.titleImageView.text = newsDetails.title
        binding.abstractTextView.text = newsDetails.abstract
    }
}