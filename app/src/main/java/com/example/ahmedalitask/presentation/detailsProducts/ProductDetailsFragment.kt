package com.example.ahmedalitask.presentation.detailsProducts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.ahmedalitask.databinding.FragmentProductDetailsBinding
import com.example.ahmedalitask.utils.extentions.load
import com.example.domain.entities.ProductsItem


class ProductDetailsFragment : Fragment() {
    private val args: ProductDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()

    }

    @SuppressLint("SetTextI18n")
    private fun setContent() {
        val productItem = args.productItem

        with(binding) {
            ivProductImage.load(productItem.image)
            tvTitle.text = productItem.title
            tvPrice.text = productItem.price.toString() + " $"
            tvDes.text = productItem.description
            productItem.rating?.let { ratingBar.rating = it.rate.toFloat() }
        }
    }


}