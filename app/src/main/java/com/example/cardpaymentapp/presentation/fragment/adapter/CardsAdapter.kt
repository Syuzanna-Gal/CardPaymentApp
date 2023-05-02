package com.example.cardpaymentapp.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardpaymentapp.R
import com.example.cardpaymentapp.databinding.ItemCardBinding
import com.example.cardpaymentapp.entity.CardModel
import com.example.cardpaymentapp.entity.enums.CardType

class CardsAdapter(private var cardList: List<CardModel>) :
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    fun submitList(cardList: List<CardModel>) {
        this.cardList = cardList
        this.notifyItemRangeChanged(0, cardList.size)
    }

    fun getItem(index: Int): CardModel? = this.cardList.getOrNull(index)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(cardList[holder.adapterPosition])
    }

    class CardViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {

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