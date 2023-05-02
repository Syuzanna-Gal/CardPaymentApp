package com.example.cardpaymentapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardpaymentapp.R
import com.example.cardpaymentapp.databinding.FragmentCardsBinding
import com.example.cardpaymentapp.presentation.fragment.adapter.CardsAdapter
import com.example.cardpaymentapp.presentation.utils.extensions.collectWhenStarted
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardsFragment() : Fragment(R.layout.fragment_cards) {

    private val binding by lazy {
        FragmentCardsBinding.inflate(LayoutInflater.from(requireContext()))
    }
    private val viewModel: CardsViewModel by viewModel()
    private val cardsAdapter by lazy {
        CardsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        viewModel.getCards()
        with(binding) {
            rvCards.adapter = cardsAdapter.adapter
        }
    }

    private fun initObservers() {
        collectWhenStarted(viewModel.cardsList) { cardsList ->
            cardsList?.let {
                cardsAdapter.adapter.submitList(it)
            }
        }
    }
}