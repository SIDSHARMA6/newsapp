package com.application.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.application.newsapp.ui.MainActivity
import com.application.newsapp.ui.NewsViewModel
import com.example.News.R
import com.example.News.databinding.FragmentArticleBinding
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var newsViewModel: NewsViewModel
    private val args:ArticleFragmentArgs by navArgs()
    private lateinit var binding:FragmentArticleBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentArticleBinding.bind(view)
        newsViewModel=(activity as MainActivity).newsViewModel
        val article=args.article
        binding.webView.apply{
            webViewClient= WebViewClient()
            article.url?.let {


                loadUrl(it)
            }
        }
        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view,"Added to Favourites",Snackbar.LENGTH_LONG).show()

        }
    }
}