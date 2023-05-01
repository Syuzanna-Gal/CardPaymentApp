package com.example.cardpaymentapp.presentation.cardsFragment.adapter

import android.view.View
import com.example.cardpaymentapp.R
import com.example.cardpaymentapp.entity.CardModel
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

        //private val binding = BrandItemBinding.bind(view)

        fun onBind(item: CardModel) {

        }
    }
}