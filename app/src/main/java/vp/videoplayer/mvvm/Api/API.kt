package vp.videoplayer.mvvm.Api

import retrofit2.http.GET
import retrofit2.http.Query
import vp.videoplayer.mvvm.Models.Response

interface API {
    @GET("quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response
}