package vp.videoplayer.mvvm.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vp.videoplayer.mvvm.Repository.QuoteRepo

class MainViewModelFactory(private  val repo: QuoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ALI","Factory")
        return MainViewModel(repo) as T
    }
}