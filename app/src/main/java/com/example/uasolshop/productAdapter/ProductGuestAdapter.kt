package com.example.uasolshop.productAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uasolshop.databinding.ItemProductsGuestBinding

class ProductGuestAdapter():RecyclerView.Adapter<ProductGuestAdapter.ItemProductGuestViewHolder>() {
    inner class ItemProductGuestViewHolder(private val binding: ItemProductsGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductGuestViewHolder {
        val binding =
            ItemProductsGuestBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
        return ItemProductGuestViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ItemProductGuestViewHolder, position: Int) {
    }
}