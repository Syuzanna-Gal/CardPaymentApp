package com.example.cardpaymentapp.presentation.cardsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cardpaymentapp.R
import com.example.cardpaymentapp.databinding.FragmentCardsBinding
import java.util.*

class CardsFragment : Fragment(R.layout.fragment_cards) {

    private val binding by lazy {
        FragmentCardsBinding.inflate(LayoutInflater.from(requireContext()))
    }
    private val viewModel: CardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
        }
    }
}