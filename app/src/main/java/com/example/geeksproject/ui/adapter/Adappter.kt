package com.example.geeksproject.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.geeksproject.databinding.FragmentImageBinding
import com.example.geeksproject.databinding.ItemImageBinding
import com.example.geeksproject.model.GeekModel
import kotlin.coroutines.coroutineContext


class Adappter : RecyclerView.Adapter<Adappter.ViewHolder>() {

    private var arrayList: ArrayList<GeekModel> = ArrayList()

    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: GeekModel) {
            Glide.with(binding.img).load(model.img).into(binding.img)
            with(binding) {
                name.text = model.name
                date.text = model.data.toString()
            }
        }
    }

    fun setList(list: ArrayList<GeekModel>) {
        arrayList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size
}