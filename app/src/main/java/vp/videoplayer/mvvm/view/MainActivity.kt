package vp.videoplayer.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import vp.videoplayer.mvvm.Api.Network
import vp.videoplayer.mvvm.Api.Quotes
import vp.videoplayer.mvvm.Models.ResultsItem
import vp.videoplayer.mvvm.Paging.MyPagingAdapter
import vp.videoplayer.mvvm.Paging.PagingViewModel
import vp.videoplayer.mvvm.R
import vp.videoplayer.mvvm.Repository.QuoteRepo
import vp.videoplayer.mvvm.viewModel.MainViewModel
import vp.videoplayer.mvvm.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
//    lateinit var mainViewModel: MainViewModel
//    private var list= listOf<ResultsItem>()
//    lateinit var myAdapter: MyAdapter

    lateinit var pagingViewModel: PagingViewModel
    lateinit var pagingAdapter: MyPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val quotes=Network.getInstance().create(Quotes::class.java)
//        val repo=QuoteRepo(quotes)
//        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModel::class.java)
//
//        mainViewModel.quotes.observe(this, Observer { it ->
//            if(it.results!=null) {
//                list = it.results as List<ResultsItem>
//                myAdapter= MyAdapter(this,list)
//                recycler.adapter=myAdapter
//                recycler.layoutManager=LinearLayoutManager(this)
//            }
//
//        })
        pagingViewModel=ViewModelProvider(this).get(PagingViewModel::class.java)
        setAdapter()
        pagingViewModel.searchQuotes().observe(this,{
            it?.let {
                CoroutineScope(Main).launch {
                    pagingAdapter.submitData(it)
                }
            }
        })
    }

    private fun setAdapter() {
        pagingAdapter= MyPagingAdapter()
        val linearLayoutManager=LinearLayoutManager(this)
        recycler.apply {
            layoutManager=linearLayoutManager
            adapter=pagingAdapter
        }
    }
}