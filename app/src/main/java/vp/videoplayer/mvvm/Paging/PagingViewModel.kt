package vp.videoplayer.mvvm.Paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import vp.videoplayer.mvvm.Models.ResultsItem

class PagingViewModel:ViewModel() {
    private val repo=PagingRepo()
    fun searchQuotes()=repo.getPageList()

}