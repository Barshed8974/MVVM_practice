package vp.videoplayer.mvvm.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import vp.videoplayer.mvvm.Api.Network
import vp.videoplayer.mvvm.Models.ResultsItem

class MyPagingSource: PagingSource<Int,ResultsItem>() {

    private val apiservices= Network.getApiServices()
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        val pagenumber=params.key?:1
        val quotes=apiservices.getQuotes(pagenumber)
        val quoteList:List<ResultsItem> = quotes.results as List<ResultsItem>
        return try {
            LoadResult.Page(
                data = quoteList,
                prevKey = null,
                nextKey =if (quoteList.isEmpty()) null else pagenumber+1
            )
        }
        catch (exception:Exception)
        {
            LoadResult.Error(exception)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        //returns the most recent access
        return state.anchorPosition
    }

}