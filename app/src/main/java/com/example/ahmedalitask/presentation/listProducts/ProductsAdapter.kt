package com.example.ahmedalitask.presentation.listProducts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ahmedalitask.R
import com.example.ahmedalitask.databinding.ItemProductBinding
import com.example.ahmedalitask.utils.extentions.load
import com.example.domain.entities.ProductsItem


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */
class ProductsAdapter(val onItemClicked: (ProductsItem) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private var data = ArrayList<ProductsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun setData(products: List<ProductsItem>) {
        this.data = products as ArrayList<ProductsItem>
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productsItem: ProductsItem) {
            val binding = ItemProductBinding.bind(itemView)

            with(binding) {

                tvProductTitle.text = productsItem.title
                tvPrice.text = "${productsItem.price} $"
                ivProductImage.load(productsItem.image)

                itemView.setOnClickListener {
                    onItemClicked(productsItem)
                }

            }


        }

    }
}