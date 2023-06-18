package com.example.ahmedalitask.presentation.listProducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ahmedalitask.databinding.FragmentListProductsBinding
import com.example.ahmedalitask.utils.extentions.gone
import com.example.ahmedalitask.utils.extentions.linearLayoutManager
import com.example.ahmedalitask.utils.extentions.visible
import com.example.domain.entities.ProductsItem


class ListProductsFragment : Fragment() {
    private val viewModel: ProductsViewModel by viewModels({ requireActivity() })
    private lateinit var binding: FragmentListProductsBinding
    private val productsAdapter by lazy {
        ProductsAdapter(::onItemClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewProducts()
        getProducts()
    }

    private fun getProducts() {
        viewModel.getProducts()

        viewModel.products.observe(requireActivity()) {
            it?.let { updateUi(it) }
        }
    }

    private fun updateUi(viewStates: ProductsViewStates) {
        with(binding) {
            when (viewStates) {
                ProductsViewStates.Loading -> {
                    loadingView.visible()
                    rvProducts.gone()
                    errorView.gone()
                }
                is ProductsViewStates.Content -> {
                    loadingView.gone()
                    rvProducts.visible()
                    errorView.gone()
                    productsAdapter.setData(viewStates.productList)
                }
                is ProductsViewStates.Error -> {
                    loadingView.gone()
                    rvProducts.gone()
                    errorView.apply {
                        visible()
                        text = viewStates.msg
                    }
                }

            }
        }
    }

    private fun setupRecyclerViewProducts() {
        binding.rvProducts.apply {
            linearLayoutManager()
            setHasFixedSize(true)
            adapter = productsAdapter
        }
    }

    private fun onItemClicked(productItem: ProductsItem) {
        findNavController().navigate(
            ListProductsFragmentDirections.actionListProductsFragmentToProductDetailsFragment(
                productItem
            )
        )
    }


}