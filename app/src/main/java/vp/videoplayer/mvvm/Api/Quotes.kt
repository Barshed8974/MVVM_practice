package vp.videoplayer.mvvm.Api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import vp.videoplayer.mvvm.Models.ResultsItem

interface Quotes {
    @GET("quotes")
    suspend fun getQuotes(@Query("page") page:Int) :Response<vp.videoplayer.mvvm.Models.Response>

}