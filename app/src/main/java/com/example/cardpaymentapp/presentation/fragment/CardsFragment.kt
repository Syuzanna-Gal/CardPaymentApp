package com.example.cardpaymentapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
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
        CardsAdapter(listOf())
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
        with(binding) {
            vpCards.adapter = cardsAdapter

            btnPay.setOnClickListener {
                cardsAdapter.getItem(vpCards.currentItem)?.let {
                    viewModel.payWithCard(it, etPaymentAmount.text.toString().toInt())
                }
            }

            etPaymentAmount.doOnTextChanged { text, _, _, _ ->
                btnPay.isEnabled = !text.isNullOrEmpty()
            }
        }
    }

    private fun initObservers() {
        collectWhenStarted(viewModel.cardsList) { cardsList ->
            cardsAdapter.submitList(cardsList)
        }

        collectWhenStarted(viewModel.showError) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        collectWhenStarted(viewModel.showSuccess) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            binding.etPaymentAmount.setText("")
        }
    }
}