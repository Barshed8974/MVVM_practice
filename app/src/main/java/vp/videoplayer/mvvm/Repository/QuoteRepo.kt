package vp.videoplayer.mvvm.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vp.videoplayer.mvvm.Api.Quotes
import vp.videoplayer.mvvm.Models.Response
import vp.videoplayer.mvvm.Models.ResultsItem

class QuoteRepo(private val quotes: Quotes) {
    private  val quotesLiveData= MutableLiveData<Response>()

    val quotesList : LiveData<Response>
    get() = quotesLiveData

    suspend fun getQuotes(page:Int)
    {
        val result=quotes.getQuotes(page)
        Log.d("ALI","Repo")
        if(result.body() !=null)
            quotesLiveData.postValue(result.body())
        else
            Log.d("ALI","Repo")
    }
}
