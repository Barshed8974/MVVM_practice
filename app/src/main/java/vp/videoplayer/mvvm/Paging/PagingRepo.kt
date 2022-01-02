package vp.videoplayer.mvvm.Paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PagingRepo {
    fun getPageList()=Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 70,
        ),
        pagingSourceFactory = {MyPagingSource()}
    ).liveData
}