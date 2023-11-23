package com.dkgtech.productsapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.productsapi.databinding.ProductRowBinding
import com.dkgtech.productsapi.model.Product
import com.squareup.picasso.Picasso

class RecyclerProductsAdapter(val context: Context, val arrProducts: List<Product>) :
    RecyclerView.Adapter<RecyclerProductsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProductRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrProducts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val data = arrProducts[position]
            Picasso.get().load(data.thumbnail).into(imgProductImage)
            txtBrand.text = data.brand
            txtTitle.text = data.title
            txtRating.text = "${data.rating}"
            txtPrice.text = "\u20B9 ${data.price}"
        }
    }
}