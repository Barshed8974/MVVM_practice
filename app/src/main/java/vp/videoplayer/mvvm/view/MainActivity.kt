package vp.videoplayer.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import vp.videoplayer.mvvm.Api.Network
import vp.videoplayer.mvvm.Api.Quotes
import vp.videoplayer.mvvm.Models.ResultsItem
import vp.videoplayer.mvvm.R
import vp.videoplayer.mvvm.Repository.QuoteRepo
import vp.videoplayer.mvvm.viewModel.MainViewModel
import vp.videoplayer.mvvm.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private var list= listOf<ResultsItem>()
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotes=Network.getInstance().create(Quotes::class.java)
        Log.d("ALI","Main1")
        val repo=QuoteRepo(quotes)
        Log.d("ALI","Main 2")
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModel::class.java)
        Log.d("ALI","Main 3")

        mainViewModel.quotes.observe(this, Observer { it ->
            Log.d("ALI",it.count.toString())
            if(it.results!=null) {
                list = it.results as List<ResultsItem>
                myAdapter= MyAdapter(this,list)
                recycler.adapter=myAdapter
                recycler.layoutManager=LinearLayoutManager(this)
            }

        })
        Log.d("ALI",list.size.toString()+"main")
    }
}