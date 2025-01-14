package com.sf.healthylifestyle.view.basket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sf.healthylifestyle.databinding.ItemBasketBinding
import com.sf.healthylifestyle.domain.models.Dish

class BasketAdapter(
    private val onCloseClick: (id: Int) -> Unit,
    private val onImgClick: (id: Int) -> Unit,
) : RecyclerView.Adapter<BasketAdapter.InnerBasketViewHolder>() {
    private var basket: MutableList<Dish> = mutableListOf()

    inner class InnerBasketViewHolder(binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var basketRoot = binding.basketRoot
        var imgDish = binding.imgDish
        var tvDescription = binding.tvDescription
        var tvCost = binding.tvCost
        var tvQuantity = binding.tvQuantity
        var btnClose = binding.btnClose
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerBasketViewHolder {
        val binding = ItemBasketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return InnerBasketViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: InnerBasketViewHolder, position: Int) {

        val item = basket[position]

        holder.tvDescription.text = item.title
        holder.tvCost.text = item.price.toString() + " ₽"
        holder.tvQuantity.text = "1"

        Glide.with(holder.basketRoot)
            .load(item.image_extra)
            .centerInside()
            .into(holder.imgDish)

        holder.btnClose.setOnClickListener {
            onCloseClick(item.id)
        }
        holder.imgDish.setOnClickListener {
            onImgClick(item.id)
        }
    }

    override fun getItemCount(): Int = basket.size

    fun getItem(position: Int): Dish = basket[position]

    @SuppressLint("NotifyDataSetChanged")
    fun setData(basket: List<Dish>) {
        this.basket = basket.toMutableList()
        notifyDataSetChanged()
    }
}