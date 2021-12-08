package vp.videoplayer.mvvm.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vp.videoplayer.mvvm.Models.ResultsItem
import vp.videoplayer.mvvm.R

class MyAdapter(var context: Context,var list: List<ResultsItem>): RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view= LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        Log.d("ALI",list.size.toString()+"Adapter")
        return list.size

    }
}