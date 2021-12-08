package vp.videoplayer.mvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vp.videoplayer.mvvm.Models.Response
import vp.videoplayer.mvvm.Models.ResultsItem
import vp.videoplayer.mvvm.Repository.QuoteRepo

class MainViewModel(private val repo: QuoteRepo) : ViewModel() {
    init {
        Log.d("ALI","Model")
        viewModelScope.launch (Dispatchers.IO){
            repo.getQuotes(1)
        }
    }
    val quotes:LiveData<Response>
    get() = repo.quotesList
}