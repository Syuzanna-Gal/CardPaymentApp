package com.example.cardpaymentapp.presentation.fragment.adapter

import android.view.View
import com.example.cardpaymentapp.R
import com.example.cardpaymentapp.databinding.ItemCardBinding
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.enums.CardType
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class CardsAdapter(

) {
    val adapter = adapterOf<CardModel> {
        diff(
            areItemsTheSame = { old, new ->
                old.id == new.id
            },
            areContentsTheSame = { old, new ->
                old == new
            }
        )
        register(
            layoutResource = R.layout.item_card,
            viewHolder = {
                CardViewHolder(it)
            },
            onBindViewHolder = { vh, _, p -> vh.onBind(p) }
        )
    }

    class CardViewHolder(
        view: View,
    ) : RecyclerViewHolder<CardModel>(view) {

        private val binding = ItemCardBinding.bind(view)

        fun onBind(item: CardModel) {
            with(binding) {
                tvCardName.text = item.name
                tvCardBalance.text = item.balance.toString()
                tvCardAvailableTime.text = item.validUntil
                when (item.type) {
                    CardType.VISA -> ivCardType.setBackgroundResource(R.drawable.visa_logo)
                    CardType.MASTER -> ivCardType.setBackgroundResource(R.drawable.mastercard_logo)
                }
            }
        }
    }
}