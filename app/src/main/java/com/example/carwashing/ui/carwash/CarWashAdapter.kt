package com.example.carwashing.ui.carwash

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashing.R
import com.example.carwashing.databinding.ItemCarwashBinding
import com.example.carwashing.vo.CarWash

class CarWashAdapter(
    private val carwashes: List<CarWash>,
    private val listener: (item: CarWash, pos: Int) -> Unit
) : RecyclerView.Adapter<CarWashAdapter.CarWashViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarWashViewHolder {
        val binding = DataBindingUtil.inflate<ItemCarwashBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_carwash,
            parent,
            false
        )
        Log.v("ONCREATE_TAG", carwashes.toString())
        return CarWashViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarWashViewHolder, position: Int) {
        val currentCarwash = carwashes[position]
        holder.binding.carwash = currentCarwash
        holder.binding.apply {
            Log.v("NAME_TAG", currentCarwash.toString())
            nameId.text = currentCarwash.name
            addressId.text = currentCarwash.address
            ratingId.rating = if (currentCarwash.rating==null) {
                0f
            } else {
                currentCarwash.rating!!
            }
            root.setOnClickListener {
                listener(currentCarwash, position)
            }
        }

    }

    override fun getItemCount(): Int {
        return carwashes.size
    }

    fun getData(): List<CarWash>{
        return carwashes
    }

    inner class CarWashViewHolder(val binding: ItemCarwashBinding) : RecyclerView.ViewHolder(binding.root)
}